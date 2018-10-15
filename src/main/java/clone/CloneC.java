package main.java.clone;

class CloneC implements Cloneable {
    public String str;
    public StringBuffer strBuff;

    public Object clone() {
        CloneC o = null;
        try {
            o = (CloneC) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
