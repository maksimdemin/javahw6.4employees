package Company;

public class SaleManager extends Staff {

    private String profession;
    private double salary; // итоговая ЗП менеджера по продажам
    private static double saleAmount; // деньги, которую менеджер по продажам заработал для компании



    SaleManager(String name) { // конструктор менеджера по продажам
        super(name);
        profession = "Sale manager";
        salary = createSalary();
    }


    @Override
    public String getProfession() {
        return profession;
    }


    @Override
    double createSalary() {
        double bonus = saleAmount * 0.05; // 5% бонус с продаж
        double fixSalary = ((Math.random() * 20000) + 40000); // фиксированная ЗП менеджера по продажам от 40000 до 60000 руб.
        saleAmount = (Math.random() * 30000 + 10000);
        return fixSalary + bonus;
    }


    @Override
    public double getMonthSalary() {
        return salary;
    }


    static double getSaleAmount() { // метод для получения суммы, которую заработал менеджер по продажам для компании
        return saleAmount;
    }
}
