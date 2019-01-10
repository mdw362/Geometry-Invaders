package tests;

import static org.junit.Assert.*; 

import org.junit.Test;

import animations.Stars;

// JUnit test class for rendering mountains
public class StarsTest {

	// before running test, make sure that the render methods in Mountains.java are not called
	@Test
	public void test() {
		System.out.println("Testing for size of arrayMountains and mountains before and after ");

		assertEquals (78, Stars.arrayStars.length);
		assertEquals (0, Stars.stars.size());
		Stars.initStars();
		
		assertEquals (78, Stars.stars.size());
		while (true){
		
			Stars.updateStars(0.01f);
			
		}
	}

}
