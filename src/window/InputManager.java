/**
 * This class is for managing inputs.
 */

package window;

import org.lwjgl.glfw.GLFWKeyCallback;
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
	@Override
	
	/* Update the values in the array */
	public void invoke(long window, int key, int scancode, int action, int mods) {
		keys[key] = action == GLFW_PRESS;
	}

}
