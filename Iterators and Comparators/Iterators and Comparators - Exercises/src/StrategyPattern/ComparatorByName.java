package StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getName().length() - p2.getName().length();
        if (result == 0){
            char symbol1 = p1.getName().toLowerCase().charAt(0);
            char symbol2 = p2.getName().toLowerCase().charAt(0);
            result = symbol1 - symbol2;
        }
        return  result;
    }
}
