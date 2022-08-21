package OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<Person>people = new ArrayList<>();


        while (num-- > 0){
            String []tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name,age);
            if (age > 30){
                people.add(person);
            }
        }
       people.stream()
               .sorted((p1,p2) ->
                     p1.name.compareTo(p2.name))
                            .forEach(p -> System.out.printf("%s - %d%n",p.name,p.age));
    }
}
