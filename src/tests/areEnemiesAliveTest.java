package tests;

import static org.junit.Assert.*;
import actions.Enemies;

import org.junit.Test;

import geometryInvadersMain.*;
public class areEnemiesAliveTest {

	@Test
	public void test() {
		Game game = new Game ();
		Enemy [] enemies = new Enemy [10];

		for (int i = 0; i < enemies.length; i++){
			
//			enemies[i] = new Enemy (0, 0, 0, 0, 0);
		}
		System.out.println("Enemies have been initialized. Should be true");
		assertTrue (Enemies.areEnemiesAlive(enemies));
		
		for (int i = 0; i < enemies.length; i++){
			
			enemies [i].setIsAlive(false);
		}
		
		System.out.println("Simulates the killing of enemies. Should return false");
		assertFalse (Enemies.areEnemiesAlive(enemies));
	}

}
