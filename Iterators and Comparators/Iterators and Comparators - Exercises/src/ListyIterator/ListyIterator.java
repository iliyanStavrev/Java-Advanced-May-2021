package ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator {
    List<String> list;
    int index;

    public ListyIterator(List<String> list) {
        this.list = list;
    }
    public boolean move(){
        if (hasNext()){
            index ++;
            return true;
        }
        return false;
    }
    public boolean hasNext(){
        return index  < list.size() - 1;
    }
    public void print(){
       if (validated()){
           System.out.println(list.get(index));
       }
    }

    private boolean validated() {
        if (list.isEmpty()){
            System.out.println("Invalid Operation!");
            return false;
        }
        return true;
    }
    public void printAll(){
        if (validated()){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }

    }
}
