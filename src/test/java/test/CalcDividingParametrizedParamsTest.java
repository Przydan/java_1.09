package test;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalcDividingParametrizedParamsTest {

    private Calculator calculator;

    @Before
    public void setUpBeforeEveryTest() {
        System.out.println("Set up before test");
        calculator = new CalculatorImpl();
    }

    @Test
    @Parameters({"1, 1, 1", "10, 2, 5"})
    public void shouldAddDifferentNumbers(int a, int b, String expected) {
        // when
        calculator.div(a, b);

        //then
        assertEquals(expected, calculator.display());
    }
}
