import java.util.ArrayList;
/*
 * @creator Rudra Pandya. 
 * Description 
 * 
 * https://www.investopedia.com/articles/markets/012216/worlds-top-10-semiconductor-companies-tsmintc.asp

 * World's leading semiconductor companies such as: 
 *  -> Applied Materials (AMAT)
 *  -> Advanced Micro Devices (AMD) 
 *  -> Advanced Semiconductor Materials Lithography (ASML)
 *  -> ASE Technology Holding (ASX)
 *  -> Broadcom Inc (AVGO) 
 *  -> Intel (INTC)
 *  -> Micron Technology (MU)
 *  -> Nvidia (NVDA)
 *  -> Qualcomm (QCOM)
 *  -> Taiwan Semiconductor Manufacturing (TSM)
 * 
 * These companies' data such as the stock date, volume, opening price, closing price, highest price, lowest price, adjusted closing price have been
 * analyzed by some functions. In addition, the use of quicksort functions to sort the maximum profits with respect to their parallel recorded dates and recorded 
 * volumes prove as sufficient data to perform stock analysis. In definition, quicksort sorting algorithm is one of the world's fastest algorithms with an average
 * complexity of O(n*logn). It efficiency proves applicable to real-world institutions to perform seperate and in-depth analysis from their end. 
 * 
 * The methods are as follows:
 *  1) readCSV file
 *  2) Specific Date Info
 *  3) Volume Analysis
 *  4) Percent Change
 *  5) Two Date change
 *  6) Max Min Profits
 *  7) Profits Array -> Sorted Profits Array
 *  8) Parallel Volumes
 *  9) Parallel Dates
 * 
 * The respective CSV files of the mentioned companies' stock data is in the project. They were located from Kaggle, credits to Jiun Yen for uploading them. 
 * 
 * GitHub Note: please do not copy this project on your own and claim it as your own work. You may use my project as long as you cite me or my ideas if inspired from here. 
 *  
 * The description of these methods is provided one by one before them.
 * 
 * -> Edit (5/21/2024): Added more rows to NVDA to showcase growth from 2020-2024
 * -> Edit (5/21/2024): Added ARM stock, a new semiconductor company from UK
 */ 
public class IndustryAnalysis {

    //public static variable of type ArrayList holding StockData stored in dataArrayList.
    public static ArrayList<StockData> dataArrayList;

    //constructor for the ArrayList
    public IndustryAnalysis() {
        dataArrayList = new ArrayList<>();
    }

    /*
     * Method: reading csv file
     * Description: the csv file are formatted as date, volume, opening price, closing price, highest price, lowest price, and adjusted closing-in price. 
     * Consecutively speaking, they are of type String, int, and doubles. Using StdIn.setFile(csvFile) to read the csv file and skipping the directional header line
     * by using StdIn.readLine(). Using a while loop to read each contents and initializing each constructor of StockData and then adding it to the dataArrayList
     * one by one. 
     */
    public void readCSVFile(String csvFile) {
        StdIn.setFile(csvFile);
        StdIn.readLine();

        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] contents = line.split(",");

            String date = contents[0];
            int volume = Integer.parseInt(contents[1]);
            double openingPrice = Double.parseDouble(contents[2]);
            double closingPrice = Double.parseDouble(contents[3]);
            double highestPrice = Double.parseDouble(contents[4]);
            double lowestPrice = Double.parseDouble(contents[5]);
            double adjustedClosingPrice = Double.parseDouble(contents[6]);
            StockData stockData = new StockData(date, volume, openingPrice, closingPrice, highestPrice, lowestPrice, adjustedClosingPrice);
            dataArrayList.add(stockData);
        }
    }
    /*
     * Method 1: getting specific date information
     * Now that the CSV file is read and the contents of it are stored in array list. We can have a date parameter to retrieve anything from that date. 
     * The return type here is void as we are printing out the information using StdOut.java 
     */
    public void SpecificDateInfo(ArrayList<StockData> list, String date) {
        for (StockData stockinfo : list){
            if (stockinfo.getDate().equalsIgnoreCase(date)){
                StdOut.println("Date: " + stockinfo.getDate());
                StdOut.println("Volume: " + stockinfo.getVolume());
                StdOut.println("Opening Price: " + stockinfo.getOpeningPrice());
                StdOut.println("Closing-in Price: " + stockinfo.getClosingInPrice());
                StdOut.println("Highest Price: " + stockinfo.getHighestPrice());
                StdOut.println("Lowest Price: " + stockinfo.getLowestPrice());
                StdOut.println("Adjusted Closing-in Price: " + stockinfo.getClosingInPrice());
            }
        }
    }

    /*
     * Method 2: analyzing volume from specific dates
     * Now that the CSV file is read and the contents of it are stored in array list. We can have a date parameter to retrieve volume and analyzing it by getting
     * average volume until that date (inclusively) and retrieve volume of that date followed by retrieving the number difference between yesterday's volume and the dated
     * volume. We are going to be looping from bottom-up as the top-most data on the csv file record latest stock data. 
     * 
     * Edge cases:
     * If the date is not found, -1 would be in place for that date's volumes. 
     * If the later date index is at least more than the earlier date index, -1 would be in place for average volume and sum of 
     * marginal differences. 
     * 
     * Remember, we are going from bottom to top. The top-most number in the csv file represents latest date of the stock information. The 
     * bottom-most number represents the earliest date in the csv file. Meaning, it is in descending order time-wise. That being said, 
     * the early date index must be more than the than the later date index just index wise (speaking on number of the index alone). 
     * The return type is long as we are dealing with big numbers, especially for average and marginal difference sum. Using double would
     * lead to scientific notations which would be hard to visually process. 
     */
    public long[] DatedVolumeAnalysis(ArrayList<StockData> list, String opening_date, String closing_date){
        long [] volume_data = new long[4];

        //retrieving opening date and closing date volumes and storing them in index 0 and index 1 respectively.
        long opening_volume = 0; long closing_volume = 0;
        for (StockData data : list) {if (data.getDate().equalsIgnoreCase(opening_date)){ opening_volume = data.getVolume();}} volume_data[0] = opening_volume;
        for (StockData data : list) {if (data.getDate().equalsIgnoreCase(closing_date)){ closing_volume = data.getVolume();}} volume_data[1] = closing_volume;

        if (opening_volume > 0 && closing_volume > 0){volume_data[0] = opening_volume; volume_data[1] = closing_volume;}
        else{volume_data[0] = -1; volume_data[1] = -1;}

        //getting the volume average
        int opening_volume_index = 0; int closing_volume_index = 0; long volume_total = 0; int volume_count = 0;
        for (int i = list.size() - 1; i >= 0; i--){if (list.get(i).getDate().equalsIgnoreCase(opening_date)){ opening_volume_index = i;}}
        for (int j = list.size() - 1; j >= 0; j--){if (list.get(j).getDate().equalsIgnoreCase(closing_date)) { closing_volume_index = j;}}

        if (closing_volume_index >= opening_volume_index || opening_volume_index == closing_volume_index){volume_data[2] = -1;}
        else {
            for (int i = opening_volume_index; i >= closing_volume_index; i--){
                volume_total += list.get(i).getVolume();
                volume_count += 1;
            }
            long volume_average = volume_total / volume_count;
            volume_data[2] = volume_average;
        }
        //getting the sum of marginal differences
        int marginal_difference_sum = 0;
        if (closing_volume_index >= opening_volume_index || opening_volume_index == closing_volume_index){volume_data[3] = -1;}
        else{
            for (int i = opening_volume_index; i > closing_volume_index; i--){
                int curr = list.get(i).getVolume();
                int next = list.get(i-1).getVolume();
                marginal_difference_sum = marginal_difference_sum + (next - curr);
            }
            volume_data[3] = marginal_difference_sum;
        }
        return volume_data;
    }
    /*
     * Method 3: analyzing percent change of a specific date
     * From a particular date, we are going to be finding percentage change of closing price, lowest price, and highest price with 
     * respect to opening price. Here, we are going to be using percent change formula i.e (new - old)/old * 100. This is where old is 
     * opening price and the new is either closing, lowest, or highest price. 
     * The contents of the percentage change are going to be individually stored into a type double array. 
     */
    public double[] PercentChange(ArrayList<StockData> list, String date) {
        double[] change_data = new double[3];
        
        double specific_closing = 0; double specific_opening = 0;
        double specific_high = 0; double specific_low = 0;
        for (StockData data : list){
            if (data.getDate().equalsIgnoreCase(date)){
                specific_closing = data.getClosingInPrice();
                specific_opening = data.getOpeningPrice();
                specific_high = data.getHighestPrice();
                specific_low = data.getLowestPrice();
            }
        }
        double percent_1 = ((specific_closing - specific_opening) / (specific_opening)) * 100;
        double percent_2 = ((specific_high - specific_opening) / (specific_opening)) * 100;
        double percent_3 = ((specific_low - specific_opening) / (specific_opening)) * 100;
        change_data[0] = percent_1; change_data[1] = percent_2; change_data[2] = percent_3;

        return change_data;
    }
    /*
     * Method 4: calculating maximum and minimum profits with their respective dates. 
     * Here, we are going to be taking in just one parameter which is the dataArrayList where the csv file is stored. As the goal is to 
     * retrieve the maximum and minimum volume with their dates, the best return type here would be String. Normally speaking, we would 
     * store the lowest and maximum profits in double, but due to the return type we can change it to String using .toString() operation.
     * The dates could be found easily by storing it as an empty variable. We are going to briefly store it in a String array and then 
     * return it. 
     * 
     * Pro tip: Sorted profits would be forwarded to the output file and you can check minimum and maximum profits and verify it from 
     * that function. Along with that, the use of parallel dates would verify your dates also!
     */
    public String[] MaxMinProfits(ArrayList<StockData> list){
        double max_profit = 0; String date_of_maxProfit = "";
        for (StockData data : list){
            double profit = data.getHighestPrice() - data.getLowestPrice();
            if (profit > max_profit){
                max_profit = profit;
                date_of_maxProfit = data.getDate();
            }
        }
        double min_profit = Double.MAX_VALUE; String date_of_minProfit = "";
        for (StockData data : list){
            double loss = data.getHighestPrice() - data.getLowestPrice();
            if (loss < min_profit){
                min_profit = loss;
                date_of_minProfit = data.getDate();
            }
        }
        String stringed_max_profit = Double.toString(max_profit);
        String stringed_min_profit = Double.toString(min_profit);

        String[] contents = new String[4];
        contents[0] = stringed_max_profit;
        contents[1] = date_of_maxProfit;
        contents[2] = stringed_min_profit;
        contents[3] = date_of_minProfit;
        return contents;
    }
    /*
     * Method 5: forwaring profits (unsorted) to an output file
     * This method has two parameters - early_date and later_date. Check the logic of the bottom to top from method 2 documentation. 
     * Using these two dates (inclusively), we are going to be getting profits all the dates from early_date to the dates in between until
     * later_date and store those profits in the output file by the name of Profits.out. 
     * 
     * Edge cases: 
     * If the dates are not found, that means the indices do not exist, hence -1 would be printed out. 
     * If the later index is equal to early index, that means the user inputted the same date, so get the profit of that date and store it. 
     * If the later index is more than the early index, hence -1 would be printed out.
     * 
     * The edge cases are almost similar to the method 2 edge cases. Check the documentation there to understand bottom to top logic. 
     */
    public double[] ProfitsArray(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1; int later_index = -1;
        for (int i = 0; i < list.size(); i++){if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++){if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new double[]{-1};
        }
        if (later_index > early_index){
            return new double[]{-1};
        }
        if (later_index == early_index){
            return new double[]{list.get(later_index).getHighestPrice() - list.get(later_index).getLowestPrice()};
        }
        int size = early_index - later_index + 1;
        double[] profits_array = new double[size];
        int index = 0;
        for (int i = early_index; i >= later_index; i--){
            profits_array[index++] = list.get(i).getHighestPrice() - list.get(i).getLowestPrice();
        }
        return profits_array;
    }
    /*
     * Method 6: forwarding parallel dates to the profits (unsorted) to an output file
     * This method like the previous method has two parameters - early_date and later_date. 
     * Now that the profits array is made, we can make a String array of dates parallel to the profits. The length will be same as 
     * profit arrays's length. 
     * 
     * Edge cases:
     * If the dates are not found, indices would be -1 by default, so it would store "n/a" and return that. 
     * if the early index and later index are equal, that means same dates, and then just return that single date. 
     * If the later index is more than early index, then it stores "You cannot go past the first date" and return that. Obviously 
     * as we follow the logic given in the documentation of method 2. 
     * 
     * The dates are stored which are parallel to the profits. 
     */
    public String[] DatesArray(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1; int later_index = -1;
        for (int i = 0; i < list.size(); i++){if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++){if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new String[]{"n/a"};
        }
        if (later_index > early_index){
            return new String[]{"You cannot go past the first date"};
        }
        if (later_index == early_index){
            return new String[]{list.get(later_index).getDate()};
        }
        double[] profits = ProfitsArray(list, early_date, later_date);
        String[] dates = new String[profits.length];
        int index = 0;
        for (int i = early_index; i >= later_index; i--){
            dates[index++] = list.get(i).getDate();
        }
        return dates;
    }
    /*
     * Method 7: forwarding parallel volumes to the profits (unsorted) to an output file
     * This method is almost similar to the previous method as we are forwarding parallel volumes to the file instead of dates (done previously)
     * Here, we are going to be returning type int array. The parallel volumes are going to be stored there. As again, the length of the 
     * array will be equal to the length of the original profit array. 
     * 
     * Edge cases:
     * If the dates are not found, indices would be -1 by default, hence store -1 in an array and return it. 
     * If the later index and early index are equal, that means the dates are same, so return that singular volume.
     * If the later index is more than the early index, then we would store -1 in an array and return it.
     * 
     * The volumes are stored to the new type int array which are parallel to the profits. 
     */
    public int[] VolumesArray(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1; int later_index = -1;
        for (int i = 0; i < list.size(); i++){if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++){if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new int[]{-1};
        }
        if (later_index > early_index){
            return new int[]{-1};
        }
        if (later_index == early_index){
            return new int[]{list.get(later_index).getVolume()};
        }
        double[] profits = ProfitsArray(list, early_date, later_date);
        int[] volumes = new int[profits.length];
        int index = 0;
        for (int i = early_index; i >= later_index; i--){
            volumes[index++] = list.get(i).getVolume();
        }
        return volumes;
    }
    
    /*
     * Method 8: Sorting the profits array using QuickSort algorithm.
     * Short description of the algorithm: QuickSort uses partioning where the pivot is the first element, pointer i is in the first element, and pointer j is 
     * in array.length (essentially out of bounds) location. The i pointer keeps moving left until the value of a[i] is bigger than a[pivot]. Thats when it stops.
     * Then, the j pointer keeps moving right until the value of a[j] is smaller than a[pivot]. Thats when j pointer stops. After that, both the values of 
     * a[i] and a[j] are exchanged. We repeat this process until i >= j. This is when a[j] and a[pivot] are exchanged, giving you an array where the pivot
     * is present. The values of the left of pivot are smaller than the a[pivot] and to the right of pivot are bigger than a[pivot]. This happens repeatedly 
     * in the QuickSort process until the array is sorted. 
     * 
     * Now on to the method, we are going to be returning type double. We are going to make an array called sorted profits and that equals list.clone(). The 
     * parameter is the list, which is essentially using the ProfitsArrayMethod in driver by literally returning it to SortedProfitsArray(ProfitsArray) in driver.
     * The next part of this is calling quicksort via quickSort(sortedProfits, 0, sortedProfits.length - 1).
     * The next part now is removing any duplicate profits from the array and then simply store then in a new double[] uniqueSortedprofits array where duplicates
     * are not there and then simply return it. 
     */
    public double[] SortedProfitsArray(double[] list){
        double[] sortedProfits = list.clone();
        quickSort(sortedProfits, 0, sortedProfits.length - 1);
        return sortedProfits;
    }
    /*
     * Method 9: This is similar to DatesArray() method!
     * Here, the logic of the edge cases remains the same as that method.
     * We are going to be returning a type Strings array. First, make a double[] profits array and call ProfitsArray method to it. Then, make a double[] sorted
     * array and call SortedProfitsArray method where the paramter is profits. There you go, you already have an sorted profits array. Using similar logic as 
     * DatesArray() method. We are going to be storing the dates parallel to the sorted profits and then return the Strings[] array. 
     * 
     * Edge cases: 
     * If the early index and later index do not exist, meaning the date you inputted does not exist, store "n/a" in an array and then return it. 
     * If the later index is more than the early index, simply store "You cannot go past the first date" in an array and then return it. 
     * If the later index is equal to the early index, same dates, return the particular date. 
     */
    public String[] ParallelSortedDatesArray(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1;
        int later_index = -1;
        for (int i = 0; i < list.size(); i++) {if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++) {if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new String[]{"n/a"};
        }
        if (later_index > early_index){
            return new String[]{"You cannot go past the first date"};
        }
        if (later_index == early_index){
            return new String[]{list.get(later_index).getDate()};
        }
        double[] profits = ProfitsArray(list, early_date, later_date);
        double[] sorted = SortedProfitsArray(profits);
        String[] parallel_dates = new String[sorted.length];
        boolean[] date_assigned = new boolean[list.size()];

        for (int i = 0; i < sorted.length; i++){
            for (int j = list.size() - 1; j >= 0; j--){
                if (!date_assigned[j] && list.get(j).getHighestPrice() - list.get(j).getLowestPrice() == sorted[i]){
                    parallel_dates[i] = list.get(j).getDate();
                    date_assigned[j] = true;
                    break;
                }
            }
        }
        return parallel_dates;
    }
    /*
     * Method 10: This is similar to the previous method!
     * Here, the logic of the edge cases remains the same as the VolumesArray method. 
     * We are going to be returning a type int array. As we store the volumes in, and in the end just return it.
     * 
     * Edge cases: 
     * If the later index or early index is -1 by default, just make an int[] array store -1 and then return it. 
     * If the later index is more than the early index, just make an int[] array store -1 and then return it. 
     * If the early index is equal to the later index, same dates, so return the particular volume. 
     * 
     */
    public int[] ParallelSortedVolumesArray(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1;
        int later_index = -1;
        for (int i = 0; i < list.size(); i++) {if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++) {if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new int[]{-1};
        }
        if (later_index > early_index){
            return new int[]{-1};
        }
        if (later_index == early_index){
            list.get(later_index).getVolume();
        }
        double[] profits = ProfitsArray(list, early_date, later_date);
        double[] sorted = SortedProfitsArray(profits);
        int[] parallel_volumes = new int[sorted.length];
        boolean[] volume_assigned = new boolean[list.size()];

        for (int i = 0; i < sorted.length; i++){
            for (int j = list.size() - 1; j >= 0; j--){
                if (!volume_assigned[j] && list.get(j).getHighestPrice() - list.get(j).getLowestPrice() == sorted[i]){
                    parallel_volumes[i] = list.get(j).getVolume();
                    volume_assigned[j] = true;
                    break;
                }
            }
        }
        return parallel_volumes;
    }


    //Method 11 : forwarding Adjusted Closing-in Price to PricesOverTime.out
    /*
     * The logic behind the edge cases remains the same. We are essentially forwarding the Closing-in Prices to PricesOverTime.out file
     * If the dates are not found or if the early index is less than later index, simply put -1. 
     * If the indices are equal, same dates, return the singular price. 
     * If the later index is more than the early index, you cannot go to the past, return -1. 
     */
    public double[] PricesOverTimePeriod(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1;
        int later_index = -1;

        for (int i = 0; i < list.size(); i++) {if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++) {if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new double[]{-1};
        }
        if (later_index > early_index){
            return new double[]{-1};
        }
        if (later_index == early_index){
            list.get(later_index).getAdjustedClosingInPrice();
        }
        double[] adjusted_closing_in_prices = new double[early_index - later_index + 1];
        int index = 0;
        for (int i = early_index; i >= later_index; i--){
            adjusted_closing_in_prices[index++] = list.get(i).getAdjustedClosingInPrice();
        }
        return adjusted_closing_in_prices;
    }
    //Method 12 : forwarding volumes to VolumesOverTime.out
    /*
     * The logic behind the edge cases remains the same. We are essentially forwarding the volumes to VolumesOverTime.out file
     * If the dates are not found or if the early index is less than later index, simply put -1. 
     * If the indices are equal, same dates, return the singular volume. 
     * If the later index is more than the early index, you cannot go to the past, return -1. 
     */
    public int[] VolumesOverTimePeriod(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1;
        int later_index = -1;

        for (int i = 0; i < list.size(); i++) {if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++) {if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new int[]{-1};
        }
        if (later_index > early_index){
            return new int[]{-1};
        }
        if (later_index == early_index){
            list.get(later_index).getVolume();
        }
        double[] prices_array = PricesOverTimePeriod(list, early_date, later_date);
        int[] volumes_array = new int[prices_array.length];
        int index = 0;
        for (int i = early_index; i >= later_index; i--){
            volumes_array[index++] = list.get(i).getVolume();
        }
        return volumes_array;
    }
    //Method 13 : forwarding dates to DatesOverTime.out
    /*
     * The logic behind the edge cases remains the same. We are essentially forwarding the dates to DatesOverTime.out file
     * If the dates are not found or if the early index is less than later index, simply put "n/a". 
     * If the indices are equal, same dates, return the singular volume. 
     * If the later index is more than the early index, you cannot go to the past, return "you cannot go past the first date". 
     * 
     */
    public String[] DatesOverTimePeriod(ArrayList<StockData> list, String early_date, String later_date){
        int early_index = -1;
        int later_index = -1;

        for (int i = 0; i < list.size(); i++) {if (list.get(i).getDate().equalsIgnoreCase(early_date)){early_index = i;}}
        for (int j = 0; j < list.size(); j++) {if (list.get(j).getDate().equalsIgnoreCase(later_date)){later_index = j;}}

        if (early_index == -1 || later_index == -1){
            return new String[]{"n/a"};
        }
        if (later_index > early_index){
            return new String[]{"You cannot go past the first date"};
        }
        if (later_index == early_index){
            list.get(later_index).getDate();
        }
        double[] prices_array = PricesOverTimePeriod(list, early_date, later_date);
        String[] dates_array = new String[prices_array.length];
        int index = 0;
        for (int i = early_index; i >= later_index; i--){
            dates_array[index++] = list.get(i).getDate();
        }
        return dates_array;
    }


    /*
     * Partioning and QuickSort algorithm. 
     * Time complexity: O(n logn). 
     */
    private int partition(double[] profits, int low, int high) {
        double pivot = profits[low]; 
        int i = low-1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (profits[i] < pivot);
            
            do {
                j--;
            } while (profits[j] > pivot);
            
            if (i >= j) {
                return j;
            }
            
            // Swap elements at i and j
            double temp = profits[i];
            profits[i] = profits[j];
            profits[j] = temp;
        }
    }
    private void quickSort(double[] profits, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(profits, low, high);
            quickSort(profits, low, pivotIndex);
            quickSort(profits, pivotIndex + 1, high);
        }
    }
}