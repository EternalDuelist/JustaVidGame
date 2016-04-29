/**
 * This class is for managing inputs.
 */

package window;

import org.lwjgl.glfw.GLFWKeyCallback;

import engine.GameObject;
import main.JustaVidGame;

import static org.lwjgl.glfw.GLFW.*;

public class InputManager extends GLFWKeyCallback{

	/** Create a boolean array where every element represents a key.
	 *  If the key is pressed then the value in the array is set to
	 *  true and otherwise it is set to false.
	 *  
	 *  This structure may be upgraded later in the future to be a queue
	 *  that stores the order that keys were pressed in so that it can be
	 *  sent to the opponent so that states can be replicated.
	 **/
	public static boolean[] keys = new boolean[GLFW_KEY_LAST];
	
	/* Update the values in the array */
	public void invoke(long window, int key, int scancode, int action, int mods) {
		GameObject player = JustaVidGame.testObject;
		if (key == GLFW_KEY_UNKNOWN){
			System.out.println("Unknown Key is pressed!");
		}
		
		keys[key] = action == GLFW_PRESS;
		
		if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
			glfwSetWindowShouldClose(window, GLFW_TRUE);
		}
		
		else if (key == GLFW_KEY_DOWN && (action == GLFW_PRESS || action == GLFW_REPEAT) ) {
			player.addPosition(-0.1f, 0.0f, 0.0f);
		}
		
		else if (key == GLFW_KEY_UP && (action == GLFW_PRESS || action == GLFW_REPEAT) ) {
			player.addPosition(0.1f, 0.0f, 0.0f);
		}
		
		else if (key == GLFW_KEY_LEFT && (action == GLFW_PRESS || action == GLFW_REPEAT) ) {
			player.addPosition(0.0f, -0.1f, 0.0f);
		}
		
		else if (key == GLFW_KEY_RIGHT && (action == GLFW_PRESS || action == GLFW_REPEAT) ) {
			player.addPosition(0.0f, 0.1f, 0.0f);
		}
		
		else if (key == GLFW_KEY_SPACE && (action == GLFW_PRESS || action == GLFW_REPEAT) ) {
			player.addPosition(0.0f, 0.0f, 0.1f);
		}
	}

}
