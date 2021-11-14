public class Employees {
    String nume;
    int age;
    double Salary;

    public Employees(String nume, int age, double salary) {
        this.nume = nume;
        this.age = age;
        Salary = salary;
    }

    public double getSalary() {
        return Salary;
    }
}
