package type;

// report 종류별 정의
public enum ReportType {
    circle_type(Pattern.circle, Pattern.circle),
    diff_star_type(Pattern.twin_star, Pattern.star);

    private Pattern hPattern;
    private Pattern fPattern;

    ReportType(Pattern header, Pattern footer) {
        this.hPattern = header;
        this.fPattern = footer;
    }

    public String getHPattern() {
        return hPattern.getPattern();
    }

    public String getFPattern() {
        return fPattern.getPattern();
    }
}
