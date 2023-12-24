package decorator;

import factoryMethod.Report;

public class TitleDecorator extends ReportDecorator {

    public TitleDecorator(Report report) {
        super(report);
    }

    @Override
    public int getTypePrice() {
        return 30; // title 가격 추가
    }

    @Override
    public String getFooterSub() {
        
        String sb = report.getFooterSub();
        String title = changeTitleShape(report.getData().getTitle());

        if (sb.length() == 0) {
            sb = " ".repeat(10) + title;
        }
        else if (sb.length() == 10) {
            sb = sb.substring(0, 10) + title;
        }

        return sb;
    }


    // title 선택에 따른 크기 조절
    public String changeTitleShape(String inputString) {
        int n = 30;

        if (inputString.length() >= n) {
            return inputString.substring(0, n);
        } else {
            return " ".repeat(n - inputString.length()) + inputString;
        }
    }
}

