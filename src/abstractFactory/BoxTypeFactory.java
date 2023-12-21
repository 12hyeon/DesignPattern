package abstractFactory;

// blank, letter 처리 방식이 다양
public abstract class BoxTypeFactory {

    public abstract Blank createBlank();
    public abstract Letter createLetter();
}
