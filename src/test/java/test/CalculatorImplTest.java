package test;

import org.junit.*;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.Assert.*;

public class CalculatorImplTest {


    private Calculator calculator;

    @BeforeClass
    public static void testAddImplementationMethod() {
        System.out.println("Setting up before class");

    }

    @Before
    public void setUpBeforeEveryTest() {
        System.out.println("Setting up before test");
        calculator = new CalculatorImpl();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("After class");
    }

    @After
    public void tearDownAfterTest() {
        System.out.println("After every test");
    }

    @Test
    public void testAdd() {
        //given
        int a = 2;
        int b = 2;

        int expected = 4;
        // when
        int result = calculator.add(a, b);
        // then
        Assert.assertEquals(expected, result);
        System.out.println("test1");
    }

    @Test
    public void testAdd2() {
        //given
        int a = 2;
        int b = 3;

        int expected = 5;
        // when
        int result = calculator.add(a, b);
        // then
        Assert.assertEquals(expected, result);
        System.out.println("test2");
    }


}