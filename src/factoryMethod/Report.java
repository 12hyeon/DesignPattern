package factoryMethod;

import data.LineShape;
import data.User;
import strategy.BackCover;
import strategy.FrontCover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Report {

    // 표지
    public FrontCover front;
    public BackCover back;

    // 본문
    public LineShape lineShape; // header, footer

    public User data;
    public List<String> file;

    public Report(Report report) {
        this.front = report.front;
        this.back = report.back;
        this.data = report.data;
        this.lineShape = report.lineShape;
        this.file = report.getFile();
    }

    public void setFile(List<String> file) {
        this.file = file;
    }

    public Report(FrontCover front, BackCover back, User data, LineShape lineShape) {
        this.front = front;
        this.back = back;
        this.data = data;
        this.lineShape = lineShape;
    }

    public abstract int getTypePrice();

    public String getFooterSub() {
        return "";
    }

    public int getPrice() {
        return front.getFrontPrice() + back.getBackPrice() + getTypePrice();
    }
    
    public User getData() {
        return data;
    }

    public List<String> getFile() {
        return file;
    }

    // 전체 file 출력
    public void printReport() {
        makeFile();
        for (String line : file) {
            System.out.println(line);
        }
    }

    // 파일 생성
    public void makeFile() {
        this.file = new ArrayList<>();
        List<String> page;

        // 1. 앞표지 추가
        file.add("------------------page------------------");
        page = front.printFront(data);
        file.addAll(page);

        // 2. 본문 추가
        int count = (int) Math.ceil((double) data.getText().length() / (40 * 3)); // 본문 장수
        for (int i = 0; i < count; i++) {
            file.add("------------------page------------------");

            // 머리말 추가
            file.add(lineShape.getHead());
            file.add(lineShape.getHead());
            file.add("");

            // 본문 추가
            List<String> content = separateContent(i);
            file.addAll(content);
            file.add("");

            // 꼬리말 추가
            file.add(lineShape.getFoot());
            file.add(lineShape.getFoot());

            // date, title 추가
            file.add(getFooterSub());
        }

        // 3. 뒤표지 추가
        file.add("------------------page------------------");
        page = back.printBack(data);
        file.addAll(page);

        // 4. 가격 추가
        file.add("------------------page------------------");
        file.add("price = " + getPrice());
    }

    // page 당 본문 내용 분리
    public List<String> separateContent(int page) {
        int maxLine = 40;
        int maxContentLength = 120;
        int start = page * maxContentLength;
        int end = Math.min(start + maxContentLength, data.getText().length());

        if (start >= data.getText().length()) {
            return Collections.emptyList();
        }

        String pageContent = data.getText().substring(start, end);
        List<String> lines = new ArrayList<>();

        // 페이지의 내용을 40글자씩 잘라서 각 줄에 추가하기
        for (int i = 0; i < maxLine * 3; i += maxLine) {
            if (i < pageContent.length()) {
                int endIndex = Math.min(i + maxLine, pageContent.length());
                String line = pageContent.substring(i, endIndex);
                lines.add(line);
            } else {
                lines.add(""); // 40글자 미만이면 빈 줄 추가
            }
        }

        return lines;
    }

}
