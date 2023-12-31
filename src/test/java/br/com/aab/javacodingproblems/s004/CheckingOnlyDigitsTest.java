package br.com.aab.javacodingproblems.s004;

import org.junit.jupiter.api.Test;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class CheckingOnlyDigitsTest {

    CheckingOnlyDigits checkingOnlyDigits = new CheckingOnlyDigits();

    @Test
    public void testContainAnyDigits() {
        String params = "149782314987131342987";
        assertThat(checkingOnlyDigits.onlyDigits(params)).isEqualTo(TRUE);
    }

    @Test
    public void testDoesNotContainOnlyDigits() {
        String params = "dsflkhasflkjh14978231498713134298ººº7asdifhsalkjfh1239y";
        assertThat(checkingOnlyDigits.onlyDigits(params)).isEqualTo(FALSE);
    }

    @Test
    public void testContainOnlyDigits() {
        String params = "9742934792384";
        assertThat(checkingOnlyDigits.onlyDigits(params)).isEqualTo(TRUE);
    }

}