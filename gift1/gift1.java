/*
ID: jordan.9
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class Giver
{
  private String name;
  private int initalMoney, receivedMoney = 0;

  //public Giver()
  //{
    //name = new String(n);
  //}
  public Giver()
  {
    
  }

  public void setInitialMoney(int money)
  {
    initalMoney = money;
  }

  public void receivedMoney(int money)
  {
    receivedMoney += money;
  }

  public String getName()
  {
    return name;
  }

  public int endMoney()
  {
    return receivedMoney - initalMoney;
  }
}

class gift1 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st1 = new StringTokenizer(f.readLine());
    //StringTokenizer st2 = new StringTokenizer(f.readLine());

						  // Get line, break into tokens
    

    int numPeople = Integer.parseInt(st1.nextToken());    // first integer
    
    //String[] people = new String[numPeople];
    //int[] initialMoney = new int[numPeople];
    //Giver[] people = new Giver[numPeople];
    Hashtable people = new Hashtable();

    StringTokenizer[] nameLines = new StringTokenizer[numPeople];

    for(int x = 0; x < numPeople; x++)
    {
      nameLines[x] = new StringTokenizer(f.readLine());
      //people[x] = st.nextToken();
      //people[x] = new Giver(nameLines[x].nextToken());
      //out.println(people[x].getName());
      people.put(nameLines[x].nextToken(), new Giver());
    }

    StringTokenizer[] giver = new StringTokenizer[numPeople];
    StringTokenizer[] amountAndTo = new StringTokenizer[numPeople];

    for(int x = 0; x < numPeople; x++)
    {

    }
    //int i2 = Integer.parseInt(st.nextToken());    // second integer
    //out.println(i1+i2);                           // output result
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}