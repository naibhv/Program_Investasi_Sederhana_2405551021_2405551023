package org.tradingapp.userinterfaces;

import org.tradingapp.entities.NationalGovermentSecurities;
import org.tradingapp.services.CreateNationalGovermentSecuritiesService;
import org.tradingapp.services.GetNationalGovermentSecuritiesService;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class NationalGovermentSecuritiesAdminInterface {

    private final CreateNationalGovermentSecuritiesService createService = new CreateNationalGovermentSecuritiesService();
    private final GetNationalGovermentSecuritiesService getService = new GetNationalGovermentSecuritiesService();
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("|============================================================|");
            System.out.println("|     National Goverment Securities (NGS) Menu               |");
            System.out.println("|============================================================|");
            System.out.println("|  1. View All NGS                                           |");
            System.out.println("|  2. Create New NGS                                         |");
            System.out.println("|  3. Back                                                   |");
            System.out.println("|============================================================|");
            System.out.print("  Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewAllNGS();
                    break;
                case "2":
                    createNewNGS();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("|------------------------------------------------------------|");
                    System.out.println("|  >> Invalid option, please try again.                      |");
                    System.out.println("|------------------------------------------------------------|");
            }
        }
    }

    private void viewAllNGS() {
        List<NationalGovermentSecurities> list = getService.getAllSecurities();

        if (list.isEmpty()) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> No NGS available.                                      |");
            System.out.println("|------------------------------------------------------------|");
            return;
        }

        System.out.println("\nList of NGS:");
        for (NationalGovermentSecurities ngs : list) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("  Code: " + ngs.getCode());
            System.out.println("  Name: " + ngs.getName());
            System.out.println("  Interest Rate: " + ngs.getInterestRate() + "%");
            System.out.println("  On Month: " + ngs.getOnMonth());
            System.out.println("  Maturity Date: " + ngs.getMaturityDate());
            System.out.println("  National Quota: " + ngs.getNationalQuota());
            System.out.println("|------------------------------------------------------------|");

        }
    }

    private void createNewNGS() {
        try {
            System.out.println("|============================================================|");
            System.out.print("  Enter NGS code: ");
            String code = scanner.nextLine();

            System.out.print("  Enter NGS name: ");
            String name = scanner.nextLine();

            System.out.print("  Enter interest rate (%): ");
            double interestRate = Double.parseDouble(scanner.nextLine());

            System.out.print("  Enter duration (on month): ");
            int onMonth = Integer.parseInt(scanner.nextLine());

            System.out.print("  Enter maturity date (YYYY-MM-DD): ");
            LocalDate maturityDate = LocalDate.parse(scanner.nextLine());

            System.out.print("  Enter national quota: ");
            int nationalQuota = Integer.parseInt(scanner.nextLine());

            NationalGovermentSecurities newNGS = new NationalGovermentSecurities(
                    code, name, interestRate, onMonth, maturityDate, nationalQuota
            );

            boolean created = createService.create(newNGS);

            if (created) {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|  >> New NGS successfully created.                          |");
                System.out.println("|------------------------------------------------------------|");
            } else {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|  >> Failed: NGS with the same code already exists.         |");
                System.out.println("|------------------------------------------------------------|");
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("| >> Input error: please enter valid numbers and date format.|");
            System.out.println("|------------------------------------------------------------|");
        }
    }
}