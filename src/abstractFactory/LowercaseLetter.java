package abstractFactory;

public class LowercaseLetter extends Letter {

    @Override
    public char setLetter(char c) {
        if (Character.isUpperCase(c)) {
            return Character.toLowerCase(c);
        }
        return c;
    }
}
