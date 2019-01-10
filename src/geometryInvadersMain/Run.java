package geometryInvadersMain;

import java.awt.Canvas;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
//import org.lwjgl.LWJGLException;
//import org.lwjgl.opengl.Display;

import javax.swing.JApplet;

public class Run {
	// main method
	// Initiates a Game object and runs all of the game's necessary functions
	public static void main (String [] args){
		
		Game game = new Game ();
		Sound sound = new Sound ();
		game.init ();
		sound.initBackground();
		game.update();
		game.initLoop ();
		game.gameLoop ();
		game.cleanUp ();
		sound.killThread();
	}
	
	
}
