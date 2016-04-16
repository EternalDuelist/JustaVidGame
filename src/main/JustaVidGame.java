package main;

import window.WindowManager;
import static org.lwjgl.glfw.GLFW.*;

import graphics.GraphicsManager;
 
public class JustaVidGame {
    // We need to strongly reference callback instances.
  /*
   *         	glfwPollEvents();								// checks for user input and takes an action based on the key callback
            
        	glfwSwapBuffers(window);						// draws on the screen at a frame rate specified in init
        
   */
    private void loop(WindowManager WMan, GraphicsManager GMan) {
    	long window = WMan.window();
        // Run the rendering loop until the user has attempted to close
        // the window
        while (glfwWindowShouldClose(window) == GLFW_FALSE) {
        	glfwPollEvents();			// checks for user input and takes an action based on the key callback
        	GMan.update();
        	glfwSwapBuffers(window);	// draws on the screen at a frame rate specified in init
        }
    }
    
    private void run(){
    	WindowManager WMan = new WindowManager();
    	GraphicsManager GMan = new GraphicsManager();
    	try {
            WMan.initializeWindow();
            GMan.initializeGraphics(WMan.window());
            loop(WMan, GMan);
            glfwDestroyWindow(WMan.window());	// Destroy window and window callbacks
        } finally {
            glfwTerminate();					// Terminate GLFW and free the GLFWErrorCallback
        }
    }
 
    public static void main(String[] args) {
    	new JustaVidGame().run();
    }
}