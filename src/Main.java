import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random(17);
    private static String[] NAMES = {"Андрей "," Кирилл "," Сергей "," Николай "," Иван "," Алексей "," Никита "};
    private static String[] SURNAMES = {" Кириллович"," Сергеевич "," Николаевич "," Анатольевич "," Алексеевич "," Никитович "," Андреевич "};
    private static String[] PATRONYMIC_NAMES = {"Кириллов","Сергеев","Николаев","Зайцев","Алексеев","Никитов","Андреев"};
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();
        for (int i = 0; i < 7; i++) {
            employeeBook.addEmployee(generate());
        }
        employeeBook.printFullInfo();
        employeeBook.changeSalary(employeeBook.departmentMinSalary(4),3);
        employeeBook.changeDepartment(employeeBook.departmentMinSalary(2),3);
        employeeBook.printFullInfo();

        employeeBook.removeEmployee(employeeBook.departmentMinSalary(3).getId());

        employeeBook.printFullInfo();
        employeeBook.printFullName();
        employeeBook.indexSalary(50);

        System.out.println("averageDepartment(1) = " + employeeBook.averageDepartment(1));
        System.out.println("totalSalaries() = " + employeeBook.totalSalaries());
        System.out.println("minSalary() = " + employeeBook.minSalary());
        System.out.println("maxSalary() = " + employeeBook.maxSalary());
        System.out.println("averageSalary() = " + employeeBook.averageSalary());
        System.out.println("departmentMinSalary(3) = " + employeeBook.departmentMinSalary(3));
        System.out.println("departmentMaxSalary(1) = " + employeeBook.departmentMaxSalary(1));
        System.out.println("departmentSum(1) = " + employeeBook.departmentSum(1));
        employeeBook.indexSalaryDepartment(1,50);


        employeeBook.printEmployeeDepartments();
    }
    private static Employee generate(){

        String fullName = NAMES[RANDOM.nextInt(NAMES.length)] +
                SURNAMES[RANDOM.nextInt(SURNAMES.length)] +
                PATRONYMIC_NAMES[RANDOM.nextInt(PATRONYMIC_NAMES.length)];
        return new Employee(
                fullName,
                RANDOM.nextInt(1, 6),
                RANDOM.nextInt(90000,300000)
        );
    }
}