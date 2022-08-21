public class Box <T> {

    T element;

    public Box (T element) {
        this.element = element;
    }

    @Override
    public String toString(){
        return String.format("%s: %d",this.element.getClass().getName(),element);
    }
}
