import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> elements){
        if (elements.isEmpty()){
            throw new IllegalArgumentException();
        }
        return Collections.min(elements);
    }
    public static <T extends Comparable<T>> T getMax(List<T> elements){
        if (elements.isEmpty()){
            throw new IllegalArgumentException();
        }
        return Collections.max(elements);
    }
}
