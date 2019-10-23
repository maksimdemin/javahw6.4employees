package Company;

interface Employee extends Comparable<Employee> {


    double getMonthSalary();


    default int compareTo(Employee o) {
        return Double.compare(getMonthSalary(), o.getMonthSalary());
    }
}
