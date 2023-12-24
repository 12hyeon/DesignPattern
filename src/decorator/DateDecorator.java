package decorator;

import factoryMethod.Report;

public class DateDecorator extends ReportDecorator {

    public DateDecorator(Report report) {
        super(report);
    }

    @Override
    public int getTypePrice() {
        return 10; // date 가격 추가
    }

    @Override
    public String getFooterSub() {

        String sb = report.getFooterSub();
        String date = changeDateShape(report.data.getDate());

        if (sb.length() == 0) {
            sb = date;
        }
        else if (sb.length() == 40) {
            sb = date + sb.substring(10, 40);
        }

        return sb;
    }

    // data 선택에 따른 크기 조절
    public String changeDateShape(String inputString) {
        int n = 10;

        if (inputString.length() >= n) {
            return inputString.substring(0, n);
        } else {
            return inputString + " ".repeat(n - inputString.length());
        }
    }
}

