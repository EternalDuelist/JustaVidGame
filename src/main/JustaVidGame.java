/***********************************************************************
 * Big Thanks to the TutorialEdge Youtube channel for providing useful
 * tutorials to for which the initial code is based off of.
 ***********************************************************************/

package main;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

import window.WindowManager;
import graphics.GraphicsManager;
import engine.VisibleGameObject;
 
public class JustaVidGame {
    // We need to strongly reference callback instances.
	
    private void loop(long window, VisibleGameObject box) {
        // Run the rendering loop until the user has attempted to close
        // the window
    	GraphicsManager.shader1.start();
        while (glfwWindowShouldClose(window) == GLFW_FALSE) {
        	glfwPollEvents();			// checks for user input and takes an action based on the key callback
        	
        	GraphicsManager.update();
        	box.draw();
        	glfwSwapBuffers(window);	// draws on the screen at a frame rate specified in init
        }
    }
    
    private void run(){
    	WindowManager WMan = new WindowManager();
    	VisibleGameObject box;
    	try {
            WMan.initializeWindow();
            GraphicsManager.initializeGraphics();
            box = new VisibleGameObject();
            
            loop(WMan.window(), box);
            
            glfwDestroyWindow(WMan.window());	// Destroy window and window callbacks
        } catch (Exception e){
        	System.out.println("swag");
        } finally {
            glfwTerminate();					// Terminate GLFW and free the GLFWErrorCallback
        }
    }
 
    public static void main(String[] args) {
    	new JustaVidGame().run();
    }
}