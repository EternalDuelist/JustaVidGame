package graphics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Utility.Vector3f;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL11.*;

public class Shaders {
	
	private int programID;
	private int vertexShaderID;
	private int fragmentShaderID;
	
	public Shaders(String vertexFile, String fragmentFile){
		try {
			this.vertexShaderID = loadShader(vertexFile, GL_VERTEX_SHADER);
			this.fragmentShaderID = loadShader(fragmentFile, GL_FRAGMENT_SHADER);
		
			this.programID = glCreateProgram();
			
			glAttachShader(programID, vertexShaderID);
			glAttachShader(programID, fragmentShaderID);
			
			glLinkProgram(programID);
			glValidateProgram(programID);
			
		} catch (Exception e){
			System.out.println("double swag");
		}
	}
	
	public int getID(){
		return this.programID;
	}
	
	public int loadShader(String filepath, int type){
		StringBuilder result = new StringBuilder();
		BufferedReader reader;
		String buffer = "";
		int shaderID;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			while((buffer = reader.readLine()) != null) {
				result.append(buffer);
				result.append("\n");
			}
			System.out.println(result);
		} catch(IOException e){
			System.err.println(e);
		}
		shaderID = glCreateShader(type);
		glShaderSource(shaderID, result.toString());
		glCompileShader(shaderID);
		if(glGetShaderi(shaderID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println(glGetShaderInfoLog(shaderID, 500));
			System.err.println("Could not compile shader");
			System.err.println(-1);
		}
		return shaderID;
	}
	public int getUniform(String name){
		int result = glGetUniformLocation(programID, name);
		if(result == -1) {
			System.err.println("Could not find uniform variable" + name);
		}
		return result;
	}
	
	public void setUniform3f(String name, Vector3f position) {
		glUniform3f(getUniform(name), position.x, position.y, position.z);
	}
	
	public void start(){
		glUseProgram(programID);
	}
	
	public void stop(){
		glUseProgram(0);
	}

}
