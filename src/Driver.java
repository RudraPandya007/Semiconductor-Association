import java.util.Scanner;

public class Driver {
    private static boolean isValidDateInput(String input) {
        return input.matches("\\d{4}-\\d{2}-\\d{2}");
    }
    public static void main(String[] args) {
        IndustryAnalysis analysis = new IndustryAnalysis();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to Semiconductor Industry Analysis Project!");
        System.out.println();
        System.out.println("Here are the the ticker files: AMAT, AMD, ASML, ASX, AVGO, INTC, MU, NVDA, QCOM, and TSM");
        System.out.print("Enter the ticker of your choice: ");
        String csv = StdIn.readString();
        csv = csv.toUpperCase() + ".csv";
        analysis.readCSVFile(csv);

        Scanner scanner = new Scanner(System.in);

        // Display menu options
        System.out.println();
        System.out.println("Please choose an option:");
        System.out.println("1. Specific Date Information");
        System.out.println("2. Volume Analysis of a specific ");
        System.out.println("3. Percent Change");
        System.out.println("4. Max and Min Profits");
        System.out.println("5. Forward profits with their dates and volumes to a file");
        System.out.println("6. Forward sorted profits with their dates and volumes to a file");
        System.out.println("7. Forward prices with their dates and volumes to a file");
        System.out.println("8. Exit");

        int choice = -1;
        do {
            System.out.println();
            System.out.print("Enter your choice (1-8): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 8) {
                    System.out.println("Invalid choice! Please enter a number between 1 and 8.");
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println();
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("You entered option 1!");
                            System.out.print("Enter date (YYYY-MM-DD): ");
                            String case1_date = scanner.nextLine();
                            if (!isValidDateInput(case1_date)) {
                                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                                break;
                            }
                            analysis.SpecificDateInfo(IndustryAnalysis.dataArrayList, case1_date);
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("You entered option 2!");
                            System.out.print("Enter the earlier date (YYYY-MM-DD): ");
                            String case2_date1 = scanner.nextLine();
                            System.out.print("Enter the later date (YYYY-MM-DD): ");
                            String case2_date2 = scanner.nextLine();
                            if (!isValidDateInput(case2_date1) || !isValidDateInput(case2_date2)){
                                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                                break;
                            }
                            long[] volume_data = analysis.DatedVolumeAnalysis(IndustryAnalysis.dataArrayList, case2_date1, case2_date2);
                            System.out.println("Opening Volume: " + volume_data[0]);
                            System.out.println("Closing Volume: " + volume_data[1]);
                            System.out.println("Average Volume: " + volume_data[2]);
                            System.out.println("Sum of Marginal Difference in Volumes: " + volume_data[3]);
                            break;
                        case 3:
                            System.out.println();
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("You entered option 3!");
                            System.out.print("Enter date (YYYY-MM-DD): ");
                            String case3_date = scanner.nextLine();
                            if (!isValidDateInput(case3_date)){
                                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                                break;
                            }
                            double[] change_data = analysis.PercentChange(IndustryAnalysis.dataArrayList, case3_date);
                            System.out.println("Percentage change in Closing Price with Opening Price: " + change_data[0] + "%");
                            System.out.println("Percentage change in Highest Price with Opening Price: " + change_data[1] + "%");
                            System.out.println("Percentage change in Lowest Price with Opening Price: " + change_data[2] + "%");
                            break;
                        case 4:
                            System.out.println();
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("You entered option 4!");
                            String[] max_min_profits = analysis.MaxMinProfits(IndustryAnalysis.dataArrayList);
                            System.out.println("Maximum Profit is " + max_min_profits[0] + " on date " + max_min_profits[1]);
                            System.out.println("Minimum Profit is " + max_min_profits[2] + " on date " + max_min_profits[3]);
                            break;
                        case 5:
                            System.out.println();
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("You entered option 5!");
                            System.out.print("Enter the earlier date (YYYY-MM-DD): ");
                            String case5_date1 = scanner.nextLine();
                            System.out.print("Enter the later date (YYYY-MM-DD): ");
                            String case5_date2 = scanner.nextLine();
                            if (!isValidDateInput(case5_date1) || !isValidDateInput(case5_date2)){
                                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                                break;
                            }
                            //profits array to profits.out
                            double[] profits_array = analysis.ProfitsArray(IndustryAnalysis.dataArrayList, case5_date1, case5_date2);
                            StdOut.setFile("Profits.out");
                            StdOut.println("Profits");
                            for (double profit : profits_array){
                                StdOut.println(profit);
                            }
                            System.out.println("Output forwarded to Profits.out");

                            //dates array to dates.out
                            String[] dates_array = analysis.DatesArray(IndustryAnalysis.dataArrayList, case5_date1, case5_date2);
                            StdOut.setFile("Dates.out");
                            StdOut.println("Dates");
                            for (String date : dates_array){
                                StdOut.println(date);
                            }
                            System.out.println("Output forwarded to Dates.out");

                            //volumes array to volumes.out
                            int[] volumes_array = analysis.VolumesArray(IndustryAnalysis.dataArrayList, case5_date1, case5_date2);
                            StdOut.setFile("Volumes.out");
                            StdOut.println("Volumes");
                            for (int volume : volumes_array){
                                StdOut.println(volume);
                            }
                            System.out.println("Output forwarded to Volumes.out");
                            break;
                        case 6:
                            System.out.println();
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("You entered option 6!");
                            System.out.print("Enter the earlier date (YYYY-MM-DD): ");
                            String case8_date1 = scanner.nextLine();
                            System.out.print("Enter the later date (YYYY-MM-DD): ");
                            String case8_date2 = scanner.nextLine();
                            if (!isValidDateInput(case8_date1) || !isValidDateInput(case8_date2)) {
                                System.out.println("Invalid date format. Please enter dates in YYYY-MM-DD format.");
                                break;
                            }
                            //forward sorted profits to SortedProfits.out
                            double [] profits_array_8 = analysis.ProfitsArray(IndustryAnalysis.dataArrayList, case8_date1, case8_date2);
                            double [] sorted_profits_array = analysis.SortedProfitsArray(profits_array_8);
                            StdOut.setFile("SortedProfits.out");
                            StdOut.println("Sorted Profits");
                            for (double profit : sorted_profits_array){
                                StdOut.println(profit);
                            }
                            System.out.println("Output forwarded to SortedProfits.out");

                            //forward parallel dates to SortedDates.out
                            String[] parallel_sorted_dates = analysis.ParallelSortedDatesArray(IndustryAnalysis.dataArrayList, case8_date1, case8_date2);
                            StdOut.setFile("ParallelDates.out");
                            StdOut.println("Dates of sorted profits");
                            for (String date : parallel_sorted_dates){
                                StdOut.println(date);
                            }
                            System.out.println("Output forwarded to SortedDates.out");

                            //forward parallel volumes to SortedVolumes.out
                            int[] parallel_sorted_volumes = analysis.ParallelSortedVolumesArray(IndustryAnalysis.dataArrayList, case8_date1, case8_date2);
                            StdOut.setFile("ParallelVolumes.out");
                            StdOut.println("Volumes of sorted profits");
                            for (int volume : parallel_sorted_volumes){
                                StdOut.println(volume);
                            }
                            System.out.println("Output forwarded to SortedVolumes.out");
                            break;
                        case 7:
                            System.out.println();
                            System.out.println("-----------------------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("You entered option 7!");
                            System.out.print("Enter the earlier date (YYYY-MM-DD): ");
                            String case9_date1 = scanner.nextLine();
                            System.out.print("Enter the later date (YYYY-MM-DD): ");
                            String case9_date2 = scanner.nextLine();
                            if (!isValidDateInput(case9_date1) || !isValidDateInput(case9_date2)) {
                                System.out.println("Invalid date format. Please enter dates in YYYY-MM-DD format.");
                                break;
                            }
                            //prices to PricesOverTime.out
                            double[] prices_array = analysis.PricesOverTimePeriod(IndustryAnalysis.dataArrayList, case9_date1, case9_date2);
                            StdOut.setFile("PricesOverTime.out");
                            StdOut.println("Prices over time");
                            for (double prices : prices_array){
                                StdOut.println(prices);
                            }
                            System.out.println("Output forwarded to PricesOverTime.out");

                            //dates to DatesOverTime.out
                            String[] dates_array_to_prices = analysis.DatesArray(IndustryAnalysis.dataArrayList, case9_date1, case9_date2);
                            StdOut.setFile("DatesOverTime.out");
                            StdOut.println("Dates over time");
                            for (String date : dates_array_to_prices){
                                StdOut.println(date);
                            }
                            System.out.println("Output forwarded to DatesOverTime.out");

                            //volumes to VolumesOverTime.out
                            int[] volumes_array_to_prices = analysis.VolumesArray(IndustryAnalysis.dataArrayList, case9_date1, case9_date2);
                            StdOut.setFile("VolumesOverTime.out");
                            StdOut.println("Volumes Over Time");
                            for (int volume : volumes_array_to_prices){
                                StdOut.println(volume);
                            }
                            System.out.println("Output forwarded to VolumesOverTime.out");
                            break;
                        case 8:
                            System.out.println("Thank you for your time!");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer choice.");
            }
        } while (choice != 8);

        // Close the scanner
        scanner.close();
    }
}
