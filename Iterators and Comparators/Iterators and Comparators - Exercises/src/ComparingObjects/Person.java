package ComparingObjects;

import java.util.List;

public class Person implements Comparable<Person> {
    String name;
    int age;
    String town;


    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        int result = name.compareTo(person.name);
        if (result == 0){
            result = Integer.compare(age,person.age);
        }
        if (result == 0){
            result = town.compareTo(person.town);
        }
      return result;
    }
}
