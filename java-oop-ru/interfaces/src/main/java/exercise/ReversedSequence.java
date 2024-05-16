package exercise;

// BEGIN
class ReverseSequence implements CharSequence {
    private final String reversedText;

    ReverseSequence(String input) {
        reversedText = new StringBuilder(input).reverse().toString();
    }

    public String getReversedText() {
        return reversedText;
    }

    @Override
    public boolean isEmpty() {
        return reversedText.isEmpty();
    }

    @Override
    public String toString() {
        return reversedText;
    }

    @Override
    public int length() {
        return reversedText.length();
    }

    @Override
    public char charAt(int i) {
        return reversedText.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return reversedText.subSequence(i, i1);
    }
}
// END
