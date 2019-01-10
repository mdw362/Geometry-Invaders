package actions;

import geometryInvadersMain.AlternateEnemy;
import geometryInvadersMain.BasicEnemy;
import geometryInvadersMain.Enemy;
import geometryInvadersMain.Game;
import geometryInvadersMain.Projectile;

// Collisions is a utility class. It is final so that it cannot be extended. This includes all of the collision methods
public final class Collisions {

	// Uses a private constructor so that it cannot be instantiated
	private Collisions (){
		
	}
	// enemyProjectileCollision method
	// Checks to see if enemy's projectile has collided with the main character
	// If so, main character disappears
	// When this is implemented into interface, be sure to add a MainCharacter parameter
	public static void enemyProjectileCollision (Projectile enemyProjectile, Enemy enemy,  float mainCharacterXMovement){
		
		// Compares projectile to MainCharacter's top triangle
		if ((enemyProjectile.getYPos () <= -0.6f && 
				enemyProjectile.getYPos () >= -0.73f) &&
				(((enemyProjectile.getXPos() >= -0.0075f + mainCharacterXMovement) &&
				enemyProjectile.getXPos() <= (0.0075f + mainCharacterXMovement)))){
				
					Game.isAlive = false;
					System.out.println("Main character hit!");
			}
			
		// Compares projectile to MainCharacter's middle quad
			if ((enemyProjectile.getYPos () <= -0.68f &&
				enemyProjectile.getYPos () >= -0.87f) &&
				(((enemyProjectile.getXPos () >= -0.063f + mainCharacterXMovement) &&
				(enemyProjectile.getXPos () <= 0.063f + mainCharacterXMovement)))){
				
					Game.isAlive = false;
					System.out.println("Main character hit!");
					
				}
		}
		// mainCharacterProjectileCollision method
		// Checks to see if main character's projectile hit the enemy
		// If so, enemy and projectile disappear
		public static boolean mainCharacterProjectileCollision (Projectile mainCharacterProjectile, Enemy enemy){
			
			// returns true if a collision is made
			// The y coordinates are supposed to be for the enemy quad portion
			// since the mainCharacterProjectile must hit the quad instead of the triangles,
			// the game is made tougher
			if ((mainCharacterProjectile.getYPos () >= enemy.getEnemyTopYPos() -0.02f &&
				mainCharacterProjectile.getYPos () <= enemy.getEnemyTopYPos() + 0.03f) &&
				(mainCharacterProjectile.getXPos () >= enemy.getEnemyLeftXPos() &&
				mainCharacterProjectile.getXPos () <= enemy.getEnemyRightXPos())){
				
				System.out.println("Enemy hit!");
				if (enemy.getIsAlive()){
					Game.score++;
				}
				enemy.setIsAlive(false);
				mainCharacterProjectile.setIsAlive(false);
				
				if (enemy instanceof BasicEnemy){
					enemy.setEnemyYTopPos(-2);
				}
				else if (enemy instanceof AlternateEnemy){
					enemy.setEnemyTopYQuadPos (-2);
				}
				
				return true;
				
				}
			
			else{
				
				return false;
			}
		}
		
		public static void deadEnemyCollision (Enemy enemy, float mainCharacterXMovement){
			if ((enemy.getDeadEnemyTopYPos()  <= -0.57f && 
					enemy.getDeadEnemyTopYPos () >= -0.73f) &&
					(((enemy.getDeadEnemyRightXPos() >= -0.0078f + mainCharacterXMovement) &&
						enemy.getDeadEnemyLeftXPos()  <= (0.0078f + mainCharacterXMovement)))){
		
				Game.isAlive = false;
				System.out.println("Main character hit!");
			}
	
			if ((enemy.getDeadEnemyTopYPos () <= -0.68f &&
					enemy.getDeadEnemyTopYPos() >= -0.87f) &&
					(((enemy.getDeadEnemyRightXPos ()  >= -0.065f + mainCharacterXMovement) &&
						(enemy.getDeadEnemyLeftXPos ()  <= 0.065f + mainCharacterXMovement)))){
		
				Game.isAlive = false;
				System.out.println("Main character hit!");
			
		}
	}
}
