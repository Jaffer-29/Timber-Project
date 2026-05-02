import java.util.Scanner;

public class TimberTest {
    public static void main(String[] arg) throws Exception{

        Scanner in = new Scanner(System.in);
        int choice;
        char chooseA;

        Timber timber = new Timber();
        timber.ReadFileOnly();

        do {
            System.out.println("\n\t\"Muhammad Umar Timber Store\"");
            System.out.println();

            System.out.println("1 : Add New Timber Record");
            System.out.println("2 : Display Timber Records");
            System.out.println("3 : Display Zone Based Records (sorted)");
            System.out.println("4 : Search Based Display");
            System.out.println("5 : Stock Analysis");
            System.out.println("6 : Sell Timber to Customer");
            System.out.println("7 : Update Stock");
            System.out.println("8 : Delete Timber Record");
            System.out.println("9 : Read File Data (Memory Level)");
            System.out.println("10 : Inventory Report");
            System.out.println("11 : Exists the System");

            System.out.println("\t________________________________");

            System.out.print("Enter your choice: ");
            String inputChoice = in.next();

            if(check(inputChoice) == 0){
                System.err.println("Input Error By User....");
                System.err.println("Leaving System...");
                return; 
            }

            choice = Integer.parseInt(inputChoice);

            switch (choice) {
                case 1 -> timber.timberEntry();
                case 2 -> timber.showTimber();
                case 3 -> timber.showZone();
                case 4 ->{
                    System.out.println("A : Search Records by Zone");
                    System.out.println("B : Search Records by Kind");
                    System.out.print("Enter your Choice : ");
                    char choose = in.next().charAt(0);
                    choose = Character.toUpperCase(choose);
                    switch (choose){
                        case 'A' -> timber.searchZone();
                        case 'B' -> timber.KindSearch();
                        default -> System.out.println("Invalid choice! Please try again.");
                    }
                }
                case 5 -> timber.Analysis();
                case 6 -> timber.saleTimber();
                case 7 -> timber.updateTimber();
                case 8 -> timber.delete_Timber();
                case 9 -> timber.ReadFile();
                case 10 -> timber.InventoryReport();
                case 11 -> System.exit(0);
                default -> System.out.println("Invalid choice! Please try again.");
            }
            System.out.print("Do you want to Continue with System : ");
            chooseA = in.next().charAt(0);
            chooseA = Character.toUpperCase(chooseA);

        } while (chooseA == 'y');
    }

    public static int check(String input){
        if(input.matches("\\d+")){
            int num = Integer.parseInt(input);
            if(num < 0){
                System.err.println("Negative Input By User");
                return 0;
            }
            return 1;
        }
        return 0;
    }

}