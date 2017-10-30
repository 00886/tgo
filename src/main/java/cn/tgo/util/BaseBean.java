package cn.tgo.util;

/**
 * 分页bean，每个需要分页查询得bean都继承这个类
 */
public class BaseBean {
    //从多少条开始查询
    private int start;
    //要查询的记录数
    private int length;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
