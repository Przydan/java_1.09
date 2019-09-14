package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AssertJTestExamples {

    @Test
    public void is5greaterThan3() {
        assertThat(5)
                .isGreaterThan(3);
    }

    @Test
    public void isEmptyStringIsEmptyOrNull() {
        assertThat("")
                .isNullOrEmpty();
    }

    @Test
    public void checkIfStringContainsSpecifiedString() {
        assertThat("iuavecivayvawciuvaavarravacvxn".toLowerCase())
                .doesNotContain("konfabulacja");
    }

    @Test
    public void checkIfTabContainsSpecifiedValues() {
        int[] tab = {5, 7, 2};
        assertThat(tab)
                .containsExactly(5,7,2);
    }

    @Test
    public void checkIfTabContainsSpecifiedValuesInNonSpecifiedOrder() {
        int[] tab = {7, 5, 2};
        assertThat(tab)
                .containsExactlyInAnyOrder(5,7,2);
    }

    @Test
    public void checkIfListSizeEquals3AndContainsSpecifiedString () {
        List<String> list = Arrays.asList("raz" , "dwa", "trzy");

        assertThat(list)
                .hasSize(3)
                .contains("dwa");
    }
}
