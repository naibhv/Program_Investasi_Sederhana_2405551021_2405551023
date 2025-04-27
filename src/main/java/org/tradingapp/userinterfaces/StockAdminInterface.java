package org.tradingapp.userinterfaces;

import org.tradingapp.datasources.GlobalDataSource;
import org.tradingapp.entities.Admin;
import org.tradingapp.entities.Stock;
import org.tradingapp.services.CreateStockService;
import org.tradingapp.services.DeleteStockService;
import org.tradingapp.services.GetStockService;
import org.tradingapp.services.UpdateStockService;
import java.util.List;
import java.util.Scanner;

public class StockAdminInterface {

    private Scanner scanner = new Scanner(System.in);

    private CreateStockService createStockService = new CreateStockService();
    private UpdateStockService updateStockService = new UpdateStockService();
    private DeleteStockService deleteStockService = new DeleteStockService();
    private GetStockService getStockService = new GetStockService();

    public void display(Admin admin) {
        while (true) {
            System.out.println("|============================================================|");
            System.out.println("|                       Stock Management Menu                |");
            System.out.println("|============================================================|");
            System.out.println("|  1. View All Stocks                                        |");
            System.out.println("|  2. Add Stock                                              |");
            System.out.println("|  3. Update Stock Price                                     |");
            System.out.println("|  4. Delete Stock                                           |");
            System.out.println("|  5. Back                                                   |");
            System.out.println("|============================================================|");
            System.out.print("  Select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    viewAllStocks();
                    break;
                case "2":
                    addStock();
                    break;
                case "3":
                    updateStockPrice();
                    break;
                case "4":
                    deleteStock();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("|------------------------------------------------------------|");
                    System.out.println("|  >> Invalid option.                                        |");
                    System.out.println("|------------------------------------------------------------|");
            }
        }
    }

    private void viewAllStocks() {
        List<Stock> stocks = getStockService.getAllStocks();
        System.out.println("==================== All Available Stocks ====================");
        for (Stock stock : stocks) {
            System.out.println("Code: " + stock.getCode() + " | Company: " + stock.getCompanyName() + " | Price: " + stock.getPrice());
        }
        System.out.println("|============================================================|");
    }

    private void addStock() {
        System.out.print("Enter stock code: ");
        String code = scanner.nextLine();
        System.out.print("Enter company name: ");
        String name = scanner.nextLine();
        System.out.print("Enter stock price: ");
        int price = Integer.parseInt(scanner.nextLine());

        Stock stock = new Stock(name, price, code);
        boolean success = createStockService.create(stock);
        System.out.println ("|----------------------------|");
        System.out.println(success ? "|>> Stock added successfully.|" : "|  >> Failed to add stock.   |");
        System.out.println ("|------------------------------|");
    }

    private void updateStockPrice() {
        System.out.print("Enter stock code to update: ");
        String code = scanner.nextLine();
        System.out.print("Enter new price: ");
        int price = Integer.parseInt(scanner.nextLine());

        boolean success = updateStockService.updateStockPrice(code, price);
        System.out.println("|------------------------------------------------------------|");
        System.out.println(success ? "|  >> Stock price updated successfully.  success ? |" : "|  >> Failed to update stock price. success ?                |");
        System.out.println("|------------------------------------------------------------|");
    }

    private void deleteStock() {
        System.out.print("Enter stock code to delete: ");
        String code = scanner.nextLine();

        boolean success = deleteStockService.deleteStockByCode(code);
        System.out.println("|------------------------------------------------------------|");
        System.out.println(success ? "|  >> Stock deleted successfully.                            |" : "|  >> Failed to delete stock.                                |");
        System.out.println("|------------------------------------------------------------|");
    }
}