package Utility;

public class Vector3f {
	public float x, y, z;
	
	public Vector3f(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Vector3f(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public float getZ() {
		return this.z;
	}
	
	public void update(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void add(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void multScalar(float s) {
		this.x *= s;
		this.y *= s;
		this.z *= s;
	}
	
	public void multVector(Vector3f v) {
		this.x *= v.getX();
		this.y *= v.getY();
		this.z *= v.getZ();
	}
	
	public void print() {
		System.out.println(this);
	}
	
	public String toString() {
		String s = "X: " + this.x + "\n"
				+ "Y: " + this.y + "\n"
				+ "Z: " + this.z + "\n";
		
		return s;	
	}
}
