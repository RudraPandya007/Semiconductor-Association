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

## Output files overview
Each option from method 5 to method 7 would create 3 output files corresponding to what is being evaluated given in the menu option.
## Method 5 output files (NVIDIA on April 2024)
- These are the profits printed out assuming early date parameter is 2024-04-01 and later date parameter is 2024-04-30. 
```plaintext
Profits
30.21002199999998
24.73999020000008
19.739990199999966
47.540039099999944
25.54998779999994
20.97998050000001
46.13000490000002
36.9099731
38.13000479999994
26.450012199999946
46.8400269
20.539978099999985
48.25
37.88000490000002
87.17999259999999
36.72998050000001
25.049987800000054
48.98999020000008
51.0
49.44000249999999
27.260009800000034
25.190002400000026
```
- These are the dates at which the profits took place in i.e parallel to the profits.
```plaintext
Dates
2024-04-01
2024-04-02
2024-04-03
2024-04-04
2024-04-05
2024-04-08
2024-04-09
2024-04-10
2024-04-11
2024-04-12
2024-04-15
2024-04-16
2024-04-17
2024-04-18
2024-04-19
2024-04-22
2024-04-23
2024-04-24
2024-04-25
2024-04-26
2024-04-29
2024-04-30
```
- These are the volumes at which the profits took place in i.e volumes of the parallel dates and profits.
```plaintext
Volumes
45244100
43306400
37006700
43496500
39885700
28322000
50354700
43192900
43163700
42488900
44307700
37045300
49540000
44726000
87190500
59634100
43855900
51220800
42464100
55101100
38897100
36370900
```
## Method 6 output files (NVIDIA on April 2024)
- The profits are then sorted here using QuickSort algorithm and printed out assuming early date parameter is 2024-04-01 and later date parameter is 2024-04-30.
```plaintext
Sorted Profits
19.739990199999966
20.539978099999985
20.97998050000001
24.73999020000008
25.049987800000054
25.190002400000026
25.54998779999994
26.450012199999946
27.260009800000034
30.21002199999998
36.72998050000001
36.9099731
37.88000490000002
38.13000479999994
46.13000490000002
46.8400269
47.540039099999944
48.25
48.98999020000008
49.44000249999999
51.0
87.17999259999999
```
- These are the dates at which the profit took place i.e parallel to sorted profits.
```plaintext
Dates of sorted profits
2024-04-03
2024-04-16
2024-04-08
2024-04-02
2024-04-23
2024-04-30
2024-04-05
2023-11-22
2024-04-29
2024-04-01
2024-04-22
2024-04-10
2024-04-18
2024-04-11
2024-04-09
2024-04-15
2024-04-04
2024-04-17
2024-04-24
2024-04-26
2024-04-25
2024-04-19
```
- These are the volumes at which the profit took place i.e parallel to sorted profits.
```plaintext
Volumes
45244100
43306400
37006700
43496500
39885700
28322000
50354700
43192900
43163700
42488900
44307700
37045300
49540000
44726000
87190500
59634100
43855900
51220800
42464100
55101100
38897100
36370900
```

## Method 7 output files (NVIDIA on April 24)
- These are the adjusted closing prices printed out assuming the early date parameter is 2024-04-01 and later date parameter is 2024-04-30.
```plaintext
Prices over time
903.6300049
894.5200195
889.6400146
859.0499878
880.0800171
871.3300171
853.539978
870.3900146
906.1599731
881.8599854
860.0100098
874.1500244
840.3499756
846.710022
762.0
795.1799927
824.2299805
796.7700195
826.3200073
877.3499756
877.5700073
864.0200195
```
- These are the dates corresponding to the occurence of that price.
```plaintext
Dates over time
2024-04-01
2024-04-02
2024-04-03
2024-04-04
2024-04-05
2024-04-08
2024-04-09
2024-04-10
2024-04-11
2024-04-12
2024-04-15
2024-04-16
2024-04-17
2024-04-18
2024-04-19
2024-04-22
2024-04-23
2024-04-24
2024-04-25
2024-04-26
2024-04-29
2024-04-30
```
- These are the volumes corresponding to the occurence of that price.
```plaintext
Volumes Over Time
45244100
43306400
37006700
43496500
39885700
28322000
50354700
43192900
43163700
42488900
44307700
37045300
49540000
44726000
87190500
59634100
43855900
51220800
42464100
55101100
38897100
36370900
```
