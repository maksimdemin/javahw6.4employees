package Company;

public class TopManager extends Staff{

    private String profession;
    private double salary; // итоговая ЗП топ-менеджера



    TopManager(String name, double income) { // конструктор топ-менеджера
        super(name);
        profession = "Top manager";
        salary = createSalary(income);
    }


    @Override
    public String getProfession() {
        return profession;
    }


    private double createSalary(double income) {
        double bonus = income > 1000000 ? Math.random() * 50000 + 10000 : 0; // если прибыль компании больше 1 млн, то топ-менеджер получает бонус
        double fixSalary = ((Math.random() * 20000) + 70000); // фиксированная ЗП топ-менеджера по продажам от 70000 до 90000 руб.
        return fixSalary + bonus;
    }


    @Override
    public double getMonthSalary() {
        return salary;
    }
}
