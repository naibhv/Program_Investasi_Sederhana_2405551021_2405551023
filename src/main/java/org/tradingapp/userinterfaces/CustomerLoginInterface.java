package org.tradingapp.userinterfaces;
import org.tradingapp.entities.Customer;
import org.tradingapp.services.CustomerLoginService;
import java.util.Scanner;

public class CustomerLoginInterface {

    public CustomerLoginInterface() {}

    public void display() {
        Scanner scanner = new Scanner(System.in);
        CustomerLoginService customerLoginService = new CustomerLoginService();

        while (true) {
            System.out.println("|============================================================|");
            System.out.print("      Enter customer username: ");
            String inputUsername = scanner.nextLine();

            if (!customerLoginService.isUsernameExist(inputUsername)) {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|                   Username tidak ada.                      |");
                System.out.println("|------------------------------------------------------------|");
                continue;
            }

            System.out.println("\n");
            System.out.print("Enter password for " + inputUsername + ": ");
            String inputPassword = scanner.nextLine();

            Customer customer = customerLoginService.login(inputUsername, inputPassword);
            if (customer == null) {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("| Error: Incorrect password. Please enter username again.    |");
                System.out.println("|------------------------------------------------------------|");
                continue;
            }

            HomeCustomerInterface homeCustomerInterface = new HomeCustomerInterface();
            homeCustomerInterface.display(customer);
            break;
        }
    }
}