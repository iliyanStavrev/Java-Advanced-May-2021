package Google;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


            String input = scanner.nextLine();

        List<Pokemon>pokemons = new ArrayList<>();
        List<Parents>parentsList = new ArrayList<>();
        List<Children>childrenList = new ArrayList<>();
       Map<String,Person>people = new LinkedHashMap<>();


        while (!input.equals("End")){
            String[]tokens = input.split("\\s+");
            String name = tokens[0];
            String command = tokens[1];
            Company company = new Company();
            Car car = new Car();

            if (!people.containsKey(name)){
                Person person = new Person(name);
                people.put(name,person);
            }

            switch (command){
                case "company":
                    company.companyName = tokens[2];
                    company.department = tokens[3];
                    company.salary = Double.parseDouble(tokens[4]);
                    if (people.containsKey(name)){
                        people.get(name).setCompany(company);
                    }

                    break;
                case "car":
                    car.carModel = tokens[2];
                    car.carSpeed = tokens[3];
                    if (people.containsKey(name)){
                        people.get(name).setCar(car);
                    }
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                  people.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirth = tokens[3];

                    Parents parents = new Parents(parentName,parentBirth);
                    people.get(name).addParents(parents);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirth = tokens[3];

                    Children children = new Children(childName,childBirth);
                    people.get(name).addChildren(children);
                    break;

            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        if (people.containsKey(input)){

            System.out.printf("%s%n",input);
            System.out.println("Company:");
            if (people.get(input).company != null){
                System.out.printf("%s %s %.2f%n",people.get(input).company.companyName,
                        people.get(input).company.department,people.get(input).company.salary);
            }
            System.out.println("Car:");
            if (people.get(input).car != null){
                System.out.printf("%s %s%n",people.get(input).car.carModel,people.get(input).car.carSpeed);
            }
            System.out.println("Pokemon:");
            people.get(input).pokemons.stream().forEach(p -> System.out.printf("%s %s%n",p.getPokemonName()
            ,p.getPokemonType()));
            System.out.println("Parents:");
            people.get(input).parents.stream().forEach(p -> System.out.printf("%s %s%n",
                    p.parentName,p.parentBirthday));
            System.out.println("Children:");
            people.get(input).children.stream().forEach(c -> System.out.printf("%s %s%n",
                    c.childName,c.childBirthday));
        }
        }
    }

