package geometryInvadersMain;

import static org.lwjgl.glfw.GLFW.*;  
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

import actions.Fire;

import static org.lwjgl.opengl.GL11.*;

public abstract class Enemy {
	
	float enemyLeftXPos;
	float enemyRightXPos;
	float enemyTopYPos;
	float enemyBottomYPos;
	float enemyXMovement;
	int shouldLaunch = 0;
	int projectiles = 0;
	boolean isAlive = true;
	
	// The pace at which the enemies move from side to side
	protected static float enemyXMovementPace = 0.1f;
	protected float extraEnemyXMovement = 0;
	protected static boolean goingRight = true;
	
	EnemyProjectile enemyProjectileAmmo [] = new EnemyProjectile [1000];
	float colorTwo = (float)(Math.random() * 0.5f);
	float colorThree = (float)(Math.random() * 0.5f);
	float colorFour = (float)(Math.random() * 0.5f);
	
	public Enemy (float enemyLeftXPos, float enemyRightXPos, float enemyTopYPos, float enemyBottomYPos, float enemyXMovement){
		
		this.enemyLeftXPos = enemyLeftXPos;
		this.enemyRightXPos = enemyRightXPos;
		this.enemyTopYPos = enemyTopYPos;
		this.enemyBottomYPos = enemyBottomYPos;
		
		this.enemyXMovement = enemyXMovement;
		
	}
	
	// render method
	public void render (){
		
			
	}
	
	public void enemyFireProjectiles (float mainCharacterXMovement){
		
		try{
			
			// Fires projectiles
			Fire.fireProjectile(enemyProjectileAmmo, this, mainCharacterXMovement);
		}
		
		catch (Exception e){
			
			System.out.println ("fireProjectile method exception: " + e.getMessage());
		}
		
	}
	// moveX method
	// Moves the enemy left and right
	// Once the enemy gets too close to one side of the screen, they switch directions
	public void moveX (){
		
		if (goingRight){
			
			enemyXMovementPace += 0.001f;
			
			if (enemyXMovementPace + enemyRightXPos >= 1f){
				
				goingRight = false;
			}
		}
		else if (!goingRight){
			
			enemyXMovementPace -= 0.001f;
			
			if (enemyXMovementPace + enemyLeftXPos <= -1f){
				
				goingRight = true;
			}
		}
	}
	
	//deadEnemy method
	public abstract void deadEnemy ();
	public abstract void setEnemyTopYQuadPos(float setEnemyTopYQuadPos);

	// getEnemyProjectileAmmo method
	public EnemyProjectile [] getEnemyProjectileAmmo (){
		
		return enemyProjectileAmmo;
	}
	
	// getProjectiles method
	public int getProjectiles (){
		
		return projectiles;
	}
	// setProjectiles method
	public void setProjectiles (int projectiles){
		
		this.projectiles = projectiles;
	}
	// getShouldLaunch method
	public int getShouldLaunch (){
			
		return shouldLaunch;
	}
	// setShouldLaunch method
	public void setShouldLaunch (int shouldLaunch){
			
		this.shouldLaunch = shouldLaunch;
	}
		
	// getEnemyLeftX method
	public float getEnemyLeftXPos (){
		
		return enemyLeftXPos - 0.03f + enemyXMovementPace;
	}
	
	// getEnemyRightXPos method
	public float getEnemyRightXPos (){
		
		return enemyRightXPos + 0.03f + enemyXMovementPace;
	}
	
	// getEnemyBottomSquareY method
	public float getEnemyTopYPos (){
		
		return enemyTopYPos;
	}
	
	// setEnemyYTopPos method
	public void setEnemyYTopPos (float enemyTopYPos){
		
		this.enemyTopYPos = enemyTopYPos;
	}
	
	// getEnemyXMovementPace method
	public float getEnemyXMovementPace (){
		
		return enemyXMovementPace;
	}
	
	public void setExtraEnemyXMovement (float extraEnemyXMovement){
		this.extraEnemyXMovement = extraEnemyXMovement;
	}
	
	public float getExtraEnemyXMovement (){
		
		return extraEnemyXMovement;
	}
	
	// getIsAlive method
	public boolean getIsAlive(){
		
		return isAlive;
	}
	
	// setIsAlive method
	public void setIsAlive (boolean isAlive){
		
		this.isAlive = isAlive;
	}
	public abstract float getDeadEnemyRightXPos();
	
	public abstract float getDeadEnemyLeftXPos();
	
	public abstract float getDeadEnemyTopYPos ();
}
