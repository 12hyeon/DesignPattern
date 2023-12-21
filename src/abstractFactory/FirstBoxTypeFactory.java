package abstractFactory;

public class FirstBoxTypeFactory extends BoxTypeFactory {

    @Override
    public Blank createBlank() {
        return new SpaceTypeBlank();
    }

    @Override
    public Letter createLetter() {
        return new LowercaseLetter();
    }
}
