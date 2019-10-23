package Company;

public abstract class Staff implements Employee{

    private String name;
    private double salary;

    Staff(String name) {
        this.name = name;
    }


    private String getName() {
        return name;
    }


    abstract String getProfession();



    double createSalary() {
        return salary;
    }

    public String toString() { // форматирование строки для вывода общей информации
        return String.format("%-35s %-15s %-10.2f %s", getName(), getProfession(), getMonthSalary(), "rub");
    }

}
