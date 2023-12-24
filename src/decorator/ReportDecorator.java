package decorator;

import factoryMethod.Report;
import java.util.List;

public abstract class ReportDecorator extends Report {
    protected Report report;

    public ReportDecorator(Report report) {
        super(report);
        this.report = report;
    }

    @Override
    public int getPrice() {
        int content = (int) Math.ceil((double) report.getData().getText().length() / (40 * 3)); // 본문 장수
        return report.getPrice() + getTypePrice() * content;
    }

    @Override
    public void makeFile() {
        //report.makeFile();
        List<String> file = report.getFile();

        // 동적으로 footerSub를 추가하는 작업
        String footerSub = getFooterSub();
        for (int i = 21; i < file.size() - 3; i++) {
            if (i % 11 == 10) {
                file.set(i, footerSub);
            }
        }

        file.set(file.size()-1, "price = " + getPrice());

    }

    // title이나 date에 따른 price 반환
    @Override
    public abstract int getTypePrice();

    @Override // 재정의
    public abstract String getFooterSub();
}


