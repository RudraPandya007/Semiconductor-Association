class StockData{

    //private variables with respect to the .csv dataset information
    public String date;            
    public int volume;
    public double opening_price;
    public double closing_price;
    public double highest_price;
    public double lowest_price;
    public double adjusted_closing_price;

    //constructor method for the respective information for each line in the .csv file. 
    public StockData(String date, int volume, double opening_price, double closing_price, double highest_price, double lowest_price, double adjusted_closing_price){
        this.date = date;
        this.volume = volume;
        this.opening_price = opening_price;
        this.closing_price = closing_price;
        this.highest_price = highest_price;
        this.lowest_price = lowest_price;
        this.adjusted_closing_price = adjusted_closing_price;
    }

    //getter methods to retrieve infomation

    //retrieve date
    public String getDate(){
        return this.date;
    }

    //retrive volume
    public int getVolume(){
        return this.volume;
    }

    //retrieve opening price
    public double getOpeningPrice(){
        return this.opening_price;
    }
    //retrieve closing in price
    public double getClosingInPrice(){
        return this.closing_price;
    }
    //retrueve highest price
    public double getHighestPrice(){
        return this.highest_price;
    }

    //retrieve lowest price
    public double getLowestPrice(){
        return this.lowest_price;
    }

    //retrieve adjusted closing in price
    public double getAdjustedClosingInPrice(){
        return this.adjusted_closing_price;
    }
}