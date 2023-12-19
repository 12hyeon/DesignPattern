package strategy;

import align.CenterAlign;
import data.User;

import java.util.ArrayList;
import java.util.List;

public class DetailedFrontCover implements FrontCover {


    @Override
    public List<String> printFront(User data) {
        List<String> page = new ArrayList<>();

        getFront(data, page);
        return page;
    }

    public void getFront(User data, List<String> page) {

        CenterAlign align;

        for (int i = 0; i < 10; i++) {
            if (i == 2) {  // 제목
                align = new CenterAlign(data.getTitle());
                page.add(align.centerAlign());
            }
            else if (i == 6) { // 이름
                align = new CenterAlign(data.getName());
                page.add(align.centerAlign());
            }
            else if (i == 7) { // 제출 일자
                align = new CenterAlign(data.getDate());
                page.add(align.centerAlign());
            }
            else {
                page.add("");
            }
        }
    }

    @Override
    public int getFrontPrice() {
        return 200;
    }
}
