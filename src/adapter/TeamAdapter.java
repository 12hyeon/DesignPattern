package adapter;

import data.User;

public class TeamAdapter implements User {
    Team team;

    public TeamAdapter(Team team) {
        this.team = team;
    }

    // name, email : 여러 명의 정보를 함축적으로 표현
    public String getName() {
        if (team.getCount() == 0) {
            return "팀원 없음";
        } else {
            return "팀원: "+ team.getMemberNames().get(0) + " 외 " + (team.getCount() - 1) + "명";
        }
    }

    public String getEmail() {
        int count = team.getMemberNames().size();
        if (count == 0) {
            return "대표 메일 없음";
        } else {
            return "대표 메일: " + team.getMemberEmails().get(0);
        }
    }


    public String getDate() {
        return team.getDate();
    }

    public String getTitle() {
        return team.getTitle();
    }

    public String getText() {
        return team.getText();
    }


}
