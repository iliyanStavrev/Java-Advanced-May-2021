package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person>people = new ArrayList<>();
        while (!input.equals("END")){
            String[]tokens = input.split("\\s+");

            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
            people.add(person);

            input = scanner.nextLine();
        }
        int indexToLook = Integer.parseInt(scanner.nextLine());
        Person searchedPerson = people.get(indexToLook - 1);
         int equal = 0;
         int notEqual = 0;

        for (Person person : people) {
            if (person.compareTo(searchedPerson) == 0){
                equal++;
            }
            else {
                notEqual++;
            }
        }
        if (equal == 1){
            System.out.println("No matches");
        }
        else {
            System.out.printf("%d %d %d",equal,notEqual,people.size());
        }
    }
}
