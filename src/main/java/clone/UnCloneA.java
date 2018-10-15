package main.java.clone;

class UnCloneA {
    private int i;
    public UnCloneA(int ii) { i = ii; }
    public void doublevalue() { i *= 2; }
    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
