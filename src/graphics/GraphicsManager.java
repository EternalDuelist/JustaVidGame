/**
 * This class is for most of the OpenGL code to live.
 * I'll update this description once I get a better
 * idea of what needs to happen.
 */

package graphics;
import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;
import static graphics.Shaders.*;

public class GraphicsManager {
	
	public static Shaders shader1;


	public static void loadAll(){
		shader1 = new Shaders("src/shaders/vertex.shader", "src/shaders/fragment.shader");
	}
	
	public static void initializeGraphics(){
		GL.createCapabilities();
		glClearColor(0.2f, 0.2f, 0.8f, 1.0f);
		loadAll();
		shader1.start();
	}

	public static void update(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}  
}
