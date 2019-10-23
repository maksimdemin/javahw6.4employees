package Company;

public class Clerk extends Staff {

    private String profession;
    private double salary; // итоговая ЗП клерка


    Clerk(String name) { // конструктор клерка
        super(name);
        profession = "Clerk";
        salary = createSalary();
    }


    @Override
    public String getProfession() {
        return profession;
    }


    public double createSalary() {
        return (Math.random() * 10000) + 30000; // фиксированная ЗП клерка от 30000 до 40000 руб.
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
