package geometryInvadersMain;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

import actions.Enemies;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

class SoundSource implements Runnable {
	
	private boolean isMusicPlaying = true;

	public void run (){
				try{
										
//					URL url = new URL("file:///Users/mikewong/Documents/workspace/LWJGL-T/MegabitesRefactored.mp3");
//					File file = new File (url.toURI());
//					File file = new File ("/Users/mikewong/Documents/workspace/LWJGL-T/src/MegabitesRefactored.mp3");
//					FileInputStream fileStream = new FileInputStream (file);
					
					// Since the music is an mp3 files, FileInputStream cannot be used. InputStream is used instead
					InputStream fileStream = this.getClass().getResourceAsStream("/MegabitesRefactored.mp3");

					BufferedInputStream bufferStream = new BufferedInputStream (fileStream);
					Player player = new Player (bufferStream);
					player.play();
	
				}
		
//				catch (URISyntaxException exc){
//					System.out.println(exc.getMessage() + " " + exc.toString());

//				}
				catch (Exception ex){
			
					System.err.println(ex.getMessage() + " " + ex.toString());
				}

	}
	
	public void killThread (){
		
		this.isMusicPlaying = false;
	}
	
}
public class Sound  {
		
	SoundSource source = new SoundSource();

	public void killThread (){
		
		source.killThread ();
	}
	public void initBackground (){
		
		Thread soundThread = new Thread (source);
		soundThread.start();
	}
	
}
