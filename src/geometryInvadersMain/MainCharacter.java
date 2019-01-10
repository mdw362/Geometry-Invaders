package geometryInvadersMain;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class MainCharacter {
	
	private float mainCharacterXMovement;
	private boolean isAlive;
	MainCharacterProjectile [] mainCharacterProjectileAmmo = new MainCharacterProjectile [1000];
	// Used to keep track of what iteration mainCharacterProjectileAmmo is on
	int projectileCount;

	public MainCharacter (float mainCharacterXMovement){
		
		this.mainCharacterXMovement = mainCharacterXMovement;
		isAlive = true;
		render (mainCharacterXMovement);
	}
	
	// render method
	public void render (float mainCharacterXMovement){
		
			if (isAlive){
			
				// Cockpit triangle
				glBegin (GL_TRIANGLES);
					
				glColor4f (0.58f, 0.58f, 0.58f, 0.55f);


					glVertex2f (-0.0075f + mainCharacterXMovement, -0.64f);
					glVertex2f (0.0075f + mainCharacterXMovement, -0.64f);
					glVertex2f (0f + mainCharacterXMovement, -0.58f);
				
				glEnd();
				
				// Main quad body
				glBegin (GL_QUADS);
				
				glColor4f (0.58f, 0.58f, 0.58f, 0.55f);
				
					glVertex2f (-0.0075f + mainCharacterXMovement, -0.64f);
					glVertex2f (0.0075f + mainCharacterXMovement, -0.64f);
					glVertex2f (0.0075f + mainCharacterXMovement, -0.84f);
					glVertex2f (-0.0075f + mainCharacterXMovement, -0.84f);
					
				glEnd ();
				
				// Primary engine flame
				glBegin (GL_TRIANGLES);
				
					float flameFlicker = (float)((Math.random() * 0.1f) - 1f);
					glColor4f (0.7f, 0, 0f, 0);


					glVertex2f (-0.0075f + mainCharacterXMovement, -0.84f);
					glVertex2f (0.0075f + mainCharacterXMovement, -0.84f);
					glVertex2f (0f + mainCharacterXMovement, flameFlicker);
				
				glEnd();
				
				// Wings
				glBegin (GL_QUADS);
				
				glColor4f (0.58f, 0.58f, 0.58f, 0.55f);
				
					glVertex2f (-0.06f + mainCharacterXMovement, -0.79f);
					glVertex2f (0.06f + mainCharacterXMovement, -0.79f);
					glVertex2f (0.06f + mainCharacterXMovement, -0.77f);
					glVertex2f (-0.06f + mainCharacterXMovement, -0.77f);
					
				glEnd ();
				
				
				glBegin (GL_QUADS);
				glColor4f (0.38f, 0.38f, 0.38f, 0.35f);
					glVertex2f (-0.04f + mainCharacterXMovement, -0.74f);
					glVertex2f (-0.03f + mainCharacterXMovement, -0.74f);
					glVertex2f (-0.03f + mainCharacterXMovement, -0.8f);
	
					glVertex2f (-0.04f + mainCharacterXMovement, -0.8f);
					
				glEnd ();
				
				glBegin (GL_QUADS);

				glColor4f (0.38f, 0.38f, 0.38f, 0.35f);
					glVertex2f (0.06f + mainCharacterXMovement, -0.72f);
					glVertex2f (0.05f + mainCharacterXMovement, -0.72f);
					glVertex2f (0.05f + mainCharacterXMovement, -0.82f);
					glVertex2f (0.06f + mainCharacterXMovement, -0.82f);
				glEnd ();
				
				glBegin (GL_QUADS);
				
				glColor4f (0.38f, 0.38f, 0.38f, 0.35f);
				glVertex2f (-0.06f + mainCharacterXMovement, -0.72f);
					glVertex2f (-0.05f + mainCharacterXMovement, -0.72f);
					glVertex2f (-0.05f + mainCharacterXMovement, -0.82f);
	
					glVertex2f (-0.06f + mainCharacterXMovement, -0.82f);
					
				glEnd ();
				
				// Side engine flame
				glBegin (GL_TRIANGLES);
				
					float flameFlickerTwo = (float)((Math.random() * 0.1f) - 0.95f);
					glColor4f (0.7f, 0, 0f, 0);

					glVertex2f (-0.06f + mainCharacterXMovement, -0.82f);
					glVertex2f (-0.05f + mainCharacterXMovement, -0.82f);
					glVertex2f (-0.055f + mainCharacterXMovement, flameFlickerTwo);
				
				glEnd();
				
				glBegin (GL_QUADS);
	
				glColor4f (0.38f, 0.38f, 0.38f, 0.35f);

					glVertex2f (0.04f + mainCharacterXMovement, -0.74f);
					glVertex2f (0.03f + mainCharacterXMovement, -0.74f);
					glVertex2f (0.03f + mainCharacterXMovement, -0.8f);
					glVertex2f (0.04f + mainCharacterXMovement, -0.8f);
				glEnd ();
				
				// Side engine flame
				glBegin (GL_TRIANGLES);
				
				float flameFlickerThree = (float)((Math.random() * 0.1f) - 0.95f);
					glColor4f (0.7f, 0, 0f, 0);
	
					glVertex2f (0.06f + mainCharacterXMovement, -0.82f);
					glVertex2f (0.05f + mainCharacterXMovement, -0.82f);
					glVertex2f (0.055f + mainCharacterXMovement, flameFlickerThree);
			
				glEnd();
			}
			
		}
	
	// moveX method
	public float moveX (long win, float mainCharacterXMovement){
			
		if ((glfwGetKey (win, GLFW_KEY_A) == GL_TRUE || glfwGetKey (win, GLFW_KEY_LEFT) == GL_TRUE)
				&& mainCharacterXMovement >= -0.85f){
				
			mainCharacterXMovement -= 0.02f;
		}
			
		if ((glfwGetKey (win, GLFW_KEY_D) == GL_TRUE  || glfwGetKey (win, GLFW_KEY_RIGHT) == GL_TRUE)
				&& mainCharacterXMovement <= 0.85f){
				
			mainCharacterXMovement += 0.02f;
		}
			
		return mainCharacterXMovement;
	}
	
	// getMainCharacterAlive method	
	public boolean getIsAlive(){
		
		return isAlive;
	}
	
	// setIsMainCharacterAlive method
	public void setIsAlive (boolean isAlive){
		
		this.isAlive = isAlive;
	}
	
	// getMainCharacterProjectileAmmo method
	public MainCharacterProjectile [] getMainCharacterProjectileAmmo (){
		
		return mainCharacterProjectileAmmo;
	}
	
	// getMainCharacterXMovement method
	public float getMainCharacterXMovement (){
		
		return mainCharacterXMovement;
	}

}
