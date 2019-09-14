package test;

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

        assertThat(actual, arrayContaining(5,7,2));
    }

    @Test
    public void checkIfTabContainsSpecifiedValuesInNonSpecifiedOrder() {
        Integer[] tab = {7, 5, 2};

        assertThat(tab, arrayContainingInAnyOrder(5,7,2));

    }

    @Test
    public void checkIfListSizeEquals3AndContainsSpecifiedString() {
        List<String> list = Arrays.asList("raz", "dwa", "trzy");

        assertThat(list, hasItem("dwa"));
        assertThat(list, hasSize(3));

    }

}
