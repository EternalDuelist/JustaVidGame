package engine;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL11.*;

import graphics.VertexArrayObject;

public class VisibleGameObject {

	public int vaoID;
	public int count;
	public float SIZE = 1.0f;
	
	public float[] vertices = {
			-0.25f, 0.25f, 0f,
			-0.25f, -0.25f, 0f,
			0.25f, -0.25f, 0f,
			0.25f, 0.25f, 0f
	};
	
	public byte[] indices = new byte[] {
		0, 1, 2,
		2, 3, 0
	};
	
	private VertexArrayObject vao;
	
	public VisibleGameObject(int vaoID){
		this.vaoID = vaoID;
		this.count = indices.length;
		this.vao = new VertexArrayObject(this.vertices, this.indices);		
	}
	
	public void draw(){
		glBindVertexArray(this.vaoID);
		glEnableVertexAttribArray(0);
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_BYTE, 0);
		glBindVertexArray(0);
	}
}
