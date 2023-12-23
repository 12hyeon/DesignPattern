package type;

public enum Pattern { // 빈칸을 _로 표시
    star("****"),
    twin_star("_*_*"),
    circle("O_O_");

    private String pattern;

    Pattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
