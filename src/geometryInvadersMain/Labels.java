package geometryInvadersMain;

import static org.lwjgl.glfw.GLFW.*;   
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

import actions.Text;

import static org.lwjgl.opengl.GL11.*;

public class Labels {
	
	// startLabel method
	// Uses shapes and lines to show a START sign in the beginning of the game
	public void startLabel (){
		
		Text.drawString("Geometry Invaders", -4.5f, 1f, 0.5f, 2.2f, 0, 1, 0);
		Text.drawString("Clic k  or press space to  sta rt" , -6.2f, -4f, 0.38f, 2f, 1, 1, 1);
			
	}
	
	// changeLevels method
	public void changeLevels (int level){
		
		Text.drawString("Level " + level, -2f, 0, 0.5f, 2.2f, 0, 1, 0);
		Text.drawString("Clic k to  sta rt" , -3.4f, -4f, 0.38f, 2f, 1, 1, 1);

	}
	// pause method
	public void pause (){
		
		Text.drawString("Pause", -1.4f, 2.25f, 0.45f, 0.4f, 1, 1, 1);
		Text.drawString("Clic k or press space  to  resume" , -6.4f, -4f, 0.4f, 2f, 1, 1, 1);
	}
	// restart method
	public void restart(int hiScore){
		
		Text.drawString("Game Over", -2.1f, 5, 0.5f, 2.2f, 1, 0, 0);

		Text.drawString("Score: " + Game.score, -1.9f, 3f, 0.45f, 0.4f, 1, 0, 0);
		Text.drawString("Best Score: " + hiScore, -3.4f, 0f, 0.55f, 0.5f, 1, 0, 0);
		Text.drawString("Clic k to  re sta rt" , -3.5f, -4f, 0.35f, 2f, 1, 1, 1);
	}
	
	// instructions method
	// Renders the "hold space to shoot" text in game
	public void instructions (){
		
		Text.drawString("press space to shoot!", -4.2f, 2.25f, 0.4f, 0.4f, 1, 1, 1);

	}
	// score method
	public void score (){
		
		Text.drawString("Score: " + Game.score, -2f, 5.25f, 0.45f, 0.4f, 1, 1, 1);
	}
	
	// reloading method
	// Renders the "reloading ..." text once the character needs to reload
	public void reloading (){
		
		if ((Game.reloadCount <= 40) ||
			(Game.reloadCount >= 120 && Game.reloadCount <= 160) ||
			(Game.reloadCount > 240 && Game.reloadCount <= 280) ||
			(Game.reloadCount > 360 && Game.reloadCount <= 400)){
			
			Text.drawString("Relo ading . " , 3f, -5f, 0.4f, 0.25f, 1, 1, 1);
		}
			
		else if ((Game.reloadCount > 40 && Game.reloadCount <= 80) ||
				(Game.reloadCount > 160 && Game.reloadCount <= 200) ||
				(Game.reloadCount > 280 && Game.reloadCount <= 320) ||
				(Game.reloadCount > 400 && Game.reloadCount <= 440)){
			
			Text.drawString("Relo ading .. " , 3f, -5f, 0.4f, 0.25f, 1, 1, 1);

		}
		
		else if ((Game.reloadCount > 80 && Game.reloadCount <= 120) ||
			(Game.reloadCount > 200 && Game.reloadCount <= 240) ||
			(Game.reloadCount > 320 && Game.reloadCount <= 360) ||
			(Game.reloadCount > 440 && Game.reloadCount <= 480)){
		
			Text.drawString("Relo ading ... " , 3f, -5f, 0.4f, 1f, 1, 1, 1);
			}

	}
	
	// ammo method
	// Renders the amount of ammo remaining
	public void ammo (int ammoProjectiles){
		
		if (ammoProjectiles > 0 && ammoProjectiles <= 8){
			
			Text.drawString("" + ammoProjectiles, -6.3f, -5f, 0.5f, 0.5f, 1, 1, 1);
		}
		
		if (ammoProjectiles == 0){
			
			Text.drawString("--", -7f, -5f, 0.5f, 0.5f, 1, 1, 1);
		}
	}
	
}
