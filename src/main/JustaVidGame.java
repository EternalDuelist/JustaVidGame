package main;
import org.lwjgl.glfw.*;

import window.InputManager;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;
 
public class JustaVidGame {
    // We need to strongly reference callback instances.
    private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback   keyCallback;
    private long window;	// The window handle
 
    public void run() {
        try {
            init();
            loop();
            glfwDestroyWindow(window);	// Destroy window and window callbacks
        } finally {
            glfwTerminate();			// Terminate GLFW and free the GLFWErrorCallback
        }
    }
 
    private void init() {
    	int WIDTH = 640, HEIGHT = 480;
    	
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));
 
        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( glfwInit() != GLFW_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");
 
        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "JustaVid Game", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
 
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, keyCallback = new InputManager());
 
        // Get the resolution of the primary monitor
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        // Center our window
        glfwSetWindowPos(window, (vidmode.width() - WIDTH) / 2, (vidmode.height() - HEIGHT) / 2);

        glfwMakeContextCurrent(window);		// Make the OpenGL context current

        glfwSwapInterval(1);				// Enable v-sync. Also sets the frame rate to 60fps?
        glfwShowWindow(window);				// Make the window visible
    }
 
    private void loop() {
    	
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while (glfwWindowShouldClose(window) == GLFW_FALSE) {
 
            glfwSwapBuffers(window);								// draws on the screen at a frame rate specified in init
            glfwPollEvents();										// checks for user input and takes an action based on the key callback
        }
    }
 
    public static void main(String[] args) {
        new JustaVidGame().run();
    }
}