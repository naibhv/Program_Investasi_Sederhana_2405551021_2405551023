package org.tradingapp.userinterfaces;

import java.util.Scanner;

public class MainInterface {


    public void display(){
        while (true){
            System.out.println(
                    """
                    |============================================================|
                    |                  Pilih Login Sebagai :                     |
                    |============================================================|
                    |  1. Admin                                                  |
                    |  2. Customer                                               |
                    |  3. Exit                                                   |
                    |============================================================| 
                    """
            );
            System.out.print ("  Pilih salah satu :");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if(option == 3) {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|                        Terima kasih                        |");
                System.out.println("|------------------------------------------------------------|");
                break;
            }
            switch (option){
                case 1 -> {
                    AdminLoginInterface adminLoginInterface = new AdminLoginInterface();
                    adminLoginInterface.display();
                }
                case 2 -> {
                    CustomerLoginInterface customerLoginInterface = new CustomerLoginInterface();
                    customerLoginInterface.display();
                }
                default -> {
                    System.out.println("|------------------------------------------------------------|");
                    System.out.println("|                        Tidak ada opsi                      |");
                    System.out.println("|------------------------------------------------------------|");
                }
            }
        }
    }
}