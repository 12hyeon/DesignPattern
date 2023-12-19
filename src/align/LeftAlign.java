package align;

public class LeftAlign {
    private final int LINE_LENGTH = 40;
    String text;

    public LeftAlign(String text) {
        this.text = text;
    }

    public String leftAlign() {
        int front = LINE_LENGTH - 1 - text.length();
        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < front; j++) {
            builder.append(" ");
        }

        builder.append(text);
        return builder.toString();
    }
}
