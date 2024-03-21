package br.com.aab.codechallenge.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GradingStudents {
    public List<Integer> gradingStudents(List<Integer> grades) {
        if (Objects.isNull(grades) || grades.size() < 2) return grades;

        List<Integer> result = new ArrayList<>();
        for (int grade: grades) {
            if (grade < 38 ) {
                result.add(grade);
                continue;
            }

            int distance = findNextGradeRound(grade);
            if (distance < 3) {
                result.add(grade + distance);
            } else {
                result.add(grade);
            }
        }
        return result;
    }

    private int findNextGradeRound(int grade) {
        int distance = 0;
        while (! isMultiply(grade + distance)) {
            distance++;
        }
        return distance;
    }

    private boolean isMultiply(int grade) {
        return grade % 5 == 0;
    }
}
