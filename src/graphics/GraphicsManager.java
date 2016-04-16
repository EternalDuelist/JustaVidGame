/**
 * This class is for most of the OpenGL code to live.
 * I'll update this description once I get a better
 * idea of what needs to happen.
 */



package graphics;

import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;

public class GraphicsManager {
   public void initializeGraphics(long window){
	   GL.createCapabilities();
	   glClearColor(1,1,1,1);
   }
   public void update(){
	   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   }
}
