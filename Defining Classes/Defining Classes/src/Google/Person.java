package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
     String name;
    Company company;
    Car car;
    List<Pokemon>pokemons;
    List<Parents>parents;
    List<Children>children;

   public Person(String name){
       this.name = name;
       this.pokemons = new ArrayList<>();
       this.parents = new ArrayList<>();
       this.children = new ArrayList<>();
   }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public void addPokemon(Pokemon pokemon){
       this.pokemons.add(pokemon);
    }
    public void addParents(Parents parents){
       this.parents.add(parents);
    }
    public void addChildren(Children children){
       this.children.add(children);
    }

}
