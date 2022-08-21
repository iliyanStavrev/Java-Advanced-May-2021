package GenericCountMethodDouble;

import java.util.List;

public class Box <T extends Comparable<T>>{
    T element;

    public Box(T element) {
        this.element = element;
    }
    public int getCount(List<T> elements, T element){
        int count = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
