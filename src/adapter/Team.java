package adapter;

import java.util.List;

public interface Team {

    List<String> getMemberNames(); // "xxx 외 (n-1)명"
    List<String> getMemberEmails(); // "대표 메일 : @"
    int getCount();

    String getDate();
    String getTitle();
    String getText();
}
