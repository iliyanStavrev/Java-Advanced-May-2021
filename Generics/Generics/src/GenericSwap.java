import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericSwap <T>{

    T element;

    public GenericSwap(T element) {
        this.element = element;
        List<T>elements = new ArrayList<>();
    }
    public  List<T> swap(List<T>elements,int index1,int index2){

        Collections.swap(elements,index1,index2);
            return elements;

    }
    @Override
    public String toString(){
        return String.format("%s: %s",this.element.getClass().getName(),element.toString());
    }
}
