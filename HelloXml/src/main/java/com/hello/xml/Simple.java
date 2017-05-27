package com.hello.xml;

/**
 * Created by user on 2017/5/26.
 */
public class Simple {
    private int x = 1;
    private int y = 2;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Simple [" + x + ", " + y + "]";
    }
}
