package main;

import window.WindowManager;
import static org.lwjgl.glfw.GLFW.*;
 
public class JustaVidGame {
    // We need to strongly reference callback instances.
  
    private void loop(long window) {
        // Run the rendering loop until the user has attempted to close
        // the window
        while (glfwWindowShouldClose(window) == GLFW_FALSE) {
            glfwSwapBuffers(window);								// draws on the screen at a frame rate specified in init
            glfwPollEvents();										// checks for user input and takes an action based on the key callback
        }
    }
    
    private void run(){
    	WindowManager WManager = new WindowManager();
    	try {
            WManager.initializeWindow();
            loop(WManager.window());
            glfwDestroyWindow(WManager.window());	// Destroy window and window callbacks
        } finally {
            glfwTerminate();					// Terminate GLFW and free the GLFWErrorCallback
        }
    }
 
    public static void main(String[] args) {
    	new JustaVidGame().run();
    }
}