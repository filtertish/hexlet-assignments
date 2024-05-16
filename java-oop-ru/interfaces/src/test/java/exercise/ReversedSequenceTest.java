package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversedSequenceTest {
    @Test
    public void reversedSequenceTest() {
        String text = "hello";
        String reversed = "olleh";
        ReverseSequence reversedText = new ReverseSequence(text);

        Assertions.assertFalse(reversedText.isEmpty());
        Assertions.assertEquals(reversedText.charAt(1), 'l');
        Assertions.assertEquals(reversed, reversedText.getReversedText());
        Assertions.assertEquals(reversedText.length(), 5);
        Assertions.assertEquals(reversedText.subSequence(0, 2), "ol");
    }
}
