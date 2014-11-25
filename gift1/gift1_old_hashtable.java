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
  public Giver() {}

  public void setInitialMoney(int money)
  {
    initalMoney = money;
  }

  public int getInitialMoney()
  {
    return initalMoney;
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
    Hashtable<String, Giver> people = new Hashtable<String, Giver>();

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
    String currGiver;
    //String currReceip;
    int giveTo;
    Giver tempGiver;
    Giver tempReceip;
    String receipName;

    for(int x = 0; x < numPeople; x++)
    {
      //out.println(numPeople);
      giver[x] = new StringTokenizer(f.readLine());
      currGiver = new String(giver[x].nextToken());
      amountAndTo[x] = new StringTokenizer(f.readLine());
      tempGiver = people.get(currGiver);
      tempGiver.setInitialMoney(Integer.parseInt(amountAndTo[x].nextToken()));
      //people.get(currGiver).setInitialMoney(Integer.parseInt(amountAndTo[x].nextToken()));
      giveTo = Integer.parseInt(amountAndTo[x].nextToken());
      StringTokenizer[] receivers = new StringTokenizer[giveTo];
        for(int y = 0; y < giveTo; y++)
        {
          receivers[y] = new StringTokenizer(f.readLine());
          receipName = new String(receivers[y].nextToken());
          //currReceip
          tempReceip = people.get(receipName);

          if(tempGiver.getInitialMoney() > 0)
          {
            tempReceip.receivedMoney(tempGiver.getInitialMoney() / giveTo);
            people.put(receipName, tempReceip);
          }
          //people.get(receivers[y]).receivedMoney(people.get(currGiver).getInitialMoney() / giveTo);
        }
        
        if(tempGiver.getInitialMoney() > 0)
        {
          tempGiver.receivedMoney(tempGiver.getInitialMoney() - (giveTo * (tempGiver.getInitialMoney() / giveTo)));
          people.put(currGiver, tempGiver);
        }
      //people.get(currGiver).receivedMoney(people.get(currGiver).initalMoney() - (giveTo * (people.get(currGiver).initalMoney() / giveTo)));
    }
    
    Enumeration names = people.keys();
    String currName;

    while(names.hasMoreElements())
    {
      currName = (String) names.nextElement();
      tempGiver = people.get(currName);
      out.println(currName + " " + tempGiver.endMoney());
    }
    //int i2 = Integer.parseInt(st.nextToken());    // second integer
    //out.println(i1+i2);                           // output result
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}