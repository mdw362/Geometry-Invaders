package geometryInvadersMain;
import static org.lwjgl.glfw.GLFW.*;      
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

import actions.Enemies;
import actions.Fire;
import actions.KeyboardHandler;
import animations.Stars;

public class Game {
	
	int loopNum = 0;
	int level = 1;
	// The amount of enemies that will be rendered. Increases as the level increases
	int enemiesRendered = 24;
	// The value that controls how often an enemy will fire a projectile. The lower this number, the higher the chances. Decreases as
	// the level increases 
	int enemyLaunchChances = 1200;
	// Controls whether the MainCharacter is rendered or not
	public static boolean isAlive = true;
	public static int score = 0;
	public static boolean isReloading = false;
	public static int reloadCount = 0;
	public static boolean checkSpaces = true;
	
	// This prevents our window from crashing later on.
	private GLFWKeyCallback keyCallback;
	
	
	long win;
	boolean isFirstRun = true;
	float mainCharacterXMovement = 0;
	int spaceCount = 0;
	int projectiles = 0;
	
	// Creates ScoreWriter object to keep track of the highest recorded score
	ScoreWriter scoreWriter = new ScoreWriter();
	
	// init method
	public void init (){
		
		// Initializes glfw
		if (!glfwInit()){
			
			System.err.println("GLFW could not be initialized");
		}
		
		// Initializes window size and title
		win = glfwCreateWindow (1200, 800, "Game", 0, 0);
		
		glfwShowWindow (win);
		
		glfwMakeContextCurrent (win);
		GL.createCapabilities();
		
		// Sets our keycallback to equal our newly created Input class()
		glfwSetKeyCallback(win, keyCallback = new KeyboardHandler());   
		
	}
	
	// update method
	public void update (){
		
		glClearColor (0, 0, 0.1f, 1);
		glfwPollEvents ();
		glClear (GL_COLOR_BUFFER_BIT);
	}
	
	// menUpdate method
	public void screenUpdate(){
		
		glClearColor (0, 0, 0, 0);
		glfwPollEvents ();
		glClear (GL_COLOR_BUFFER_BIT);
	}
	
	// initLoop method
	public void initLoop (){
		
		Labels labels = new Labels ();
		while (!glfwWindowShouldClose (win)){
			
			screenUpdate ();
			labels.startLabel();
			glfwSwapBuffers (win);
			if (glfwGetMouseButton (win, 0) == GL_TRUE || KeyboardHandler.isKeyDown(GLFW_KEY_SPACE)){
				
				break;
			}
			
		}
	}
		
	// levelLoop method
	public void levelLoop (){
		
		Labels labels = new Labels ();
		
		while (!glfwWindowShouldClose(win)){
			
			screenUpdate();
			labels.changeLevels(level);
			glfwSwapBuffers (win);
			if ((glfwGetMouseButton (win, 0) == GL_TRUE) ){
				
				break;
			}
			
		}
	}
	
	// pauseLoop method
	public void pauseLoop (){
		
		Labels labels = new Labels ();
		
		while (!glfwWindowShouldClose(win)){
			
			update();
			labels.pause();
			glfwSwapBuffers (win);
			if (glfwGetMouseButton (win, 0) == GL_TRUE || KeyboardHandler.isKeyDown(GLFW_KEY_SPACE)){
				
				break;
			}
			
		}
	}
	
	// restartLoop method
	public void restartLoop (int score){
		
		Labels labels = new Labels ();
		
		while (!glfwWindowShouldClose (win)){
			
			screenUpdate ();
			labels.restart(score);
			glfwSwapBuffers (win);
			if (glfwGetMouseButton (win, 0) == GL_TRUE){
				
				break;
			}
		}
	}
	
	// gameLoop method
	// The main game loop that calls all of the necessary functions
	public void gameLoop (){
		
		MainCharacter character = new MainCharacter (mainCharacterXMovement);
		MainCharacterProjectile [] mainCharacterProjectileAmmo  = character.getMainCharacterProjectileAmmo ();
		Enemy enemies [] = new Enemy [enemiesRendered];
		Labels label = new Labels ();
		Stars.initStars ();
		
		while (!glfwWindowShouldClose (win)){
			
			update ();
			
			mainCharacterXMovement = character.moveX(win, mainCharacterXMovement);		
			
//			System.out.println ("Score: " + scoreWriter.getScore());
			// stars animations
			Stars.updateStars(0.02f);
			Stars.addNewRow();
			
			// labels and animations are rendered
			label.instructions();
			label.score();
		
			if (glfwGetKey (win, GLFW_KEY_P) == GL_TRUE){
				
				pauseLoop ();
			}
			if (isAlive){
				
				character.render(mainCharacterXMovement);
			}
			
			if (isFirstRun){
				
				Enemies.initEnemies (mainCharacterXMovement, enemies);
			}
			
			if (!isFirstRun){
				
				Enemies.moveEnemies (mainCharacterProjectileAmmo, enemies, mainCharacterXMovement, projectiles);
			}
			
			Fire.reload(projectiles);
			if (isAlive){
				
				try{			
				
					if (Fire.reload(projectiles)){
						
						// Checks if space is down and that the loop number is a multiple of 7 to ensure that the user cannot fire too quickly
						 if(KeyboardHandler.isKeyDown(GLFW_KEY_SPACE) &&
								 (loopNum > 0 && loopNum % 7 == 0)){
							 
					        System.out.println("Space Key Pressed");
					        // Creates new projectile when space is pressed
						 	projectiles = Fire.mainCharacterFireProjectile (spaceCount, enemies, mainCharacterProjectileAmmo, projectiles, character, mainCharacterXMovement);
						 }
						 // Checks projectile count to see if the ship needs to reload
						 projectiles = Fire.checkProjectiles(projectiles);
					}
					// renders ammo label depending on how much ammo is left
					Fire.ammoProjectileGauge();
					Fire.updateProjectiles (mainCharacterProjectileAmmo, projectiles, enemies);
				}
			
				catch (Exception e){
				
					System.out.println (e.getMessage() + " " + e.toString());
				}
			}
			
			isFirstRun = false;
			glfwSwapBuffers (win);	
			
			// Resets all of the variables when the player dies or when all of the enemies die
				if (!isAlive){
					
					if (score > scoreWriter.getScore()){
						
						System.out.println("HiScore was reached!");
						scoreWriter.overwriteScore(score);
						restartLoop (score);
					}
					
					else{
						
						restartLoop (scoreWriter.getScore());
					}
					level = 1;

					score = 0;
					enemiesRendered = 24;
					enemyLaunchChances = 1200;
					Enemies.setEnemiesShouldLaunch((int)(Math.random() * enemyLaunchChances), enemies);
					initVariables(mainCharacterProjectileAmmo, enemies, character);
					enemies = new Enemy [enemiesRendered];	
					continue;
				}
				
				else if (!Enemies.areEnemiesAlive (enemies)){
					
					level ++;
					levelLoop ();

					enemyLaunchChances -= 50;
					Enemies.setEnemiesShouldLaunch((int)(Math.random() * enemyLaunchChances), enemies);
					if (enemiesRendered <= 47){
					
						enemiesRendered += 8;
					}
					
					initVariables(mainCharacterProjectileAmmo, enemies, character);
					enemies = new Enemy [enemiesRendered];	
					continue;
			}
				
			loopNum++;
		
		}
		
	}
	
	//cleanUp method
	public void cleanUp (){
		
		glfwTerminate ();
	}
	
	// initVariables method
	public void initVariables (Projectile [] mainCharacterProjectileAmmo, Enemy [] enemies, MainCharacter character){
		
		isAlive = true;
		isReloading = false;
		reloadCount = 0;
		checkSpaces = true;
		character.setIsAlive(true);
		Fire.ammoProjectiles = 0;
		for (int i = 0; i < enemies.length; i++){
			Fire.resetProjectiles(enemies[i].getEnemyProjectileAmmo());
		}
		Fire.resetProjectiles(mainCharacterProjectileAmmo);
		isFirstRun = true;
		mainCharacterXMovement = 0;
		spaceCount = 0;
		projectiles = 0;
	}
}
