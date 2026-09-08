import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] food = {
            "Fried Chicken",
            "Spaghetti",
            "Siomai",
            "French Fries",
            "Iced Tea"
        };

        double[] price = {
            95.00,
            85.00,
            50.00,
            60.00,
            40.00
        };

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;

        System.out.println("===== CANTEEN MENU =====");

        for (int i = 0; i < food.length; i++) {
            System.out.printf("%d. %-15s - $%.2f%n",
                    i + 1, food[i], price[i]);
        }

        String again = "Y";

        while (again.equalsIgnoreCase("Y")) {

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            // Validate item and quantity
            if (itemNumber < 1 || itemNumber > 5 ||
                quantity < 1 || quantity > 10) {

                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().charAt(0);

            double subtotal = price[itemNumber - 1] * quantity;
            double discountRate;

            // Discount rules
            if (student == 'Y' || student == 'y') {

                if (subtotal >= 500) {
                    discountRate = 0.15;
                } else {
                    discountRate = 0.10;
                }

            } else {

                if (subtotal >= 500) {
                    discountRate = 0.05;
                } else {
                    discountRate = 0.00;
                }
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            totalItems += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;

            System.out.printf("%nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = input.next();
        }

        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n",
                totalDiscount);
        System.out.printf("Final amount: $%.2f%n",
                finalAmount);

        System.out.println("Thank you for ordering!");

        input.close();
    }
}
