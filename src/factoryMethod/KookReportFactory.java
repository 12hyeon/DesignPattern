package factoryMethod;

import abstractFactory.*;
import data.LineShape;
import data.User;
import strategy.BackCover;
import strategy.FrontCover;
import type.ReportType;

public class KookReportFactory extends ReportFactory {

    @Override
    public Report getReport(ReportType type, FrontCover front, BackCover back, User data) {
        LineShape lineShape = makeStorePattern(type);

        if (type.equals(ReportType.circle_type)) {
            return new KookCircleReport(front, back, data, lineShape);
        } else {
            return new KookStarReport(front, back, data, lineShape);
        }
    }

    @Override
    public LineShape makeStorePattern(ReportType type) {

        BoxTypeFactory boxFactory = new SecondBoxTypeFactory();
        Blank blank = boxFactory.createBlank();
        Letter letter = boxFactory.createLetter();

        String hPattern = type.getHPattern();
        String fPattern = type.getFPattern();

        String h = hPattern.replace("_", blank.setBlank());
        String f = fPattern.replace("_", blank.setBlank());

        StringBuilder head = new StringBuilder();
        for (char c : h.toCharArray()) {
            head.append(letter.setLetter(c));
        }

        StringBuilder foot = new StringBuilder();
        for (char c : f.toCharArray()) {
            foot.append(letter.setLetter(c));
        }

        return new LineShape(
                head.toString().repeat(10),
                foot.toString().repeat(10));
    }
}
