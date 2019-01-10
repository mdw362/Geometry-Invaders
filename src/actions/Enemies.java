package actions;

import geometryInvadersMain.Enemy;
import geometryInvadersMain.AlternateEnemy;
import geometryInvadersMain.BasicEnemy;
import geometryInvadersMain.Projectile;

// Enemies is a utility class that contains the methods for rendering all of the Enemy objects in a grid-like fashion
// It is final so that it cannot be extended
public final class Enemies {
	
	// The constructor is private so that it cannot be instantiated
	private Enemies (){}
	
	// initEnemies method
	// Enemies are initialized
	public static void initEnemies (float xMovement,  Enemy enemies []){
		
		float enemyRandomizer;
		float enemyLeftX = -0.75f;
		float enemyRightX = -0.7f;
		float enemyTopY = 0.8f;
		float enemyBottomY = 0.7f;		
		
		// initializes enemies in array
		for (int i = 0; i < enemies.length; i++){
			
			// Random float to determine what type of enemy will be initialized
			enemyRandomizer = (float)(Math.random() * 1);

			if (enemyRandomizer >= 0 && enemyRandomizer <= 0.7f){
				enemies[i] = new AlternateEnemy (enemyLeftX, enemyRightX, enemyTopY, enemyBottomY, xMovement);
			}
			
			else{
				enemies[i] = new BasicEnemy (enemyLeftX, enemyRightX, enemyTopY, enemyBottomY, xMovement);
			}
			
			// Moves next corresponding enemy to the right by 0.2
			enemyLeftX += 0.2f;
			enemyRightX += 0.2f;
				
			// Creates 5 enemies per row
			// Once a new row is created, their x positions get reset to the left and their y position decreases by 0.2
			if (i == 7 || 
				i == 15 || 
				i == 23 ||
				i == 31 ||
				i == 39 ||
				i == 47 ||
				i == 54){
					
				enemyLeftX = -0.75f;
				enemyRightX = -0.7f;
				enemyTopY -= 0.2f;
				enemyBottomY -= 0.2f;
			}
		}
	}
	
	// moveEnemies method
	public static void moveEnemies (Projectile [] mainCharacterProjectileAmmo, Enemy[] enemies, float mainCharacterXMovement, int projectiles){
		
		for (int i = 0; i < enemies.length; i++){
			
			if (i == 0 || 
				i == enemies.length ||
				i % 7 == 0){
				
				enemies[i].moveX ();
			}
			
			if (enemies[i].getIsAlive ()){
				
				// Draws enemy if it is alive
				enemies [i].render();
			}
			
			else {
				
				enemies[i].deadEnemy();
				
				Collisions.deadEnemyCollision(enemies[i], mainCharacterXMovement);
				// increases the enemy's x value and moves it right if the character is right
				if (mainCharacterXMovement >= (enemies[i].getEnemyRightXPos () + enemies[i].getExtraEnemyXMovement())
						&& (enemies[i].getEnemyRightXPos() + enemies[i].getExtraEnemyXMovement()) <= 0.82f)
				{
					enemies[i].setExtraEnemyXMovement(enemies[i].getExtraEnemyXMovement() + 0.0035f);
				}
				
				// decreases the enemy's x value and moves the enemy left if the character is left
				if (mainCharacterXMovement < (enemies[i].getEnemyLeftXPos () + enemies[i].getExtraEnemyXMovement()) &&
						(enemies[i].getEnemyLeftXPos () + enemies[i].getExtraEnemyXMovement())>= -0.82f){
				
					enemies[i].setExtraEnemyXMovement(enemies[i].getExtraEnemyXMovement() - 0.0035f);
				}
				
			}
			enemies[i].enemyFireProjectiles(mainCharacterXMovement);
		}
	}
	
	// setEnemiesShouldLaunch method
	// Sets the chances that the enemy will fire a projectile
	public static void setEnemiesShouldLaunch (int shouldLaunch, Enemy [] enemies){
		
		for (int i = 0; i < enemies.length; i++){
			
			enemies[i].setShouldLaunch(shouldLaunch);
		}
	}
	// areEnemiesAlive method
	public static boolean areEnemiesAlive (Enemy [] enemies){
		
		int deadEnemies = 0;
		for (int i = 0; i < enemies.length; i++){
			
			// if the select enemy is NOT alive, deadEnemies increases
			if (!enemies[i].getIsAlive()){
				
				deadEnemies++;
			}
		}
		System.out.println(deadEnemies + " enemies are dead");
		return !(deadEnemies == enemies.length);
	}

}
