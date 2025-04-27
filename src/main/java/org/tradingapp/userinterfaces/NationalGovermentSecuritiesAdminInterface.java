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
            System.out.println("|     National Goverment Securities (SBN) Menu               |");
            System.out.println("|============================================================|");
            System.out.println("|  1. View All SBN                                           |");
            System.out.println("|  2. Create New SBN                                         |");
            System.out.println("|  3. Back                                                   |");
            System.out.println("|============================================================|");
            System.out.print("  Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewAllSBN();
                    break;
                case "2":
                    createNewSBN();
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

    private void viewAllSBN() {
        List<NationalGovermentSecurities> list = getService.getAllSecurities();

        if (list.isEmpty()) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> No SBN available.                                      |");
            System.out.println("|------------------------------------------------------------|");
            return;
        }

        System.out.println("\nList of SBN:");
        for (NationalGovermentSecurities sbn : list) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("  Code: " + sbn.getCode());
            System.out.println("  Name: " + sbn.getName());
            System.out.println("  Interest Rate: " + sbn.getInterestRate() + "%");
            System.out.println("  On Month: " + sbn.getOnMonth());
            System.out.println("  Maturity Date: " + sbn.getMaturityDate());
            System.out.println("  National Quota: " + sbn.getNationalQuota());
            System.out.println("|------------------------------------------------------------|");

        }
    }

    private void createNewSBN() {
        try {
            System.out.println("|============================================================|");
            System.out.print("  Enter SBN code: ");
            String code = scanner.nextLine();

            System.out.print("  Enter SBN name: ");
            String name = scanner.nextLine();

            System.out.print("  Enter interest rate (%): ");
            double interestRate = Double.parseDouble(scanner.nextLine());

            System.out.print("  Enter duration (on month): ");
            int onMonth = Integer.parseInt(scanner.nextLine());

            System.out.print("  Enter maturity date (YYYY-MM-DD): ");
            LocalDate maturityDate = LocalDate.parse(scanner.nextLine());

            System.out.print("  Enter national quota: ");
            int nationalQuota = Integer.parseInt(scanner.nextLine());

            NationalGovermentSecurities newSbn = new NationalGovermentSecurities(
                    code, name, interestRate, onMonth, maturityDate, nationalQuota
            );

            boolean created = createService.create(newSbn);

            if (created) {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|  >> New SBN successfully created.                          |");
                System.out.println("|------------------------------------------------------------|");
            } else {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|  >> Failed: SBN with the same code already exists.         |");
                System.out.println("|------------------------------------------------------------|");
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("| >> Input error: please enter valid numbers and date format.|");
            System.out.println("|------------------------------------------------------------|");
        }
    }
}