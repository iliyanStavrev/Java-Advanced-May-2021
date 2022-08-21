package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    T element;
    List<T>elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void  add(T element){
       this.elements.add(element);
    }
    public void remove(int index){
        this.elements.remove(index);
    }
    public boolean contains(T element){
        return this.elements.contains(element);
    }
    public void swap(int index1,int index2){
        Collections.swap(this.elements,index1,index2);
    }
    public int greater(T element){
        int count = 0;
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
    public T max(){
       return Collections.max(this.elements);
    }
    public T min(){
        return Collections.min(this.elements);
    }
    public  void sort(){
        for (int i = 0; i < this.elements.size() - 1; i++) {
            T element = elements.get(i);
            for (int j = i + 1; j < elements.size(); j++) {
                T element1 = elements.get(j);
                if (element1.compareTo(element) < 0){
                     elements.set(i,element1);
                     elements.set(j,element);
                     element = element1;
                }
            }
        }
    }

@Override
    public String toString(){

        StringBuilder out = new StringBuilder();
    for (T t : elements) {
        out.append(t).append(System.lineSeparator());
    }
        return out.toString();
}
}
