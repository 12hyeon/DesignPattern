package strategy;

import data.User;

import java.util.List;

public interface BackCover {
    List<String> printBack(User data);
    int getBackPrice();
}
