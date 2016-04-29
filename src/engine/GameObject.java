package engine;

import static org.lwjgl.opengl.GL30.*;

import Utility.Vector3f;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL11.*;

import graphics.VertexArrayObject;

public class GameObject {

	public int vaoID;
	public int count;
	public float SIZE = 1.0f;
	public Vector3f position;
	
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
	
	public GameObject(){
		this.count = indices.length;
		this.vao = new VertexArrayObject(this.vertices, this.indices);
		this.vaoID = vao.getvaoID();
		this.position = new Vector3f();
	}
	
	public void updatePosition(float x, float y, float z) {
		this.position.update(x, y, z);
	}
	
	public void addPosition(float x, float y, float z) {
		this.position.add(x, y, z);
		this.position.print();
	}
	
	public void draw(){
		glBindVertexArray(this.vaoID);
		glEnableVertexAttribArray(0);
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_BYTE, 0);
		glBindVertexArray(0);
	}
}
