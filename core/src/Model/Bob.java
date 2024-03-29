package Model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bob {

	public enum State {
		IDLE, WALKING, JUMPING, DYING
	}
	
	public static final float SIZE = 0.5f; // half a unit

	Vector2 	position = new Vector2();
	Vector2 	acceleration = new Vector2();
	Vector2 	velocity = new Vector2();
	Rectangle 	bounds = new Rectangle();
	State		state = State.IDLE;
	boolean		facingLeft = true;
	float		stateTime = 0;
	boolean		longJump = false;

	public Bob(Vector2 position) {
		this.position = position;
		this.bounds.x = position.x;
		this.bounds.y = position.y;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}

	
	public boolean isFacingLeft() {
		return facingLeft;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public State getState() {
		return state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}
	
	public boolean isDying(){
		return this.state == State.DYING;
	}

	public float getStateTime() {
		return stateTime;
	}

	public boolean isLongJump() {
		return longJump;
	}


	public void setLongJump(boolean longJump) {
		this.longJump = longJump;
	}


	public void setPosition(Vector2 position) {
		this.position = position;
		this.bounds.setX(position.x);
		this.bounds.setY(position.y);
	}


	public void setAcceleration(Vector2 acceleration) {
		if(!isDying()){
		this.acceleration = acceleration;
		}
	}


	public void setVelocity(Vector2 velocity) {
		if(!isDying()){
		this.velocity = velocity;
		}
	}


	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}


	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}


	public void update(float delta) {
		//position.add(velocity.cpy().scl(delta));
		//bounds.x = position.x;
		//bounds.y = position.y;
		stateTime += delta;
	}
	
}
