public class Employee {
    private  final int id;
    private final String fullName;
    private  int department;
    private int salary;
    private static int countID = 1;

    @Override
    public String toString() {
        return String.format("id: %d,ФИО:%s, ЗП %d, № отдела: %d",
                id,
                fullName,
                salary,
                department);

    }

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = countID++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}