package geometryInvadersMain;
import static org.lwjgl.glfw.GLFW.*; 
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public abstract class Projectile {
	
	float xPos;
	float yPos;
	
	// projectile must disappear after colliding with a character
	private boolean isAlive;
	
	// launch is a dynamic variable that continually adds to the y value of the projectile, thus making the projectile move up/down
	public float launch;
	
	public Projectile (float xPos, float yPos, float launch){
		
		isAlive = true;
		this.xPos = xPos;
		this.yPos = yPos;
		this.launch = launch;
	}
	
	// render method
	public abstract void render ();
	
	// decreaseLaunch method
	public void decreaseLaunch (){
		
		launch -= 0.0125f;
	}
	
	// increaseLaunch method
	public void increaseLaunch (){
		
		launch += 0.015f;
	}
	
	// setLaunch method
	public void setLaunch (float launch){
		
		this.launch = launch;
	}
	
	// getXPos method
	// Returns the x value of the tip of the projectile
	public float getXPos (){
		
		return xPos;
	}
	
	// getYPos method
	// Returns the y value of the tip of the projectile
	public float getYPos (){
		
		return yPos;
	}
	
	// getIsAlive method
	public boolean getIsAlive (){
		
		return isAlive;
	}
	
	// setIsAlive
	public void setIsAlive (boolean isAlive){
		
		this.isAlive = isAlive;
	}
	
}
