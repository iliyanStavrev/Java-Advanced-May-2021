package GenericCountMethodString;

import java.util.List;

public class Boxx <T extends Comparable<T>>{
    List<T>elements;
    T element;

    public Boxx(T element) {
        this.element = element;
    }
    public int getCount(List<T>elements,T element){
          int count = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
