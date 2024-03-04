package br.com.aab.codechallenge.interview.justappraised;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MostFrequentWordTest {

    MostFrequentWord mostFrequentWord = new MostFrequentWord();

    @Test
    public void happyPathShouldReadValidParagraphAndOneHitReturnBall() {
        String input = "Bob hit a ball, the hit BALL flew far after it was hit";
        String result = mostFrequentWord.mostFrequentWord(input, List.of("hit"));
        Assertions.assertThat(result).isEqualTo("ball");
    }

    @Test
    public void shouldReadValidParagraphWithManyDuplicationsAndOneHitReturnBall() {
        String input = "Bob hit a ball, the hit BALL flew far after it was hit and ball";
        String result = mostFrequentWord.mostFrequentWord(input, List.of("and"));
        Assertions.assertThat(result).isEqualTo("ball");
    }

    @Test
    public void shouldReadValidParagraphAndHitEqualAAndBallReturnEmptyString() {
        String input = "Bob hit a ball, the hit BALL flew far after it was hit";
        String result = mostFrequentWord.mostFrequentWord(input, List.of("a", "ball"));
        Assertions.assertThat(result).isEqualTo("hit");
    }

    @Test
    public void shouldReadValidParagraphAndHitEqualBobReturnEmptyString() {
        String input = "Bob hit a ball and flew far after it was a";
        String result = mostFrequentWord.mostFrequentWord(input, List.of("bob"));
        Assertions.assertThat(result).isEqualTo("a");
    }

    @Test
    public void shouldReadInvalidParagraphAndHitEqualXReturnEmptyString() {
        String input = "Hi Bob My interview was not good as I should";
        String result = mostFrequentWord.mostFrequentWord(input, List.of("bob"));
        Assertions.assertThat(result).isEqualTo("");
    }
}
