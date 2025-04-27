package org.tradingapp.userinterfaces;

import org.tradingapp.entities.Customer;
import org.tradingapp.entities.Portfolio;
import org.tradingapp.entities.Stock;
import org.tradingapp.entities.NationalGovermentSecurities;
import org.tradingapp.services.*;

import java.util.List;
import java.util.Scanner;

public class HomeCustomerInterface {

    private BuyStockService buyStockService = new BuyStockService();
    private SellStockService sellStockService = new SellStockService();
    private BuyNationalGovermentSecuritiesService buyNGSService = new BuyNationalGovermentSecuritiesService();
    private NationalGovermentSecuritiesSimulation simulationService = new NationalGovermentSecuritiesSimulation();
    private GetPortfolioByUsername getPortfolioService = new GetPortfolioByUsername();
    private GetStockService getStockService = new GetStockService();
    private GetNationalGovermentSecuritiesService getNGSService = new GetNationalGovermentSecuritiesService();
    private LogoutService logoutService = new LogoutService();
    private Scanner scanner = new Scanner(System.in);

    public void display(Customer customer) {
        while (true) {
            System.out.println("|============================================================|");
            System.out.println("                Welcome, " + customer.getName());
            System.out.println("|============================================================|");
            System.out.println("|  1. Buy Stock                                              |");
            System.out.println("|  2. Sell Stock                                             |");
            System.out.println("|  3. Buy National Goverment Securities (NGS)                |");
            System.out.println("|  4. Simulate NGS Coupon                                    |");
            System.out.println("|  5. View Portfolio                                         |");
            System.out.println("|  6. View All Stock                                         |");
            System.out.println("|  7. View All National Goverment Securities                 |");
            System.out.println("|  8. Logout                                                 |");
            System.out.println("|============================================================|");
            System.out.print("    Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    buyStock(customer);
                    break;
                case "2":
                    sellStock(customer);
                    break;
                case "3":
                    buyNationalGovermentSecurities(customer);
                    break;
                case "4":
                    simulateNationalGovermentSecurities(customer);
                    break;
                case "5":
                    viewAllPortfolio(customer);
                    break;
                case "6":
                    showAllStocks();
                    break;
                case "7":
                    showAllNationalGovermentSecurities();
                    break;
                case "8":
                    logoutService.logout(customer);
                    System.out.println("|------------------------------------------------------------|");
                    System.out.println("|  >> Successfully logged out.                               |");
                    System.out.println("|------------------------------------------------------------|");
                    return;
                default:
                    System.out.println("|------------------------------------------------------------|");
                    System.out.println("|  >> Invalid option, please try again.                      |");
                    System.out.println("|------------------------------------------------------------|");
            }
        }
    }

    private void buyStock(Customer customer) {
        showAllStocks();
        System.out.print("Enter stock code: ");
        String code = scanner.nextLine();
        System.out.print("Enter amount to buy: ");
        int amount = Integer.parseInt(scanner.nextLine());

        boolean success = buyStockService.buyStock(customer, code, amount);
        if (success) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> Stock purchase successful.                             |");
            System.out.println("|------------------------------------------------------------|");
        } else {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> Stock code not found.                                  |");
            System.out.println("|------------------------------------------------------------|");
        }
    }

    private void sellStock(Customer customer) {
        showStockPortfolio(customer);
        System.out.print("Enter stock code to sell: ");
        String code = scanner.nextLine();
        System.out.print("Enter amount to sell: ");
        int amount = Integer.parseInt(scanner.nextLine());

        boolean success = sellStockService.sellStock(customer, code, amount);
        if (success) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> Stock sold successfully.                               |");
            System.out.println("|------------------------------------------------------------|");
        } else {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> Stock code not found or insufficient holdings.         |");
            System.out.println("|------------------------------------------------------------|");
        }
    }

    private void buyNationalGovermentSecurities(Customer customer) {
        showAllNationalGovermentSecurities();
        System.out.println("|============================================================|");
        System.out.print("    Enter NGS code: ");
        String code = scanner.nextLine();
        System.out.println("|============================================================|");
        System.out.print("    Enter investment amount in rupiah : ");
        Integer amount = scanner.nextInt();

        boolean success = buyNGSService.buySecurity(customer, code, amount);
        if (success) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> National Goverment Securities purchase successful.     |");
            System.out.println("|------------------------------------------------------------|");
        } else {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> NGS code not found.                                    |");
            System.out.println("|------------------------------------------------------------|");
        }
    }

    private void simulateNationalGovermentSecurities(Customer customer) {
        System.out.println("|============================================================|");
        System.out.print("    Enter NGS code to simulate: ");
        String code = scanner.nextLine();

        double monthlyCoupon = simulationService.simulateMonthlyCoupon(customer.getUsername(), code);
        if (monthlyCoupon == -1) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> NGS code not found or portfolio does not exist.|");
            System.out.println("|------------------------------------------------------------|");
        } else if (monthlyCoupon == 0) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> You do not own this NGS.|");
            System.out.println("|------------------------------------------------------------|");
        } else {
            System.out.println("|------------------------------------------------------------|");
            System.out.printf("    >> Estimated monthly coupon: Rp %.2f%n", monthlyCoupon);
            System.out.println("|------------------------------------------------------------|");
        }
    }

    private void showStockPortfolio(Customer customer) {
        Portfolio portfolio = getPortfolioService.getPortfolio(customer.getUsername());
        if (portfolio == null) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> No portfolio data available.                           |");
            System.out.println("|------------------------------------------------------------|");
            return;
        }

        System.out.println("\n====================== STOCK PORTFOLIO ======================");
        portfolio.groupStockRecordByCode().forEach(record -> {
            Stock stock  = getStockService.getStockByCode(record.getCode());
            System.out.println("- " + record.getCode() + ": " + record.getAmount() + " shares @ Rp" + record.getPrice()+ " current price @ " + record.getAmount() * stock.getPrice());
            System.out.println("\n|============================================================|");
        });

    }

    private void showNgsPortfolio(Customer customer){
        Portfolio portfolio = getPortfolioService.getPortfolio(customer.getUsername());
        if (portfolio == null) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> No portfolio data available.                           |");
            System.out.println("|------------------------------------------------------------|");
            return;
        }

        System.out.println("\n========== NATIONAL GOVERNMENT SECURITIES PORTFOLIO ==========");
        portfolio.getNationalGovermentSecuritiesRecords().forEach((code , record) -> {
            System.out.println("- " + record.getCode() + ": " + record.getInvestmentAmount());
            System.out.println("\n|============================================================|");
        });
    }

    private void viewAllPortfolio(Customer customer){
        showStockPortfolio(customer);
        showNgsPortfolio(customer);
    }

    private void showAllStocks() {
        List<Stock> list = getStockService.getAllStocks();

        if (list.isEmpty()) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> No stock available.                                    |");
            System.out.println("|------------------------------------------------------------|");
            return;
        }

        System.out.println("\n====================== AVAILABLE STOCKS ======================");
        for (Stock stock : list) {
            System.out.println("- " + stock.getCode() + " | " + stock.getCompanyName() + " | Rp" + stock.getPrice());
        }
        System.out.println("|============================================================|");
    }


    private void showAllNationalGovermentSecurities() {
        List<NationalGovermentSecurities> list = getNGSService.getAllSecurities();

        if (list.isEmpty()) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|  >> No SBN available.                                      |");
            System.out.println("|------------------------------------------------------------|");
            return;
        }

        System.out.println("\n========== AVAILABLE NATIONAL GOVERNMENT SECURITIES ==========");
        for (NationalGovermentSecurities sec : list) {
            System.out.println("- " + sec.getCode() + " | " + sec.getName()
                    + " | Interest Rate: " + sec.getInterestRate() + "% | Maturity: " + sec.getMaturityDate());
        }
        System.out.println("|============================================================|");
    }

}