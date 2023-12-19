package align;

public class CenterAlign {
    private final int LINE_LENGTH = 40;
    String text;

    public CenterAlign(String text) {
        this.text = text;
    }

    public String centerAlign() {
        int front = (LINE_LENGTH - text.length()) / 2;
        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < front; j++) {
            builder.append(" ");
        }

        builder.append(text);

        for (int j = front + text.length(); j < 40; j++) {
            builder.append(" ");
        }

        return builder.toString();
    }
}