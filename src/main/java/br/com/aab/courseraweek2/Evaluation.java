package br.com.aab.courseraweek2;

class Evaluation {
    int rightPos;
    int wrongPoss;

    public Evaluation(int rightPosition, int wrongPosition) {
        rightPos = rightPosition;
        wrongPoss = wrongPosition;
    }

    @Override
    public String toString() {
        return
                "(" + rightPos +
                        ", " + wrongPoss + ")" +
                        '}';
    }
}