package test;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestTestExamples {

    @Test
    public void is5greaterThan3() {
        assertThat(5, greaterThan(3));
    }

    @Test
    public void isEmptyStringIsEmptyOrNull() {
        assertThat("", isEmptyOrNullString());
    }

    @Test
    public void checkIfStringContainsSpecifiedString() {
        assertThat("jjbeubcejrijwnciwrnracoiennon",
                not(containsString("konfabulacja")));
    }

    @Test
    public void checkIfTabContainsSpecifiedValues() {
        Integer[] actual = {5, 7, 2};

        assertThat(actual, arrayContaining(5, 7, 2));
    }

    @Test
    public void checkIfTabContainsSpecifiedValuesInNonSpecifiedOrder() {
        Integer[] tab = {7, 5, 2};

        assertThat(tab, arrayContainingInAnyOrder(5, 7, 2));
    }

    @Test
    public void checkIfListSizeEquals3AndContainsSpecifiedString() {
        List<String> list = Arrays.asList("raz", "dwa", "trzy");

        assertThat(list, hasItem("dwa"));
        assertThat(list, hasSize(3));

    }

    @Test
    public void shouldBeginWithA() {
        String testedValue = "aString";
        assertThat(testedValue, beginsWith(is('a')));
    }

    public static Matcher<String> beginsWith(Matcher<? super Character> matcher) {
        return new FeatureMatcher<String, Character>(matcher, "a String that begins with", "first letter") {
            @Override
            protected Character featureValueOf(String actual) {
                return actual.charAt(0);
            }
        };
    }

    @Test
    public void checkLengthString() {
        String testValue1 = "ala";
        String testValue2 = "stomil";
        String testValue3 = "antygrawitacja";

        assertThat(testValue1, stringHasLength(is(3)));
        assertThat(testValue2, stringHasLength(is(6)));
        assertThat(testValue3, stringHasLength(is(14)));
    }

    public static Matcher<String> stringHasLength(Matcher<? super Integer> matcher) {
        return new FeatureMatcher<String, Integer>(matcher, "String has expected length equals ",
                "Not expected length") {
            @Override
            protected Integer featureValueOf(String actual) {
                return actual.length();
            }
        };
    }


}
