package geometryInvadersMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ScoreWriter {
	
	public ScoreWriter (){
		
	}
	
	public int getScore (){
		
		File file = new File ("../score.txt");
		Scanner fileInput;
		try {
			fileInput = new Scanner (file);
			String line = fileInput.nextLine();
			int score = Integer.parseInt(line);
			fileInput.close();
			return score;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void overwriteScore (int score){
		
		File file = new File ("../score.txt");
		try {
			FileWriter print = new FileWriter (file);
			print.write(score + "\n");
			print.flush();
			print.close();
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage() + " " + e.toString());
			e.printStackTrace();
		}
	}

}
