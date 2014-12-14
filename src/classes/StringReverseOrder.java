package classes;

public class StringReverseOrder implements CharSequence {
    private String originalValue;
    private String reversedValue;

    public StringReverseOrder(String originalValue) {
        this.originalValue = originalValue;
        reverseValue();
    }

    public StringReverseOrder() {
        this("Default value. Default constructor");
    }

    public String getReversedValue() {
        return reversedValue;
    }

    private void reverseValue () {
        char [] tempCharArray = new char[originalValue.length()];
        char [] charArray = originalValue.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            tempCharArray[i] = charArray[charArray.length - 1 - i];
        }

        reversedValue = String.valueOf(tempCharArray);
    }

    @Override
    public int length() {
        return reversedValue.length();
    }

    @Override
    public char charAt(int index) {
        return reversedValue.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reversedValue.subSequence(start, end);
    }
}
