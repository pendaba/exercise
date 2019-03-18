package main.java;

/**
 * @author fupengga
 */
public enum ColorEnum {


    RED("红"),

    BLUE("蓝"),

    BLACK("黑");

    private String color;

    ColorEnum (String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        System.out.println(ColorEnum.RED.getColor());
    }
}
