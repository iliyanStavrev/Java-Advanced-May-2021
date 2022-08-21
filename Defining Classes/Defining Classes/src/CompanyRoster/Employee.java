package CompanyRoster;

public class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

     public  Employee(){
         this.email = "n/a";
         this.age = -1;
     }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
