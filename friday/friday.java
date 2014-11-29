/*
ID: jordan.9
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int years = Integer.parseInt(st.nextToken()) + 1900;    // first integer
    int monthsLength = 0;

    int[] thirteenCount = new int[7];
    boolean leapYear = false;
    int dayCreep = 0;
  
    for(int x = 1900; x < years; x++)
    {
      if(x % 400 == 0)
      {
        leapYear = true;
      }
      else if(x % 4 == 0)
      {
        if(x % 100 != 0)
        {
          leapYear = true;
        }
      }
      else
      {
        leapYear = false;
      }
      for(int y = 1; y <= 12; y++)
      {
        //switch case
        if(y == 9 || y == 4 || y == 6 || y == 11)
        {
          monthsLength = 30;
        }
        else if(y == 2)
        {
          if(leapYear)
          {
            monthsLength = 29;
          }
          else
          {
            monthsLength = 28;
          }
        }
        else
        {
          monthsLength = 31;
        }
        //out.println("year: " + (1899+x) + ", month: " + y + " and days in month: " + monthsLength);
        for(int z = 1; z <= monthsLength; z++)
        {
          dayCreep++;
          if(z == 13)
          {
            //int day = dayCreep % 7;
            thirteenCount[(dayCreep%7)]++;
            //out.println("Day " + day + " is " + thirteenCount[day]);
          }
        }
      }
    }

    //saturday = 4 remainder
    //sunday = 0 remainder
    //monday = 3 remainder
    //tuesday = 6 remainder
    //wednesday = 2 remainder
    //thursday = 5 remainder
    //friday = 1 remainder
    //36 33 34 33 35 35 34

    out.print(thirteenCount[6] + " "); //fri
    out.print(thirteenCount[0] + " "); //wed
    out.print(thirteenCount[1] + " "); //mon
    out.print(thirteenCount[2] + " "); //sun
    out.print(thirteenCount[3] + " "); //thur
    out.print(thirteenCount[4] + " "); //sat
    out.println(thirteenCount[5]); //tues 


    //out.println(years);                           // output result
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}