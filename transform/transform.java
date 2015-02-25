/*
ID: jordan.9
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

class transform {

	static void readSquares(BufferedReader file, String[][] square, int size) throws IOException {
		for(int x = 0; x < size; x++) {
			String [] currentLine = (new StringTokenizer(file.readLine())).nextToken().split("");
			for(int y = 0; y < size; y++) {
				square[x][y] = currentLine[y];
			}
		}
	}

	static String[][] ninety(String[][] square) {
		String[][] newSquare = new String[square[0].length][square[0].length];

		for(int x = 0; x < newSquare[0].length; x++) {
			for(int y = 0; y < newSquare[0].length; y++) {
				newSquare[x][y] = square[square[0].length - y - 1][x];
			}
		}
		return newSquare;
	}

	static String[][] oneEighty(String[][] square) {
		String[][] newSquare = new String[square[0].length][square[0].length];

		for(int x = 0; x < newSquare[0].length; x++) {
			for(int y = 0; y < newSquare[0].length; y++) {
				newSquare[x][y] = square[square[0].length - x - 1][square[0].length - y -1]; 
			}
		}
		return newSquare;
	}

	static String[][] twoSeventy(String[][] square) {
		String[][] newSquare = new String[square[0].length][square[0].length];

		for(int x = 0; x < newSquare[0].length; x++) {
			for(int y = 0; y < newSquare[0].length; y++) {
				newSquare[x][y] = square[y][square[0].length - x - 1];
			}
		}
		return newSquare;
	}
	
	static String[][] reflection(String[][] square) {
		String[][] newSquare = new String[square[0].length][square[0].length];

		for(int x = 0; x < newSquare[0].length; x++) {
			for(int y = 0; y < newSquare[0].length; y++) {
				newSquare[x][y] = square[x][square[0].length - y - 1]; 
			}
		}
		return newSquare;
	}
	
	static int gauntlet(String[][] oSquare, String[][] newSquare) {
		if(Arrays.deepEquals(ninety(oSquare), newSquare) == true) {
			return 1;
		} else if(Arrays.deepEquals(oneEighty(oSquare), newSquare) == true) {
			return 2;
		} else if(Arrays.deepEquals(twoSeventy(oSquare), newSquare) == true) {
			return 3;
		} else if(Arrays.deepEquals(reflection(oSquare), newSquare) == true) {
			return 4;
		} else {
			return 0;
		}
	}

	static int transformation(String[][] oSquare, String[][] newSquare, PrintWriter o) {

		if(Arrays.deepEquals(oSquare, newSquare) == true) {
			return 6;
		} else {
			int initialGauntletResult = gauntlet(oSquare, newSquare);
			if(initialGauntletResult != 0) {
				System.out.println("HEYY");
				return initialGauntletResult;
			} else {
//				for(int x = 0; x < oSquare[0].length; x++) {
//					for(int y = 0; y < oSquare[0].length; y++) {
//						o.print(oSquare[x][y]);
//					}
//					o.println();
//				}
				oSquare = reflection(oSquare);
				int secondGauntletResult = gauntlet(oSquare, newSquare);
				if(secondGauntletResult != 0) {
					return 5;
				} else {
					return 7;
				}
			}
		}
	}


  	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
							  // input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st1 = new StringTokenizer(f.readLine());
							  // Get line, break into tokens
	 
		int squareSize = Integer.parseInt(st1.nextToken());

		String[][] originalSquare = new String[squareSize][squareSize];
		String[][] transformedSquare = new String[squareSize][squareSize];
		
		readSquares(f,originalSquare,squareSize);
		readSquares(f,transformedSquare,squareSize);

		out.println(transformation(originalSquare, transformedSquare, out));	

		out.close();
		System.exit(0);
  	}
}
