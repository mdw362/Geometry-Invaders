package tests;

import static org.junit.Assert.*;
//import actions.Enemies;

import org.junit.Test;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

//import geometryInvadersMain.*;
public class ScoreTest {

	@Test
	public void test(){
		
		try {

			// writer writes and appends input into a file
			
			File file = new File ("src/scoretest.txt");
			Scanner fileInput = new Scanner (file);
			

			String line = fileInput.nextLine();
			int score = Integer.parseInt(line);
			System.out.println(line);
			
			// Checks that the initial value in the txt file is 3
			assertEquals (3, score);
			
			FileWriter printLine = new FileWriter (file);

			// Writes 5 to the file as a string and then clears the stream
			printLine.write (5 + "\n");
			printLine.flush();
			printLine.close();
			//--------------------------------------------------------
			Scanner fileInputTwo = new Scanner (file);
			String lineTwo = fileInputTwo.nextLine();
			int scoreTwo = Integer.parseInt(lineTwo);
			
			assertEquals (5, scoreTwo);
			System.out.println(lineTwo);
			// Writes 5 to the txt doc
	
			FileWriter printAnotherLine = new FileWriter (file);

			printAnotherLine.write (3 + "\n");
			printAnotherLine.flush();
			printAnotherLine.close();
			
			Scanner fileInputThree = new Scanner (file);
			String lineThree = fileInputThree.nextLine();
			int scoreThree = Integer.parseInt(lineThree);
			
			assertEquals (3, scoreThree);
			System.out.println(lineThree);
			} catch (Exception e) {
			System.out.println(e.getMessage() + " " + e.toString());
			e.printStackTrace();
		}
		
	}

}
	
