package Model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {

	public static final float SIZE = 0.2f;
	
	Vector2 	position = new Vector2();
	Vector2 	acceleration = new Vector2();
	Vector2 	velocity = new Vector2();
	Rectangle 	bounds = new Rectangle();
	boolean bulletDirectionLeft;
	
	float		stateTime = 0;
	public boolean isBulletCreated=false; 
	
	public Bullet(Vector2 pos) {
		this.position = pos.cpy();
		this.bounds.setX(pos.x);
		this.bounds.setY(pos.y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
		isBulletCreated=true;
	}
	
	public Bullet(Vector2 pos,boolean bulletDirection) {
		this.position = pos.cpy();
//		this.bounds.x=position.x;
//		this.bounds.y=position.y;
		this.bounds.setX(pos.x);
		this.bounds.setY(pos.y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
		bulletDirectionLeft = bulletDirection;
		isBulletCreated=true;
		
	}

	public Vector2 getPosition() {
		return position;
	}
	
	
	public void setDirectionLeft(boolean direction){
		bulletDirectionLeft=direction;	
	}
	
	public boolean getDirectionLeft(){
		return bulletDirectionLeft ? true : false;
	}
	
	public Vector2 getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	
	
	public Rectangle getBounds() {
		return bounds;
	}
	public void setPosition(Vector2 pos) {
		this.position = pos;
	}

	public void setBounds(Rectangle bnd) {
		this.bounds = bnd;
	}
	
	public void setBounds(float x,float y) {
		this.bounds.x = x;
		this.bounds.y = y;
	}
	
	public void update(float delta) {
		stateTime += delta;
	}
}
