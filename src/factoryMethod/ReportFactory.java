package factoryMethod;

import data.LineShape;
import data.User;
import strategy.BackCover;
import strategy.FrontCover;
import type.ReportType;

// Dan, Kook 지점의 report 가게 : '_'에 대한 처리가 '-' 또는 ' '
public abstract class ReportFactory {

    // operation
    public Report orderReport(ReportType type, FrontCover front, BackCover back, User data) {
        Report report = getReport(type, front, back, data);

        report.makeFile(); // 작업

        return report;
    }

    // instance
    public abstract Report getReport(ReportType type, FrontCover front, BackCover back, User data);


    // 각 지점에 따른 BoxFactory 적용
    public abstract LineShape makeStorePattern(ReportType type);

}
