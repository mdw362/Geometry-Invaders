package actions;

import geometryInvadersMain.Enemy;
import geometryInvadersMain.EnemyProjectile;
import geometryInvadersMain.Game;
import geometryInvadersMain.Labels;
import geometryInvadersMain.MainCharacter;
import geometryInvadersMain.MainCharacterProjectile;
import geometryInvadersMain.Projectile;

// Fire contains all of the methods necessary for firing projectiles. Projectiles are initialized and re-rendered
// Fire is a utility class and cannot be extended
public final class Fire {
	
	private static Labels labels = new Labels ();
	public static int ammoProjectiles = 8;
	// Constructor is private so that it cannot be instantiated
	private Fire (){
		
	}
	
	// fireProjectile method
	public static void fireProjectile (EnemyProjectile [] enemyProjectileAmmo, Enemy enemy, float mainCharacterXMovement) 
			throws NullPointerException{
		
		enemy.setShouldLaunch((int)(Math.random () * 800));

		if (enemy.getShouldLaunch() == 2){
			
			enemy.setProjectiles (enemy.getProjectiles() + 1);
		}
		
		// Re-renders existing projectiles
		for (int i = 0 ; i < enemy.getProjectiles (); i++){
	
			if (enemyProjectileAmmo[i] != null){
	
				enemyProjectileAmmo [i].decreaseLaunch ();					
				enemyProjectileAmmo [i].render ();
				Collisions.enemyProjectileCollision (enemyProjectileAmmo [i], enemy, mainCharacterXMovement);
			}
			
			// Creates a new projectile if shouldLaunch equals 2
			else{
		
				if (enemy.getIsAlive()){
					enemyProjectileAmmo [i] = new EnemyProjectile (((enemy.getEnemyLeftXPos() + enemy.getEnemyXMovementPace()) + (enemy.getEnemyRightXPos() + enemy.getEnemyXMovementPace())) / 2, enemy.getEnemyTopYPos() + 0.03f, 0);
			
				}
			}
		}
		    
	}
	// fireProjectiles method
		// Renders existing projectiles and renders new ones when the spaceCount is held for long enough
		public static int mainCharacterFireProjectile (int spaceCount, Enemy [] enemies, MainCharacterProjectile [] mainCharacterProjectileAmmo, int projectiles, 
				MainCharacter character, float mainCharacterXMovement) 
				throws NullPointerException{

				
			mainCharacterProjectileAmmo [projectiles] = new MainCharacterProjectile (mainCharacterXMovement, 0);
				
			mainCharacterProjectileAmmo [projectiles].render();
			projectiles++;
			ammoProjectiles--;
			return projectiles;
			
		}
				
		// updateProjectiles method
		// Re-renders current projectiles and increases their y value and moves projectiles off the screen when they've made contact with
		// an enemy. Also calls mainCharacterProjectileCollision method
		public static void updateProjectiles (MainCharacterProjectile [] mainCharacterProjectileAmmo, int projectiles, Enemy [] enemies)
		throws NullPointerException{
					
			for (int i = 0; i < mainCharacterProjectileAmmo.length; i++){
					
				if (mainCharacterProjectileAmmo [i] != null){
						
					mainCharacterProjectileAmmo [i].increaseLaunch();
						
					if (mainCharacterProjectileAmmo [i].getIsAlive()){
							
						mainCharacterProjectileAmmo [i].increaseLaunch();
						mainCharacterProjectileAmmo [i].render();
					}
					
					else{
						
						// Moves the projectile out of the "picture" so that it doesn't end up hitting any other enemies
						mainCharacterProjectileAmmo [i].setLaunch (2f);
					}
			
				}
								
				initCollision (enemies, mainCharacterProjectileAmmo, i);
			}
			
		}
		
		// initCollision method
		private static void initCollision (Enemy [] enemies, MainCharacterProjectile [] mainCharacterProjectileAmmo, int i)
		throws NullPointerException{

			for (int j = 0; j < enemies.length; j++){
				
				if (mainCharacterProjectileAmmo [i] != null){
					
					Collisions.mainCharacterProjectileCollision(mainCharacterProjectileAmmo [i], enemies[j]);
			
				}
			}
		}
		
		// checkProjectiles method
		public static int checkProjectiles (int projectiles){
			
			if (projectiles > 0 && projectiles % 8 == 0){
				
				Game.isReloading = true;
				Game.checkSpaces = false;
				return 0;
			}
			else{
				
				Game.isReloading = false;
				return projectiles;

			}
		}
		// Reloading idea: Once the projectiles variable hits a multiple of 200, 
		// Game.isReloading is true and reloadCount increments by 1 every time it is 
		// called. Once it reaches 50, Game.isReloading is false and the player can
		// continue firing
		
		
		// Starts the reloadCount every time this function is called. If it equals 50,
		// reloading is finished. 
		public static boolean reload (int projectiles){
			
			if (Game.isReloading){
				
				Game.reloadCount ++;
			}
			
			if (Game.reloadCount == 480){
				
				System.out.println("Reload count is over");
				Game.reloadCount = 0;
				Game.isReloading = false;
				Game.checkSpaces = true;
				return true;
			}
			
			
			else if (Game.reloadCount < 480 && Game.isReloading){
				
				Game.isReloading = true;
				System.out.println("Reloading...");
				ammoProjectiles = 0;
				labels.ammo(ammoProjectiles);
				labels.reloading ();
				return false;
			}
			
			return true;
		}
		
		// ammoProjectileGauge method
		public static void ammoProjectileGauge (){
	
			System.out.println("ammoProjectiles: " + ammoProjectiles);
			
			if (ammoProjectiles <= 0){
				
				ammoProjectiles = 8;
			}
			
			else{
				
				labels.ammo(ammoProjectiles);
			}
		}
			
		// resetProjectiles
		// Makes all projectiles null to reset
		public static void resetProjectiles (Projectile [] projectiles){
			
			for (int i = 0; i < projectiles.length; i++){
				
				projectiles [i] = null;
			}
		}
		
}
