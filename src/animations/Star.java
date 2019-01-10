package animations;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

// Creates a triangle with a random size that's supposed to represent passing mountains
public class Star {

	float xPos;
	float yPos;
	

	public Star (float xPos, float yPos){
	
		this.xPos = xPos;
		this.yPos = yPos;
	}
	// render method 
	public void render (){
	
		float starSizeIncrease = (float)(Math.random() * 0.01f);

		glBegin (GL_TRIANGLES);
		
			glColor3f (0.5f, 0.5f, 0.5f);
		
			glVertex2f (xPos + starSizeIncrease, yPos - starSizeIncrease);
			glVertex2f (xPos - starSizeIncrease, yPos - starSizeIncrease);
			glVertex2f (xPos, yPos);

		glEnd();
	}
	
	public void render (float tailCharge){
		
	}
	// setXPos method
	public void setXPos (float xPos){
		
		this.xPos = xPos;
	}
	
	// setYPos method
	public void setYPos (float yPos){
		
		this.yPos = yPos;
	}
	
	// getXPos method
	public float getXPos (){
		
		return xPos;
	}
	
	// getYPos method
	public float getYPos (){
	
		return yPos;
	}
}
