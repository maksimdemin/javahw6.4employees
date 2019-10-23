import Company.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Company newCompany = Company.createCompany(270); // создаем новую компанию и нанимаем 270 сотрудников
        newCompany.printInfoAboutStaff(); // весь список сотрудников

        newCompany.getLowerSalaryStaff(10); // 3 минимальные ЗП
        newCompany.getTopSalaryStaff(10); // 3 максимальные ЗП

        newCompany.toDismiss(270); // уволили сотрудника
    }
}
