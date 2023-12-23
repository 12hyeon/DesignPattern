package factoryMethod;

import data.LineShape;
import data.User;
import strategy.BackCover;
import strategy.FrontCover;

public class DanStarReport extends Report {

    public DanStarReport(FrontCover front, BackCover back, User data, LineShape lineShape) {
        super(front, back, data, lineShape);
    }

    public int getTypePrice() {
        return 20;
    }

}