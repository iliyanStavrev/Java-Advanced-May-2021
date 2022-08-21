package GenericSwapInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericSwapInteger<T>{

    T element;

    public GenericSwapInteger(T element) {
        this.element = element;
       // List<T> elements = new ArrayList<>();
    }
    public  List<T> swap(List<T>elements,int index1,int index2){

        Collections.swap(elements,index1,index2);
        return elements;

    }
    @Override
    public String toString(){
        return String.format("%s: %d",this.element.getClass().getName(),element);
    }
}
