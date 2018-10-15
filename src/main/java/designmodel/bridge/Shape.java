package main.java.designmodel.bridge;

public abstract class Shape {
        protected Draw draw;
        protected Shape(Draw draw){
            this.draw = draw;
        }
        public abstract void draw();

}
