package test;

import org.junit.*;
import org.junit.rules.ExpectedException;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.assertj.core.api.Assertions.*;
import static test.CalculatorImpl.DIV_0_MSG;

public class CalculatorImplTest {

    private Calculator calculator;

    @BeforeClass
    public static void setUpBeforeEveryClass() {
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
    public void shouldDisplayConcatenatedNumbersWhenPressed() {

        // given
        int a = 5;
        int b = 4;
        int c = 3;

        String expected = "543";

        // when
        calculator.pressNumber(a);
        calculator.pressNumber(b);
        calculator.pressNumber(c);

        //then
//        assertEquals(expected, calculator.display());
        assertThat(calculator.display())
                .isEqualTo(expected);
    }

    @Test
    public void shouldDisplayEmptyStringAtStartup() {
        String display = calculator.display();

//        assertTrue(display.isEmpty());
        assertThat(calculator.display())
                .isEmpty();
    }

    @Test
    public void shouldDisplayNumberAfterPress() {

        //given
        int numberToPress = 3;
        String expectedDisplay = "3";

        //when
        calculator.pressNumber(numberToPress);
        String display = calculator.display();

        //then
//        assertEquals(expectedDisplay, display);
        assertThat("3")
                .isEqualTo(calculator.display());
    }

    @Test
    public void clearShouldClearDisplay() {
        // given
        calculator.pressNumber(5);
//        assertEquals("5", calculator.display());

        // when
        calculator.clear();

        //then
//        assertTrue(calculator.display().isEmpty());

    }

    @Test
    public void addShouldDisplayAddedNumbers() {
        assertAddingNumbers(1, 0, "1");
        assertAddingNumbers(5, 10, "15");
        assertAddingNumbers(3, 5, "8");
    }

    private void assertAddingNumbers(int numberA, int numberB, String expected) {
        calculator.add(numberA, numberB);
//        assertEquals(expected, calculator.display());
    }

    @Test
    public void ShouldDisplayCorrectValuesWhenAddingTwice() {
        // given
        int a = 5;
        int b = 5;
        String expected = "10";
        calculator.add(a, b);
//        assertEquals(expected, calculator.display());

        // when
        a = 4;
        b = 10;
        //expected = "14";

        calculator.add(a, b);

        // then
//        assertEquals(expected, calculator.display());
    }

    @Test
    public void addShouldDisplaySubbedNumbers() {
        // given
        int a = 5;
        int b = 4;
        String expected = "1";

        // when
        calculator.sub(a, b);

        // then
//        assertEquals(expected, calculator.display());
    }

    @Test
    public void divShouldDisplayDividedNumbers() {
        int a = 10;
        int b = 2;

        String expected = "5";

        //when
        calculator.div(a, b);

        //then
//        assertEquals(expected, calculator.display());
    }

    @Test
    public void divTwiceShouldDisplayDividedNumbers() {
        int a = 10;
        int b = 2;

        //String expected = "5";
        calculator.div(a, b);

        //when
        a = 5;
        b = 2;

        calculator.div(a, b);
        String expected = "2";
        //then
//        assertEquals(expected, calculator.display());
    }

    @Test
    public void testException() {
//        try {
//            calculator.div(100, 0);
////            fail();
//        } catch (Exception e) {
////            assertTrue(e instanceof IllegalArgumentException);
////            assertEquals(DIV_0_MSG, e.getMessage());
//        }
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.div(100, 0))
                .withMessage(DIV_0_MSG);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testExceptionRule() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(DIV_0_MSG);

        throw new IllegalArgumentException();
    }

}