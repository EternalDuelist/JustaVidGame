package graphics;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;

import static graphics.GUtilities.*;

public class VertexArrayObject {

	private static final int VERTEX_ATTRIB = 0;
	private static final int TCOORD_ATTRIB = 1;
	
	public VertexArrayObject(float[] vertices, byte[] indices){
		createArrayObject(vertices, indices);
	}
	
	private void createArrayObject(float[] vertices, byte[] indices){
		int vao = glGenVertexArrays();
		glBindVertexArray(vao);
		
		createVericesBuffer(vertices);
		createIndicesBuffer(indices);
		
		glBindVertexArray(0);
	}

	private void createIndicesBuffer(byte[] indices) {
		int iboID = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, iboID);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, createByteBuffer(indices), GL_STATIC_DRAW);
	}

	private void createVericesBuffer(float[] vertices) {
		int vboID = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboID);
		glBufferData(GL_ARRAY_BUFFER, createFloatBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(VERTEX_ATTRIB, 3, GL_FLOAT, false, 0, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
}
