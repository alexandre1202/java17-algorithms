package br.com.aab.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JoiningMultipleStringsTest {

    JoiningMultipleStrings join = new JoiningMultipleStrings();

    @Test
    public void happyPath() {
        String[] words = {"Alexandre", "Antonio", "Barbosa", "Kooltra"};
        var result = join.joinByDelimiter(':', words);
        Assertions.assertThat(result)
                .isEqualTo("Alexandre:Antonio:Barbosa:Kooltra");
    }

}