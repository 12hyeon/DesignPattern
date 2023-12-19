package strategy;

import data.UserData;

import java.util.List;

public abstract class Cover {
    protected FrontCover front;
    protected BackCover back;

    public UserData data;

    public List<String> printFront() {
        return front.printFront(data);
    }

    public List<String> printBack() {
        return back.printBack(data);
    }

}
