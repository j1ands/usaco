/*
ID: jordan.9
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st1 = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int numFarmers = Integer.parseInt(st1.nextToken());    // first integer

    int longestMilk = 0;
    int longestWait = 0;

    Hashtable<Integer, Integer> farmTimes = new Hashtable<Integer, Integer>();

    for(int x = 0; x < numFarmers; x++)
    {
      StringTokenizer stx = new StringTokenizer(f.readLine());

      int xStart = Integer.parseInt(stx.nextToken());
      int xEnd = Integer.parseInt(stx.nextToken());

      if(farmTimes.get(xStart) != null)
      {
        if(xEnd > farmTimes.get(xStart))
        {
          farmTimes.put(xStart,xEnd);
        }
      }
      else
      {
        farmTimes.put(xStart,xEnd);
      }
    }

    Enumeration enumTimes = farmTimes.keys();
    List<Integer> startTimes = Collections.list(enumTimes);
    Collections.sort(startTimes);
    
    int firstTime, endTime, currMilkTime;
    int longWaitTime = 0, longMilkTime = 0;

    firstTime = startTimes.get(0);
    endTime = farmTimes.get(firstTime);
    currMilkTime = longMilkTime = endTime - firstTime;
    startTimes.remove(0);

    for(Integer startTime : startTimes)
    {
      if(startTime <= endTime)
      {
        if(farmTimes.get(startTime) > endTime)
        {
          currMilkTime += farmTimes.get(startTime) - endTime;
          endTime = farmTimes.get(startTime);

          if(currMilkTime > longMilkTime)
          {
            longMilkTime = currMilkTime;
          }         
        }
      }

      else
      {

        if(startTime - endTime > longWaitTime)
        {
          longWaitTime = startTime - endTime;
        }

        endTime = farmTimes.get(startTime);                

        currMilkTime = endTime - startTime;

        if(currMilkTime > longMilkTime)
        {
          longMilkTime = currMilkTime;
        }

      }
    }

    out.println(longMilkTime + " " + longWaitTime);

    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}