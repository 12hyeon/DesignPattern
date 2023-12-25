import adapter.Team;
import adapter.TeamAdapter;
import adapter.TeamData;
import data.UserData;
import decorator.DateDecorator;
import decorator.TitleDecorator;
import factoryMethod.DanReportFactory;
import factoryMethod.Report;
import factoryMethod.ReportFactory;
import strategy.*;
import type.ReportType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Circle, Star 중 선택
        ReportFactory D = new DanReportFactory();

        // 선택 및 입력 : 제목, 이름, 이메일은 30자 이하
        UserData data = new UserData(
                "hyeon", "12@gmail.com", "2023-12-10",
                "test", "a".repeat(81));

        // 앞과 뒤 표지 cover 선택
        FrontCover front = new DetailedFrontCover();
        BackCover back = new SimpleBackCover();

        // 리포트 종류 선택
        ReportType type = ReportType.circle_type;
        Report report = D.orderReport(type, front, back, data); // report 내용 생성

        // 1. report 출력
        report.printReport();


        UserData data2 = new UserData(
                "hyeon", "12@gmail.com", "2023-12-10",
                "test", "b".repeat(121));

        Report report2 = D.orderReport(type, front, back, data2); // report 내용 생성
        //System.out.println();
        //System.out.println("Dan Circle Report = " + report2.getPrice());

        // 2. 기본 리포트부터 각 title, date 추가한 report
        Report dateReport = new DateDecorator(report2);
        //System.out.println("Dan Circle Report (date : 본문 장당 10) = " + dateReport.getPrice());
        //dateReport.printReport();

        Report titleReport = new TitleDecorator(dateReport);
        //System.out.println("Dan Circle Report (date: 본문 당 10, title: 본문 당 30) = " + titleReport.getPrice());
        titleReport.printReport();


        // 3. 팀의 report
        List<String> names = new ArrayList<>();
        names.add("hyeon");
        names.add("jeong");
        names.add("lee");

        List<String> emails = new ArrayList<>();
        emails.add("hyeon12@dankook.ac.kr");
        emails.add("jeong12@dankook.ac.kr");
        emails.add("lee12@dankook.ac.kr");

        Team data3 = new TeamData(names, emails,
                "2023-12-10", "test", "c".repeat(121));

        TeamAdapter adapter = new TeamAdapter(data3);

        ReportType type3 = ReportType.diff_star_type;
        FrontCover front3 = new DetailedFrontCover();
        BackCover back3 = new DetailedBackCover();

        // team 내용으로 report 생성
        Report report3 = D.orderReport(type3, front3, back3, adapter);
        report3.printReport();

    }
}