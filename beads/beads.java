/*
ID: jordan.9
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {

  public static int largestCollection(int start, int length, String beads)
  {
    char fType;
    int total = 0;
    char bType;

    fType = beads.charAt(start);
    total += largestCollection(start, length, beads, fType, true, 0);

    if(start - 1 < 0)
    {
      bType = beads.charAt(start+length-1);
      total += largestCollection((start+length-1), length, beads, bType, false, 0);
    }
    else
    {
      bType = beads.charAt(start-1);
      total += largestCollection((start-1), length, beads, bType, false, 0);
    }

    return total;

  }

  public static int largestCollection(int start, int length, String beads, char type, boolean isForward, int counter)
  {
    int currIndex = 0;
    char newType;

    System.out.println("start = " + start);
    System.out.println("counter = " + counter);

    if(counter == length - 1)
    {
      return 0;
    }

    if(isForward)
    {

      currIndex = start++;

      if(currIndex >= length)
      {
        currIndex -= length;
      }

      newType = beads.charAt(currIndex);

      if(newType == 'w' || type == 'w' || newType == type)
      {
        if(type == 'w' && newType != 'w')
        {
          type = newType;
        }
        return largestCollection(start, length, beads, type, true, ++counter) + 1;
      }

      else
      {
        return 0;
      }
    }

    else
    {

      currIndex = start--;

      if(currIndex < 0)
      {
        currIndex += length;
      }

      newType = beads.charAt(currIndex);

      if(newType == 'w' || type == 'w' || newType == type)
      {
        if(type == 'w' && newType != 'w')
        {
          type = newType;
        }
        return largestCollection(start, length, beads, type, false, ++counter) + 1;
      }

      else
      {
        return 0;
      }
    }
  }

  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer num = new StringTokenizer(f.readLine());
    StringTokenizer st = new StringTokenizer(f.readLine());

						  // Get line, break into tokens
    int num_of_beads = Integer.parseInt(num.nextToken());    // first integer
    String beads = new String(st.nextToken());
    int temp;
    int largest = -1;

    for(int x = 0; x < num_of_beads; x++)
    {
      temp = largestCollection(x, num_of_beads, beads);
      if(temp > largest)
      {
        largest = temp;
      }
    }

    if(largest > num_of_beads)
    {
      out.println(num_of_beads);
    }
    else
    {
      out.println(largest);
    }
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}