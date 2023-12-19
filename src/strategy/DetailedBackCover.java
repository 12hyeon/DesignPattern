package strategy;

import align.CenterAlign;
import align.LeftAlign;
import data.User;

import java.util.ArrayList;
import java.util.List;

public class DetailedBackCover implements BackCover {

    @Override
    public List<String> printBack(User data) {
        List<String> page = new ArrayList<>();

        printBack(data, page);
        return page;
    }

    public void printBack(User data, List<String> page) {
        for (int i = 0; i < 10; i++) {
            if (i == 3) { // 제목
                String nameSub = data.getTitle();
                CenterAlign align = new CenterAlign(nameSub);
                page.add(align.centerAlign());
            }
            else if (i == 6) { // 이름
                String nameSub = data.getName();
                LeftAlign align = new LeftAlign(nameSub);
                page.add(align.leftAlign());
            }
            else if (i == 7) { // 이메일
                String nameSub = data.getEmail();
                LeftAlign align = new LeftAlign(nameSub);
                page.add(align.leftAlign());
            }
            else {
                page.add("");
            }
        }
    }

    @Override
    public int getBackPrice() {
        return 200;
    }

}
