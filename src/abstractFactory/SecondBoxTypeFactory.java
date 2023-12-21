package abstractFactory;

public class SecondBoxTypeFactory extends BoxTypeFactory {

    @Override
    public Blank createBlank() {
        return new DashTypeBlank();
    }

    @Override
    public Letter createLetter() {
        return new UppercaseLetter();
    }
}
