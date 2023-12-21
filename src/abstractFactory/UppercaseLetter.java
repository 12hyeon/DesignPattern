package abstractFactory;

public class UppercaseLetter extends Letter {

    @Override
    public char setLetter(char c) {
        if (Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        }
        return c;
    }
}
