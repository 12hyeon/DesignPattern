package data;

public class UserData implements User {

    // 사용자 정보
    private String name;
    private String email;

    // report 정보
    private String date;
    private String text;
    private String title;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    public UserData() {
    }

    public UserData(String name, String email, String date,
                    String title, String text) {

        this.name = checkLength(name, 40);
        this.email = checkLength(email, 40);
        this.text = text;

        // 꼬리말에 추가될 형태 : date + title
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
