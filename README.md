## Semiconductor Industry Analysis Project
Hello! My name is Rudra Pandya and I am the creator of the Semiconductor Industry Analysis Project. This project focuses on various companies which are designated in the Semiconductor Industry such as Nvidia, AMD, Intel, and many more. The representation of these companies are stored as a Ticker (Nvidia = NVDA) and each ticker has its own .csv file which has data about the stock of the company. Data would include date, volume, opening price, closing price, highest price, lowest price, and adjusted closing price. There are thousands of lines of data corresponding to each .csv file from 1990s to 2019 at most; However, due to the strict uprise of Nvidia in 2024, I have added more lines of data from 2018 to 2024 to monitor its lucrative performance. 

Now what are the applications of this?
Great question! The data which can be presented by you in any condition are given by different methods shown below. In particular, menu numbers such as 5, 6, 7 use various methods with their parallel methods to display components such as profits with their respective volumes and dates to output files. Another example is shown in method 6, which uses the quicksort algorithm to sort the profits and finds its parallel volumes and dates presented in output files. This data can be pasted into Google Spreadsheet or Microsoft Excel or in BI Dashboards for data visualization. In reality, this is a mid-level project which has similar levels of complexity as other coding assignments given in your university.

## Ticker Files

The following ticker files are available for analysis:

- AMAT
- AMD
- ASML
- ASX
- AVGO
- INTC
- MU
- NVDA
- QCOM
- TSM

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- The `stdlib` library from Princeton's website or clone this repository and use it (it includes StdIn.java and StdOut.java)

### Installation

1. **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/semiconductor-analysis.git
    cd semiconductor-analysis
    ```

2. **Download and Include `stdlib` Library**
    Download the `stdlib` library from [Princeton's website](https://introcs.cs.princeton.edu/java/stdlib/). Place it in your project directory.

3. **Compile the Code**
    ```bash
    javac -cp .:stdlib.jar Driver.java IndustryAnalysis.java
    ```

4. **Run the Application**
    ```bash
    java -cp .:stdlib.jar Driver
    ```

## Usage

1. **Start the Application**: Run the `Driver` class to start the application.
2. **Select a Ticker**: Enter the ticker of your choice (e.g., `AMAT`, `AMD`) when prompted.
3. **Choose an Option**: Select from the menu options to perform various analyses.

### Menu Options

1. **Specific Date Information**: Enter a date in `YYYY-MM-DD` format to retrieve specific information for that date.
2. **Volume Analysis**: Enter two dates to analyze trading volumes between those dates.
3. **Percent Change**: Enter a date to calculate the percent change in prices compared to the opening price.
4. **Max and Min Profits**: Display the dates with maximum and minimum profits.
5. **Forward profits with their dates and volumes to a file**: Enter two dates to save profits with their dates and volumes between those dates to a file.
6. **Forward sorted profits with their dates and volumes to a file**: Enter two dates to save sorted profits with their dates and volumes to a file.
7. **Forward prices with their dates and volumes to a file**: Enter two dates to save prices with their dates and volumes to a file.
8. **Exit**: Exit the application.

### Example

```plaintext
Welcome to Semiconductor Industry Analysis Project!

Here are the ticker files: AMAT, AMD, ASML, ASX, AVGO, INTC, MU, NVDA, QCOM, and TSM
Enter the ticker of your choice: Nvda

Please choose an option:
1. Specific Date Information
2. Volume Analysis of a specific period
3. Percent Change
4. Max and Min Profits
5. Forward profits with their dates and volumes to a file
6. Forward sorted profits with their dates and volumes to a file
7. Forward prices with their dates and volumes to a file
8. Exit
```
