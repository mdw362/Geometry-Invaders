package animations;

import java.util.ArrayList;

public class Stars {
	
	// Creates an array of stars
	public static Star [] arrayStars = new Star [500];
	public static ArrayList <Star> stars = new ArrayList <Star> ();
	private Stars (){
		
	}
	
	// initStars method
	public static void initStars (){
		
		for (int i = 0; i < arrayStars.length; i++){
			
			if (i == 0 || i == 1){
				
				arrayStars [i] = new ShootingStar ((float)(Math.random() * 2) - 1, (float)(Math.random() * 2) - 1);
				arrayStars [i].setXPos(-2);
				arrayStars [i].setYPos(-2);
				
			}
			else{
				arrayStars [i] =  new Star ((float)(Math.random() * 2) - 1, (float)(Math.random() * 2) - 1);
				arrayStars [i].render();
			}
		}
			for (int i = 0; i < arrayStars.length; i++){
			
			stars.add(arrayStars [i]);
		}
			
		System.out.println("Stars size: " + stars.size());
	}
	
	// addNewRow method
	// Resets the mountains' y positions to the bottom of the screen once they leave the top of the
	// picture
	public static void addNewRow (){
		
		int randomShootingStar = (int)(Math.random() * 400);
		if (randomShootingStar == 0){
			
			stars.get(0).setYPos((float)(Math.random() * 1) + 1);
			stars.get(0).setXPos((float)(Math.random() * 1));
		}
		else if (randomShootingStar == 1){
			
			stars.get(1).setYPos((float)(Math.random() * 1) + 1);
			stars.get(1).setXPos((float)(Math.random() * 1) - 1);
		}
		
		for (int i = 2; i < stars.size(); i++){
			
			// Checks if the designated star has left the screen
//			if (stars.get(i).getYPos() >= 1.1){
			if (stars.get(i).getYPos() <= -1.1){
				
				// Moves the star to the bottom of the screen
//				stars.get(i).setYPos(-1);
				stars.get(i).setYPos(1);

				
				// Changes the star's x position to a random star for spontaneity
				stars.get(i).setXPos((float)(Math.random() * 2) - 1);
			}
		}
	}
	
	// updateStars method
	// Increases the mountains' y position by mountainIncrememnt 
	public static void updateStars (float starIncrement){
		
		
		stars.get(0).setXPos (stars.get(0).getXPos() - 0.02f);
		stars.get(0).setYPos(stars.get(0).getYPos() - 0.02f);
		stars.get(0).render(1f);
		
		stars.get(1).setXPos (stars.get(1).getXPos() + 0.02f);
		stars.get(1).setYPos(stars.get(1).getYPos() - 0.02f);
		stars.get(1).render(-1f);
		
		for (int i = 2; i < stars.size(); i++){
		
//			stars.get(i).setYPos(stars.get(i).getYPos() + starIncrement);
			stars.get(i).setYPos(stars.get(i).getYPos() - starIncrement);

			stars.get(i).render();
		}
		
	}
	
	// getMountainSize method
	public static int getStarsSize (){
		
		return stars.size();
	}
}
