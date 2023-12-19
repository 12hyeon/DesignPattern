package strategy;

import align.CenterAlign;
import data.User;

import java.util.ArrayList;
import java.util.List;

public class SimpleBackCover implements BackCover {

    @Override
    public List<String> printBack(User data) {
        List<String> page = new ArrayList<>();

        getBack(data, page);
        return page;
    }

    public void getBack(User data, List<String> page) {
        for (int i = 0; i < 10; i++) {
            if (i == 4) { // 이름
                String nameSub = data.getTitle();
                CenterAlign align = new CenterAlign(nameSub);
                page.add(align.centerAlign());
            }
            else {
                page.add("");
            }
        }
    }

    @Override
    public int getBackPrice() {
        return 100;
    }

}
