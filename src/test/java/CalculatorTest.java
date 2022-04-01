import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(1) // Cause tests to fail if they are too slow
class CalculatorTest {

    @BeforeAll // runs once before the entire test suite
    static void beforeAll() {
        System.out.println("this is printed before all tests are run");
    }

    @BeforeEach // runs before each test
    void beforeEach(TestInfo info) {
        // the test info class can get useful info from each test
        System.out.println("running " + info.getDisplayName());
    }

    @AfterEach // runs once after each test
    @Disabled // skips running the test but keeps it in logging and test coverage
    void afterEach() {
        System.out.println("this is printed after each test is ran");
    }

    @Test
    @DisplayName("addition")
    void testAdder() {
        // this should pass
        assertEquals(3, Calculator.adder(1,2), "1 + 2 = 3");
    }

    @Test
    @DisplayName("subtract")
    void testSubtract() {
        // this should pass
        assertEquals(1, Calculator.subtract(3,2),"3 - 2 = 1");
    }

    @Test
    @Disabled // this one is disabled
    @DisplayName("slowTest")
    void slowTest() throws InterruptedException {
        // this is a slow test
        TimeUnit.SECONDS.sleep(2);
        assertEquals(1, Calculator.subtract(3,2),"this is a slow test");
    }

    @Test
    @DisplayName("test that intentionally fails")
    void isTrue(){
        // this should fail
        assertTrue(Calculator.isTrue("hello", "World"), "string a == string b");
    }

    @Test
    @DisplayName("test x^y")
    void powTest() {
        long expected = 4294967296L;
        int x = 4;
        int y = 16;
        assertEquals(expected, Calculator.pow(x,y), "x raised to the power of y");
    }

    @Test
    @DisplayName("test array len and content")
    void arrayLen() {
        int arrLen = 3;
        String[] arr = {"Foo ","Bar ","World"};
        String[] arrExpected = {"Foo ","Bar ","World"};
        assertEquals(arrLen, arr.length);
        assertArrayEquals(arrExpected, arr);
    }

}