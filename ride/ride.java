/*
ID: jordan.9
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer lineOne = new StringTokenizer(f.readLine());
    StringTokenizer lineTwo = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    String comet  = lineOne.nextToken();    // first integer
    String group = lineTwo.nextToken();    // second integer
    //out.println(comet + " hey");
    //out.println(group);                           // output result
    
    int cometSum = 1;
    int groupSum = 1;

    for(int x = 0; x < comet.length(); x++)
    {
      cometSum *= comet.charAt(x) - 64;
    }

    for(int y = 0; y < group.length(); y++)
    {
      groupSum *= group.charAt(y) - 64;
    }

    //out.println(cometSum);
    //out.println(groupSum);

    if(cometSum % 47 == groupSum % 47)
    {
        out.println("GO");
    }
    else
    {
        out.println("STAY");
    }

    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}