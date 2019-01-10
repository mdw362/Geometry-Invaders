package animations;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class ShootingStar extends Star{
	
	public ShootingStar (float xPos, float yPos){
		
		super (xPos, yPos);
	}
	@Override
	// render method
	public void render (float tailCharge){
		
		float starSizeIncrease = (float)(Math.random() * 0.009f);
//		System.out.println("Shooting star rendered at " + getXPos () + ", " + getYPos());
		glBegin (GL_TRIANGLES);
		
			glColor3f (0.5f, 0.5f, 0.5f);
		
			glVertex2f (xPos + starSizeIncrease, yPos - starSizeIncrease);
			glVertex2f (xPos - starSizeIncrease, yPos - starSizeIncrease);
			glVertex2f (xPos, yPos);

		glEnd();
		
		starTail (tailCharge);
	}
	
	// starTail method
	public void starTail (float tailCharge){

		// tailCharge changes the direction the shooting star's tail will go. If it is coming from the right, tailCharge will be positive 1
		// if it is coming from the top left, tailCharge will be negative 1
		glBegin (GL_TRIANGLES);
		
			glVertex2f (xPos, yPos);
			glVertex2f (xPos + (0.03f * tailCharge), yPos + 0.03f);
			glVertex2f (xPos + (0.5f * tailCharge), yPos + 0.3f);
			
		glEnd();
	}

}
