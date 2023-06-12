import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeBook {
    private final int SIZE = 10;
    private final Map<String,Employee> employees;
    public EmployeeBook(){
        employees = new HashMap<>();
    }
    public String getKey(Employee employee){
        return employee.getFullName();
    }
    public   void printFullInfo(){
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public  Employee departmentMinSalary(int department){
        Employee employee = null;
        int min = Integer.MAX_VALUE;
        for (Employee emp : employees.values()){
            if(emp != null && emp.getSalary() < min && emp.getDepartment() == department){
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public  int departmentSum(int department){
        int sum = 0;
        for(Employee emp : employees.values()) {
            if (emp != null && emp.getDepartment() == department) {
                sum += emp.getSalary();
            }
        }
        return sum;
    }
    public  int averageDepartment(int department){
        double average = 0;
        int count = 0;
        for (Employee emp : employees.values()){
            if(emp != null && emp.getDepartment() == department){
                count++;
            }
        }
        if (count != 0){
            average =(double) departmentSum(department)/count;
        }
        return (int) average;
    }
    public  void indexSalaryDepartment(int department,int percent){
        double coff = 1 + percent/100d;
        for (Employee emp : employees.values()){
            if(emp != null && emp.getDepartment() == department){
                emp.setSalary((int) (emp.getSalary()*coff));
                System.out.println(emp);
            }
        }
    }


    public  void printFullName(){
        for (Employee employee : employees.values()){
            if (employee != null)
                System.out.println(employee.getFullName());
        }
    }
    public  Employee minSalary(){
        Employee employee = null;
        int min = Integer.MAX_VALUE;
        for (Employee emp : employees.values()){
            if (emp != null && emp.getSalary() < min){
                min = (int) emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public  Employee maxSalary(){
        Employee employee = null;
        int max = Integer.MIN_VALUE;
        for (Employee emp : employees.values()){
            if (emp != null && emp.getSalary() > max){
                max = (int) emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public  double averageSalary(){
        int aS = (int) (totalSalaries()/(double)employees.size());
        return aS;
    }
    public  int totalSalaries(){
        int sum = 0;
        for (Employee employee : employees.values()){
            if (employee != null  )
                sum += employee.getSalary();
        }
        return sum;
    }


    public  Employee departmentMaxSalary(int department){
        Employee employee = null;
        int max = Integer.MIN_VALUE;
        for (Employee emp : employees.values()){
            if (emp != null && emp.getSalary() > max && emp.getDepartment() == department){
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public  void indexSalary(int percent){
        double coff = 1 + percent/100D;
        for (Employee employee : employees.values()){
            if (employee != null)
                employee.setSalary((int) ((int) (employee.getSalary())*coff));
            System.out.println(employee);
        }
    }
    public void addEmployee(Employee employee){
        employees.put(getKey(employee),employee);

    }
    public void removeEmployee(Employee employee){
        employees.remove(getKey(employee));
    }
    public void removeEmployee(int id){
        for (Map.Entry<String,Employee>entry : employees.entrySet()){
            Employee employee = entry.getValue();
            String key = entry.getKey();
            if (employee.getId()==id){
                employees.remove(key);
                break;
            }
        }
    }
    private  Employee findEmployeeBYFullName(String fullName){
        for (Employee emp : employees.values()) {
            if (emp != null && emp.getFullName().equals(fullName)){
                return   emp;
            }
        }
        return null;
    }
    public void changeSalary(Employee employee,int newSalary){
        String key = getKey(employee);
        if (employees.containsKey(key)){
            employees.get(key).setSalary(newSalary);
        }
    }
    public void changeDepartment(Employee employee,int department){
        String key = getKey(employee);
        if (employees.containsKey(key)){
            employees.get(key).setDepartment(department);
        }
    }
    public void printEmployeeDepartments(){
        for (int department = 1; department <= 5; department++) {

            System.out.println("Сотрудники отдела " + department);
            for (Employee employee : employees.values()){
                if (Objects.nonNull(employee) && employee.getDepartment() == department){
                    System.out.println(employee.getFullName());
                }
            }
        }
    }
}
