package strategy;

import data.User;

import java.util.List;

public interface FrontCover {
    List<String> printFront(User data);
    int getFrontPrice();
}
