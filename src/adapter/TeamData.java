package adapter;

import java.util.ArrayList;
import java.util.List;

public class TeamData implements Team {

    // 팀 정보
    private List<String> memberNames;
    private List<String> memberEmails;
    private int count;

    // report 정보
    private String date;
    private String text;
    private String title;

    public List<String> getMemberNames() {
        return memberNames;
    }

    public List<String> getMemberEmails() {
        return memberEmails;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }

    public TeamData(List<String> names, List<String> emails, String date,
                    String title, String text) {

        this.memberNames = new ArrayList<>();
        for (String name : names) {
            memberNames.add(checkLength(name, 30));
        }
        this.count = memberNames.size();

        this.memberEmails = new ArrayList<>();
        for (String email : emails) {
            memberEmails.add(checkLength(email, 30));
        }

        this.text = text;
        this.date = checkLength(date, 10);
        this.title = checkLength(title, 30);
    }

    public String checkLength(String inputString, int n) {
        if (inputString.length() > n) {
            return inputString.substring(0, n);
        }
        return inputString;
    }
}
