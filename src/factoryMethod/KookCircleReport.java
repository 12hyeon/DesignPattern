package factoryMethod;

import data.LineShape;
import data.User;
import strategy.BackCover;
import strategy.FrontCover;

public class KookCircleReport extends Report {

    public KookCircleReport(FrontCover front, BackCover back, User data, LineShape lineShape) {
        super(front, back, data, lineShape);
    }

    public int getTypePrice() {
        return 30;
    }

}