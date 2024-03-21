package br.com.aab.codechallenge.hackerrank.easy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GradingStudentsTest {
    GradingStudents gradingStudents = new GradingStudents();

    @Test
    public void testExample1() {
        var input = List.of(84, 29, 57);
        var result = gradingStudents.gradingStudents(input);
        var expected = List.of(85, 29, 57);

        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void testExample2() {
        var input = List.of(73, 67, 38, 33);
        var result = gradingStudents.gradingStudents(input);
        var expected = List.of(75, 67, 40, 33);

        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}
