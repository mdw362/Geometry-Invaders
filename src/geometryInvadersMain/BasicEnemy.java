package geometryInvadersMain;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class BasicEnemy extends Enemy {
	
	public BasicEnemy(float enemyLeftXPos, float enemyRightXPos, float enemyTopYPos, float enemyBottomYPos,
			float enemyXMovement) {
		
		super(enemyLeftXPos, enemyRightXPos, enemyTopYPos, enemyBottomYPos, enemyXMovement);
	}
		@Override
		// render method
		public void render (){
			
			if (isAlive){
				
				glBegin (GL_QUADS);
			
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f (enemyLeftXPos - 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.03f);
					glVertex2f (enemyRightXPos + 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.03f);
					glVertex2f (enemyRightXPos + 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos);
					glVertex2f (enemyLeftXPos - 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos);
				
				glEnd ();
				
					
				glBegin (GL_TRIANGLES);
			
					glColor4f (1f, colorTwo, colorThree, colorFour);
				
					glVertex2f (enemyLeftXPos + enemyXMovementPace, enemyTopYPos);
					glVertex2f (enemyRightXPos + enemyXMovementPace, enemyTopYPos);
					glVertex2f (((enemyLeftXPos +  enemyRightXPos) / 2) + enemyXMovementPace, enemyBottomYPos);

				glEnd ();
				
				glBegin (GL_TRIANGLES);
				
					glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f (enemyLeftXPos - 0.03f + enemyXMovementPace, enemyTopYPos);
					glVertex2f (enemyLeftXPos + enemyXMovementPace, enemyTopYPos);
					glVertex2f ((enemyLeftXPos + (enemyLeftXPos - 0.03f)) / 2 + enemyXMovementPace, (enemyTopYPos + enemyBottomYPos) / 2);
				
				glEnd ();
				
				glBegin (GL_TRIANGLES);
				
					glColor4f (1f, colorTwo, colorThree, colorFour);
				
					glVertex2f (enemyRightXPos + 0.03f + enemyXMovementPace, enemyTopYPos);
					glVertex2f (enemyRightXPos + enemyXMovementPace, enemyTopYPos);
					glVertex2f (((enemyRightXPos + (enemyRightXPos + 0.03f)) / 2) + enemyXMovementPace, (enemyTopYPos + enemyBottomYPos) / 2);
			
				glEnd ();
				
				
			}
		}
		
		public void deadEnemy (){
			
		}
		
		public void setEnemyTopYQuadPos (float enemyTopYQuadPos){
			
		}
		public float getDeadEnemyRightXPos(){
			return 0;
		}
		
		public float getDeadEnemyLeftXPos(){
			return 0;
		}
		
		public float getDeadEnemyTopYPos (){
			return 0;
		}
}
