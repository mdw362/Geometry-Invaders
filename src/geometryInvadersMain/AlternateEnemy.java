package geometryInvadersMain;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class AlternateEnemy extends Enemy {
	
	float deadNum = 0;
	float enemyTopYQuadPos; 
	public AlternateEnemy(float enemyLeftXPos, float enemyRightXPos, float enemyTopYPos, float enemyBottomYPos,
			float enemyXMovement) {
		
		super(enemyLeftXPos, enemyRightXPos, enemyTopYPos, enemyBottomYPos, enemyXMovement);
		enemyTopYQuadPos = enemyTopYPos;
	}
		@Override
		// render method
		public void render (){
			
			if (isAlive){
				
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyLeftXPos + 0.01f) + enemyXMovementPace, enemyTopYQuadPos -0.025f);
					glVertex2f ((enemyRightXPos - 0.01f) + enemyXMovementPace, enemyTopYQuadPos - 0.025f);
					glVertex2f ((enemyRightXPos - 0.01f) + enemyXMovementPace, enemyTopYQuadPos - 0.1f);
					glVertex2f ((enemyLeftXPos + 0.01f) + enemyXMovementPace, enemyTopYQuadPos - 0.1f);
				
				glEnd ();
				
			}
			renderBase ();
		
		}
		
		public void renderBase (){
			
			if (isAlive){
				// Base quad
				glBegin (GL_QUADS);
			
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f (enemyLeftXPos - 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.005f);
					glVertex2f (enemyRightXPos + 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.005f);
					glVertex2f (enemyRightXPos + 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.03f);
					glVertex2f (enemyLeftXPos - 0.03f + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.03f);
				
				glEnd ();
				// Wing one
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyLeftXPos - 0.03f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyLeftXPos - 0.02f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyLeftXPos - 0.02f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.04f);
					glVertex2f ((enemyLeftXPos - 0.03f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.04f);
				
				glEnd ();
				
				// Wing two
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyRightXPos + 0.03f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyRightXPos + 0.02f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyRightXPos + 0.02f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.04f);
					glVertex2f ((enemyRightXPos + 0.03f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.04f);
				
				glEnd ();
				
				// Back engine one
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyLeftXPos - 0.01f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyLeftXPos) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyLeftXPos) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.07f);
					glVertex2f ((enemyLeftXPos - 0.01f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.07f);
				
				glEnd ();
				
				// Back engine two
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyRightXPos + 0.01f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyRightXPos) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyRightXPos) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.07f);
					glVertex2f ((enemyRightXPos + 0.01f) + enemyXMovementPace + extraEnemyXMovement, enemyTopYPos + 0.07f);
				
				glEnd ();
			}
			
			else{
				// Base quad
				glBegin (GL_QUADS);
			
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f (enemyLeftXPos - 0.03f + extraEnemyXMovement, enemyTopYPos - 0.005f);
					glVertex2f (enemyRightXPos + 0.03f +  extraEnemyXMovement, enemyTopYPos - 0.005f);
					glVertex2f (enemyRightXPos + 0.03f + extraEnemyXMovement, enemyTopYPos - 0.03f);
					glVertex2f (enemyLeftXPos - 0.03f +  extraEnemyXMovement, enemyTopYPos - 0.03f);
				
				glEnd ();
				// Wing one
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyLeftXPos - 0.03f) +extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyLeftXPos - 0.02f) +  extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyLeftXPos - 0.02f) + extraEnemyXMovement, enemyTopYPos + 0.04f);
					glVertex2f ((enemyLeftXPos - 0.03f) + extraEnemyXMovement, enemyTopYPos + 0.04f);
				
				glEnd ();
				
				// Wing two
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyRightXPos + 0.03f) + extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyRightXPos + 0.02f) + extraEnemyXMovement, enemyTopYPos - 0.06f);
					glVertex2f ((enemyRightXPos + 0.02f) + extraEnemyXMovement, enemyTopYPos + 0.04f);
					glVertex2f ((enemyRightXPos + 0.03f) +  extraEnemyXMovement, enemyTopYPos + 0.04f);
				
				glEnd ();
				
				// Back engine one
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyLeftXPos - 0.01f) + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyLeftXPos) + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyLeftXPos) + extraEnemyXMovement, enemyTopYPos + 0.07f);
					glVertex2f ((enemyLeftXPos - 0.01f) +extraEnemyXMovement, enemyTopYPos + 0.07f);
				
				glEnd ();
				
				// Back engine two
				glBegin (GL_QUADS);
				
				glColor4f (1f, colorTwo, colorThree, colorFour);
					
					glVertex2f ((enemyRightXPos + 0.01f) + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyRightXPos) + extraEnemyXMovement, enemyTopYPos - 0.01f);
					glVertex2f ((enemyRightXPos) +  extraEnemyXMovement, enemyTopYPos + 0.07f);
					glVertex2f ((enemyRightXPos + 0.01f) +  extraEnemyXMovement, enemyTopYPos + 0.07f);
				
				glEnd ();
				
			}
			
		}
		// deadEnemy method
		public void deadEnemy (){
				
			// If this is enemy is dead, then it stops making it move side-to-side
			if (deadNum == 0){
				
				extraEnemyXMovement = enemyXMovementPace;
			}
			renderBase ();
			this.setEnemyYTopPos(this.getEnemyTopYPos() - 0.01f);
			deadNum ++;
				
		}
		// setEnemyTopYQuadPos
		public void setEnemyTopYQuadPos (float enemyTopYQuadPos){
			
			this.enemyTopYQuadPos = enemyTopYQuadPos;
		}
		
		// getDeadEnemyRightXPos
		public float getDeadEnemyRightXPos(){
			return enemyRightXPos + 0.03f +  extraEnemyXMovement;
			
		}
		// getDeadEnemyLeftXPos
		public float getDeadEnemyLeftXPos(){
			return enemyLeftXPos - 0.03f + extraEnemyXMovement;

		}
		
		// getDeadEnemyTopYPos
		public float getDeadEnemyTopYPos (){
			return enemyTopYPos - 0.03f;
		}
}
