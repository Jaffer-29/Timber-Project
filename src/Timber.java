import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Timber{

    Scanner in = new Scanner(System.in);
    char Zone;
    int TimberID, Quantity, Price;
    float Weight, Height;
    String Status , Kind;
    LocalDate date;
    Timber next, first, previous;
    int timberNumber = 0;

    Timber(){
        first = null;
    }

    public void timberEntry() throws Exception{

        char ch = 'y';
        System.out.println("Enter Data For Timber : ");

        while(ch == 'y'){
            Timber current  = new Timber();

            System.out.print("Timber ID : ");
            current.TimberID = in.nextInt();

            Timber temp = first;
            int flag = 0;

            while(temp != null){
                if(temp.TimberID == current.TimberID){
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
            if(flag == 1){
                System.out.println("Duplicate Timber ID, cannot insert.");
                System.out.println("Input New ID for Record");
                continue;
            }

            System.out.print("Timber Zone  : ");
            current.Zone = in.next().charAt(0);
            System.out.print("Timber kind : ");
            current.Kind = in.next();
            System.out.print("Quantity : ");
            current.Quantity = in.nextInt();
            System.out.print("Enter Per Piece Price : ");
            current.Price = in.nextInt();
            System.out.print("Weight : ");
            current.Weight = in.nextFloat();
            System.out.print("Height : ");
            current.Height = in.nextFloat();
            System.out.print("Status : ");
            current.Status = in.next();
            System.out.print("Current Data : ");
            current.date = LocalDate.now();

            System.out.println("\t_______________________________");

            if(first == null){
                first = previous = current;
            }
            else{
                previous.next = current;
                previous = current;
            }
            timberNumber++;
            System.out.print("Do You want to Add More Record : ");
            ch = in.next().charAt(0);
            ch = Character.toLowerCase(ch);
            current.writeFile();
        }
        System.out.println("Total Records Added in System : " + timberNumber);
    }

    public void showTimber() {

        int i = 0;
        Timber temp = first;
        System.out.println("\n\t\"Timber Data Output\"");
        if (temp == null) {
            System.out.println("Timber Record is Unavailable");
            return;
        }
        displayTableHeader();

        while(temp != null) {

            System.out.printf("| %-4s | %-9s | %-12s | %-10s | %-8s | %-9s | %-8s | %-8s | %-8s | %-10s\n",
                    (i + 1), temp.TimberID, temp.Zone, temp.Kind, temp.Quantity, temp.Price,
                    temp.Weight, temp.Height, temp.Status, temp.date
            );

            i++;
            temp = temp.next;

        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
        System.out.println("Total Timber in Inventory : " + timberNumber);
        System.out.println("___________________________________________________________________" +
                "________________________________________________");        }

    public void showZone() {
        Timber temp = first;
        int zoneFound = 0;
        int j = 1;

        System.out.println("\n\t\"Timber Data Output\"");

        if (temp == null) {
            System.out.println("Timber Record is Unavailable");
            return;
        }
        char[] zone = {'A', 'B', 'C', 'D'};

        displayTableHeader();
        for (int i = 0; i < 4; i++) {
            char currentZone = zone[i];
            temp = first;
            while (temp != null) {
                if (temp.Zone == currentZone) {
                    System.out.printf("| %-4s | %-9s | %-12s | %-10s | %-8s | %-9s | %-8s | %-8s | %-8s | %-10s\n",
                            j , temp.TimberID, temp.Zone, temp.Kind, temp.Quantity, temp.Price,
                            temp.Weight, temp.Height, temp.Status, temp.date
                    );
                    zoneFound++;
                    j++;
                }
                temp = temp.next;
            }
            System.out.println("___________________________________________________________________" +
                    "________________________________________________");
        }

        if(zoneFound == 0){
            System.out.println("The Timber are not Updated with Zone....");
            System.out.println("Leaving the System");
        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
    }

    public void searchZone(){

        Timber temp = first;
        int zoneNumber = 0;
        int i = 0;

        System.out.print("Enter Zone Zone Data to search : ");
        char searchZone = in.next().charAt(0);

        if (temp == null) {
            System.out.println("Timber Record is Unavailable");
            return;
        }
        displayTableHeader();
        while(temp != null) {

            if(temp.Zone == searchZone) {
                System.out.printf("| %-4s | %-9s | %-12s | %-10s | %-8s | %-9s | %-8s | %-8s | %-8s | %-10s\n",
                        (i + 1), temp.TimberID, temp.Zone, temp.Kind, temp.Quantity, temp.Price,
                        temp.Weight, temp.Height, temp.Status, temp.date
                );
                i++;
                zoneNumber++;
            }
            temp = temp.next;

        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
        if (zoneNumber != 0){
            System.out.println("Total Timber Found in System with same Zone Region : " + zoneNumber);
        }
        else{
            System.out.println("No Timber Record Found in System");
        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");        }

    public void KindSearch(){

        Timber temp = first;
        String searchKind;
        int i = 0;
        int searchK = 0;

        System.out.print("Enter timber kind : ");
        searchKind = in.next();

        if (temp == null) {
            System.out.println("Timber Record is Unavailable");
            return;
        }
        displayTableHeader();

        while(temp != null) {

            if(temp.Kind.equalsIgnoreCase(searchKind)) {
                System.out.printf("| %-4s | %-9s | %-12s | %-10s | %-8s | %-9s | %-8s | %-8s | %-8s | %-10s\n",
                        (i + 1), temp.TimberID, temp.Zone, temp.Kind, temp.Quantity, temp.Price,
                        temp.Weight, temp.Height, temp.Status, temp.date
                );
                i++;
                searchK++;
            }
            temp = temp.next;
        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
        if (searchK != 0){
            System.out.println("Total Timber Found in System with same Kind : " + searchK);
        }
        else{
            System.out.println("No Timber Record Found in System");
        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
    }

    public void Analysis(){

        System.out.println("\"Analyzing Timber Stock in Inventory\"");
        Timber temp = first;
        int i = 1;
        int stockCall = 0;
        System.out.print("Enter Lower Limit of Timber Stock to Search : ");
        int limit = in.nextInt();
        System.out.println("Looking in System for Timber Less than " + limit + " pieces");

        displayTableHeader();

        while(temp != null){
            if(temp.Quantity < limit){
                System.out.printf("| %-4s | %-9s | %-12s | %-10s | %-8s | %-9s | %-8s | %-8s | %-8s | %-10s\n",
                        i , temp.TimberID, temp.Zone, temp.Kind, temp.Quantity, temp.Price,
                        temp.Weight, temp.Height, temp.Status, temp.date
                );
                stockCall++;
                i++;
            }
            temp = temp.next;
        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
        if(stockCall == 0) {
            System.out.println("Inventory is sufficient. No low stock items.");
        }
        else{
            System.out.println("Report : \tLow stock detected");
            System.out.println("         \tRestocking required for \"" + stockCall +" Timbers\"");
        }
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
    }

    public void delete_Timber() throws Exception{

        System.out.println("\"Deleting Timber Record\"");
        System.out.println("\nSearched based Deletion.....");

        int searchId;
        System.out.print("Enter Timber ID to Search for : ");
        searchId = in.nextInt();
        int flage = 0;
        Timber temp = first;
        
        if (temp == null) {
            System.err.println("List Not Created Yet");
            return;
        }

        while (temp != null){
            if(temp.TimberID == searchId){
                flage = 1;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        if(flage == 1){
            System.out.println("Timber Record Found in System...");
            System.out.print("Do you really want to Delete the Records : ");
            char deleteOption = in.next().charAt(0);
            deleteOption = Character.toLowerCase(deleteOption);
            if(deleteOption == 'y') {
                if (temp == first) {
                    first = temp.next;
                } else {
                    previous.next = temp.next;
                }
                System.out.println("Record of Timber with ID " + searchId + " has been Deleted");
                timberNumber--;
                reWriteFile();
            }
            else{
                System.out.println("Deletion has been Stopped by User...");
                System.out.println("Leaving the System");
            }
        }
        else {
            System.out.println("Record Not Found in System");
            System.out.println("Invalid User Input.....!");
        }

    }

    public void updateTimber() throws Exception{

        System.out.println("\"Update Timber Stock'\"");
        Timber temp  = first;
        int searchID, flage = 0;


        System.out.println("A : Update Quantity");
        System.out.println("B : Update Price (Change)");

        System.out.print("Enter Choice : ");
        char choose = in.next().charAt(0);
        choose = Character.toUpperCase(choose);

        switch (choose){

            case 'A' ->{
                System.out.print("Enter ID to Search : ");
                searchID = in.nextInt();
                while(temp != null){
                    if(temp.TimberID == searchID){
                        flage = 1;
                        break;
                    }
                    temp = temp.next;
                }
                if(flage == 1){
                    System.out.print("Enter Quantity to Add : ");
                    int newQuantity = in.nextInt();
                    System.out.print("New Stock Weight : ");
                    int newWeight = in.nextInt();
                    System.out.print("New Stock Height : ");
                    int newHeight = in.nextInt();
                    if(newQuantity < 0){
                        System.out.println("Invalid Input by User");
                    }
                    else {
                        temp.Quantity += newQuantity;
                        temp.Weight += newWeight;
                        temp.Height += newHeight;
                        System.out.println("Stock has been Updated by User.");
                        reWriteFile();
                    }
                }else{
                    System.out.println("Invalid ID Searched by User...!");
                }
            }

            case 'B' ->{
                System.out.print("Enter ID to Search : ");
                searchID = in.nextInt();
                while(temp != null){
                    if(temp.TimberID == searchID){
                        flage = 1;
                        break;
                    }
                    temp = temp.next;
                }
                if(flage == 1){
                    System.out.print("Enter New Price : ");
                    int newPrice = in.nextInt();
                    if(newPrice < 0){
                        System.out.println("Invalid Input by User");
                    }
                    else {
                        temp.Price = newPrice;
                        System.out.println("Stock has been Updated by User.");
                        reWriteFile();
                    }
                }else{
                    System.out.println("Invalid ID Searched by User...!");
                }
            }

            default -> System.out.println("Invalid Id by User....");
        }
    }

    public void saleTimber() throws Exception{

        System.out.println("Sell Timber On Search base");
        System.out.println("A : Search by Timber ID");
        System.out.println("B : Search by Timber Kind");

        System.out.print("Enter Your Choice : ");
        char choice = in.next().charAt(0);
        choice = Character.toUpperCase(choice);

        switch (choice){
            case 'A' ->{
                System.out.print("Enter Timber ID : ");
                int searchID = in.nextInt();

                Timber temp = first;
                int flage = 0;

                while (temp != null){
                    if(temp.TimberID == searchID){
                        flage = 1;
                        break;
                    }
                    temp = temp.next;
                }

                if(flage == 1){

                    System.out.print("Enter Amount you want to buy : ");
                    int buyTimber = in.nextInt();

                    if(temp.Quantity >= buyTimber){

                        System.out.println("Timber is In-Stock");
                        int sell = (buyTimber  * temp.Price);
                        System.out.println("Selling Amount = " + sell);
                        temp.Quantity -= buyTimber;
                        System.out.println("Dispatching....");
                        if(temp.Quantity == 0){
                            temp.Status = "Sold";
                        }else {
                            temp.Status = "In-Stock";
                        }
                        reWriteFile();

                    }
                    else {
                        System.out.println("The Timber "+searchID+" is out of stock");
                        System.out.println("Sorry for inconvenience...");
                    }
                }
                else {
                    System.out.println("Invalid Timber ID enter by User");
                }
            }
            case 'B' ->{

                System.out.print("Enter Timber Kind : ");
                String searchKind = in.next();

                Timber temp = first;
                int flage = 0;

                while (temp != null){
                    if(temp.Kind.equalsIgnoreCase(searchKind)){
                        flage = 1;
                        break;
                    }
                    temp = temp.next;
                }

                if(flage == 1){

                    System.out.println("Enter Amount you want to buy : ");
                    int buyTimber = in.nextInt();

                    if(temp.Quantity >= buyTimber){
                        System.out.println("Timber is In-Stock");
                        int sell = (buyTimber  * temp.Price);
                        System.out.println("Selling Amount = " + sell);
                        temp.Quantity -= buyTimber;
                        System.out.println("Dispatching....");
                        if(temp.Quantity == 0){
                            temp.Status = "Sold";
                        }else {
                            temp.Status = "In-Stock";
                        }
                        reWriteFile();

                    }else {
                        System.out.println("The Timber "+searchKind+" is out of stock");
                        System.out.println("Sorry for inconvenience...");
                    }
                }else {
                    System.out.println("This Kind of Timber is not Available");
                }
            }
            default -> System.out.println("Invalid Choice by User....");
        }
    }

    public void InventoryReport(){
        Timber temp = first;
        if(temp == null){
            System.out.println("No Record Exists for Inventory System");
            return;
        }
        int totalItems = 0;
        int totalQuantity = 0;
        float totalWeight = 0;
        float totalHeight = 0;
        int totalValue = 0;

        int inStock = 0, sold = 0, reserved = 0;

        while (temp != null) {
            totalItems++;
            totalQuantity += temp.Quantity;
            totalWeight += temp.Weight;
            totalHeight += temp.Height;
            totalValue += (temp.Quantity * temp.Price);

            if (temp.Status != null) {
                if (temp.Status.equalsIgnoreCase("In Stock")) inStock++;
                else if (temp.Status.equalsIgnoreCase("Sold")) sold++;
                else if (temp.Status.equalsIgnoreCase("Reserved")) reserved++;
            }

            temp = temp.next;
        }

        System.out.println("\n\t\"Inventory Report\"");

        System.out.println("Total Timber Types     : " + totalItems);
        System.out.println("Total Quantity         : " + totalQuantity);
        System.out.println("Total Inventory Value  : " + totalValue);
        System.out.println("Average Weight         : " + (totalWeight / totalItems));
        System.out.println("Average Height         : " + (totalHeight / totalItems));
        System.out.println("\n\tStock Report");
        System.out.println("In Stock   : " + inStock);
        System.out.println("Sold       : " + sold);
        System.out.println("Reserved   : " + reserved);

        System.out.println("___________________________________________");
    }

    public void writeFile() throws Exception{

        System.out.println("\t\"Writing Timber Record\"");

        File f = new File("TimberData.txt");
        //        f.createNewFile();
        if(f.exists()){
            System.out.println("File Found in System");
        }else{
            System.out.println("Not Found in System");
        }
        System.out.println("Writing in File");

        BufferedWriter writer = new BufferedWriter(new FileWriter("TimberData.txt", true));
       

            String line =
                    this.TimberID +
                            " | " +
                            this.Zone +
                            " | " +
                            this.Kind +
                            " | " +
                            this.Quantity +
                            " | " +
                            this.Price +
                            " | " +
                            this.Weight +
                            " | " +
                            this.Height +
                            " | " +
                            this.Status +
                            " | " +
                            this.date;
            writer.write(line);
            writer.newLine();
            writer.close();
            System.out.println("Data written successfully");
    }

    public void ReadFile() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("TimberData.txt"));
        String line;
        int i = 1;
        displayTableHeader();
        first = null;
        previous = null;

        while ((line = reader.readLine()) != null){

            String[] data = line.split(" \\| ");
            Timber current = new Timber();

            current.TimberID = Integer.parseInt(data[0]);
            current.Zone = data[1].charAt(0);
            current.Kind = data[2];
            current.Quantity = Integer.parseInt(data[3]);
            current.Price = Integer.parseInt(data[4]);
            current.Weight = Float.parseFloat(data[5]);
            current.Height = Float.parseFloat(data[6]);
            current.Status = data[7];
//                current.date = LocalDate.parse(data[8]);

            showFile(current, i);
            i++;
            if(first == null){
                first = previous = current;
            } else {
                previous.next = current;
                previous = current;
            }
        }
        reader.close();
    }

    public void showFile(Timber temp, int i){

        System.out.printf("| %-4s | %-9s | %-12s | %-10s | %-8s | %-9s | %-8s | %-8s | %-8s | %-10s\n",
                i , temp.TimberID, temp.Zone, temp.Kind, temp.Quantity, temp.Price,
                temp.Weight, temp.Height, temp.Status, temp.date
        );

    }

    public void ReadFileOnly() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("TimberData.txt"));
        String line;
        first = null;
        previous = null;
        int timber = 0;

        while ((line = reader.readLine()) != null){

            String[] data = line.split(" \\| ");
            Timber current = new Timber();

            current.TimberID = Integer.parseInt(data[0]);
            current.Zone = data[1].charAt(0);
            current.Kind = data[2];
            current.Quantity = Integer.parseInt(data[3]);
            current.Price = Integer.parseInt(data[4]);
            current.Weight = Float.parseFloat(data[5]);
            current.Height = Float.parseFloat(data[6]);
            current.Status = data[7];
            current.date = LocalDate.parse(data[8]);

            if(first == null){
                first = previous = current;
            } else {
                previous.next = current;
                previous = current;
            }
            timber++;
        }
        reader.close();
        timberNumber = timber;
    }

    public void reWriteFile() throws Exception{

        BufferedWriter writer = new BufferedWriter(new FileWriter("TimberData.txt"));
        Timber temp = first;
        if (temp == null) {
            System.out.println("The List is not Created Yet");
            System.out.println("Returning to System....");
            return;
        }

        while(temp != null){
            String line =   temp.TimberID + " | " +
                    temp.Zone + " | " +
                    temp.Kind + " | " +
                    temp.Quantity + " | " +
                    temp.Price + " | " +
                    temp.Weight + " | " +
                    temp.Height + " | " +
                    temp.Status + " | " +
                    temp.date;
            writer.write(line);
            writer.newLine();
            temp = temp.next;
        }
        writer.close();
        System.out.println("File successfully updated.");
    }

    public static void displayTableHeader () {
        System.out.println("___________________________________________________________________" +
                "________________________________________________");
        System.out.printf("| %-4s | %-9s | %-12s | %-10s | %-8s | %-9s | %-8s | %-8s | %-8s | %-10s\n",
                "S.No","Timber ID", "Zone Address", "Kind", "Quantity","Price/Qty", "Weight",
                " Height", "Status", "Date");
        System.out.println("______________________________________________________" +
                "_____________________________________________________________");
    }
}