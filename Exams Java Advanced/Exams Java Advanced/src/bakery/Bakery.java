package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    String name;
    int capacity;
    List<Employee>employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void add(Employee employee){

        if (capacity > this.employees.size()){
            this.employees.add(employee);
        }
    }
    public boolean remove(String name){
        return employees.removeIf(e -> e.getName().equals(name));
    }
     public Employee getOldestEmployee(){
        Employee employee = null;
         for (Employee em : employees) {
             if (employee == null || employee.getAge() < em.getAge()){
                 employee = em;
             }
         }
         return employee;
     }
     public Employee getEmployee(String name){

         for (Employee e : employees) {
             if (e.getName().equals(name)){
                  return e;
             }
         }
         return null;
     }
     public int getCount(){
        return employees.size();
     }
     public String report(){

        StringBuilder out = new StringBuilder("Employees working at Bakery " + name + ":");
        out.append(System.lineSeparator());
         for (Employee employee : employees) {
             out.append(employee.toString()).
                     append(System.lineSeparator());
         }
       return out.toString();
     }
}
