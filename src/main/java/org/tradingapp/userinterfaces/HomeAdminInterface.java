package org.tradingapp.userinterfaces;
import org.tradingapp.entities.Admin;
import org.tradingapp.services.LogoutService;
import java.util.Scanner;

public class HomeAdminInterface {

    private LogoutService logoutService = new LogoutService();
    private Scanner scanner = new Scanner(System.in);

    public Admin display(Admin admin) {
        while (true) {
            System.out.println("|============================================================|");
            System.out.println("                Welcome Admin:" + admin.getName());
            System.out.println("|============================================================|");
            System.out.println("|  1. Manage Stocks                                          |");
            System.out.println("|  2. Manage National Goverment Securities                   |");
            System.out.println("|  3. Logout                                                 |");
            System.out.println("|============================================================|");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    StockAdminInterface stockAdminInterface = new StockAdminInterface();
                    stockAdminInterface.display(admin);
                    break;
                case "2":
                    NationalGovermentSecuritiesAdminInterface nationalGovermentSecuritiesAdminInterface = new NationalGovermentSecuritiesAdminInterface();
                    nationalGovermentSecuritiesAdminInterface.display();
                    break;
                case "3":
                    admin = logoutService.logout(admin);
                    System.out.println("|------------------------------------------------------------|");
                    System.out.println("|  >> Successfully logged out.                               |");
                    System.out.println("|------------------------------------------------------------|");
                    return null;
                default:
                    System.out.println("|------------------------------------------------------------|");
                    System.out.println("|  >> Invalid option, please try again.                      |");
                    System.out.println("|------------------------------------------------------------|");
            }
        }
    }
}