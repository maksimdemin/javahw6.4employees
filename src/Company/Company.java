package Company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Company {

    private int countStaff;
    private double incomeCompany;
    private TreeMap<Integer, Employee> staff = new TreeMap<>(); // список сотрудников компании

    private Company(int countStaff) {
        this.countStaff = countStaff;
    }

    public static Company createCompany(int countStaff) throws IOException { // метод для создания компании
        Company company = new Company(countStaff);
        company.toHire();
        return company;
    }

    private void toHire() throws IOException { // найм сотрудников
        for (int i = 0; i < countStaff; i++) {
            if (i < countStaff * 2 / 3) {
                staff.put(i, new Clerk(baseNames().get((int) (Math.random() * baseNames().size()))));
            }
            else if (countStaff * 2 / 3 <= i && i <= countStaff * 10 / 12) {
                staff.put(i, new SaleManager(baseNames().get((int) (Math.random() * baseNames().size()))));
                setIncomeCompany();
            }
            else staff.put(i, new TopManager(baseNames().get((int) (Math.random() * baseNames().size())), getIncomeCompany()));
        }
    }

    public void toDismiss(int personnelNumber) { // метод для увольнения сотрудника
        staff.remove(personnelNumber - 1);
    }


    public void getTopSalaryStaff(int count) { // распечатать заданное количество сотрудников с максимальными ЗП
        ArrayList<Employee> sortedStaff = new ArrayList<Employee>(staff.values()); // создаем новый список, так как Collections сортирует java.util.List
        Collections.sort(sortedStaff);
        System.out.printf("%n%d MAX salary %n", count);
        for (int i = 0; i < count; i++) {
            System.out.printf("%03d %s%n", i + 1, sortedStaff.get(staff.size() - count + i).toString());
        }
    }


    public void getLowerSalaryStaff(int count) { // распечатать заданное количество сотрудников с минимальными ЗП
        ArrayList<Employee> sortedStaff = new ArrayList<Employee>(staff.values()); // создаем новый список, так как Collections сортирует java.util.List
        Collections.sort(sortedStaff);
        System.out.printf("%n%d MIN salary %n", count);
        for (int i = 0; i < count; i++) {
                System.out.printf("%03d %s%n", i + 1, sortedStaff.get(i).toString());
        }
    }


    private ArrayList<String> baseNames() throws IOException { // создаем список имен (базу) сотрудников
        List<String> name = readNamesFromFile();
        return new ArrayList<>(name);
    }


    private List<String> readNamesFromFile() throws IOException { // метод для чтения информации из текстового файла
        return Files.readAllLines(Paths.get("data/names.txt"));
    }


    public void printInfoAboutStaff() { // распечатка всего штата сотрудников
        for (Integer i: staff.keySet()) {
            System.out.printf("%03d  %s%n", i+1, staff.get(i).toString());
        }
//        System.out.println(staff.size());
    }


    private double getIncomeCompany() {
        return incomeCompany;
    }

    private void setIncomeCompany() { // подсчет суммарной прибыли от продаж менеджеров
        incomeCompany += SaleManager.getSaleAmount();
    }


}
