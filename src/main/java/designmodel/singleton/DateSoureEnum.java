package main.java.designmodel.singleton;

/**
 * 枚举实现单利数据源
 */
public enum DateSoureEnum {
    DATASOURCE;
    private Demo demo;
    DateSoureEnum(){
        demo = new Demo();
    }

    public Demo getDemo() {
        return demo;
    }

    public static void main(String[] args) {
        System.out.println(DateSoureEnum.DATASOURCE.getDemo() == DateSoureEnum.DATASOURCE.getDemo());
    }
}
