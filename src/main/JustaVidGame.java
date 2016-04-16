/***********************************************************************
 * Big Thanks to the TutorialEdge Youtube channel for providing useful
 * tutorials to for which the initial code is based off of.
 ***********************************************************************/

package main;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import window.WindowManager;
import graphics.GraphicsManager;
import engine.VisibleGameObject;
 
public class JustaVidGame {
    // We need to strongly reference callback instances.
	
    private void loop(WindowManager WMan, GraphicsManager GMan, VisibleGameObject box) {
    	long window = WMan.window();
        // Run the rendering loop until the user has attempted to close
        // the window
        while (glfwWindowShouldClose(window) == GLFW_FALSE) {
        	glfwPollEvents();			// checks for user input and takes an action based on the key callback
        	GMan.update();
        	box.draw();
        	glfwSwapBuffers(window);	// draws on the screen at a frame rate specified in init
        }
    }
    
    private void run(){
    	WindowManager WMan = new WindowManager();
    	GraphicsManager GMan = new GraphicsManager();
    	VisibleGameObject box;
    	
    	try {
            WMan.initializeWindow();
            GMan.initializeGraphics(WMan.window());
            box = new VisibleGameObject(1);
            System.out.println("OpenGL: " + glGetString(GL_VERSION));
            loop(WMan, GMan, box);
            glfwDestroyWindow(WMan.window());	// Destroy window and window callbacks
        } finally {
            glfwTerminate();					// Terminate GLFW and free the GLFWErrorCallback
        }
    }
 
    public static void main(String[] args) {
    	new JustaVidGame().run();
    }
}