import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Stock> marketData = new HashMap<>();
        marketData.put("AAPL", new Stock("AAPL", 150.0));
        marketData.put("GOOGL", new Stock("GOOGL", 2800.0));
        marketData.put("TSLA", new Stock("TSLA", 700.0));

        Map<String, Integer> portfolio = new HashMap<>();
        double balance = 10000.0; // Starting cash

        System.out.println("--- Welcome to CodeAlpha Stock Trading ---");
        
        while (true) {
            System.out.println("\nBalance: $" + balance);
            System.out.println("Market Data: AAPL($150), GOOGL($2800), TSLA($700)");
            System.out.println("1. Buy Stock  2. Sell Stock  3. View Portfolio  4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 4) break;

            if (choice == 1) { // Buy
                System.out.print("Enter Symbol (AAPL/GOOGL/TSLA): ");
                String sym = sc.next().toUpperCase();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                if (marketData.containsKey(sym)) {
                    double cost = marketData.get(sym).price * qty;
                    if (balance >= cost) {
                        balance -= cost;
                        portfolio.put(sym, portfolio.getOrDefault(sym, 0) + qty);
                        System.out.println("Bought " + qty + " shares of " + sym);
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                }
            } else if (choice == 3) { // View
                System.out.println("Your Portfolio: " + portfolio);
            }
            // (Sell logic can be added similarly)
        }
        sc.close();
    }
}