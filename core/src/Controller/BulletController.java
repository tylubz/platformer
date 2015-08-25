package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

import Model.Block;
import Model.Bullet;
import Model.DogEnemy;
import Model.World;
import View.BoomEffect;

public class BulletController {

	private World world;
	// Blocks that Bob can collide with any given frame
	private List<Block> collidable = new ArrayList<Block>();
	private List<Bullet> bullets;
	// = new ArrayList<Bullet>();
	private List<DogEnemy> listDog;


	private Pool<Rectangle> rectPool = new Pool<Rectangle>() {
		@Override
		protected Rectangle newObject() {
			return new Rectangle();
		}
	};

	public BulletController(World world) {
		this.world = world;
		this.listDog = world.getDog();
		this.bullets = world.getBullet();
	}

	public void moveBullets(float delta) {
		if (bullets.isEmpty()) {
			bullets = world.getBullet();
		} else {
			Iterator<Bullet> Bylletiterator = bullets.iterator();
			while (Bylletiterator.hasNext()) {

				Bullet bullet = Bylletiterator.next();
				bullet.getAcceleration().scl(delta);
				
				bullet.getPosition().x = bullet.getDirectionLeft() ? bullet.getPosition().x - 0.12f : bullet.getPosition().x + 0.12f;
				
				if(isCollisionWithEnemies(delta, bullet)){
					Bylletiterator.remove();
				}
				if (isCollisionWithBlocks(delta, bullet)) {
					Bylletiterator.remove();
				}
				bullet.getAcceleration().scl(1 / delta);
			}
		}
	}

	public void update(float delta) {
		for (Bullet bullet : bullets) {
			// bullet.getAcceleration().scl(delta);
			// bullet.getVelocity().add(bullet.getAcceleration().x,
			// bullet.getAcceleration().y);
			// checkCollisionWithEnemies(delta,bullet);
			bullet.update(delta);
		}
	}

	private boolean isCollisionWithEnemies(float delta, Bullet bullet) {
		if (listDog.isEmpty())
			return false;
		boolean collision = false;
		// scale velocity to frame units
		bullet.getVelocity().scl(delta);
		bullet.setBounds(bullet.getPosition().x,bullet.getPosition().y);
		/** if collision delete dog **/
		Iterator<DogEnemy> itr = listDog.iterator();
		while (itr.hasNext()) {
			DogEnemy dog = itr.next();
			//if (dog.getPosition().epsilonEquals(bullet.getPosition(), 0.12f)) {
			if(dog.getBounds().overlaps(bullet.getBounds())){
				collision = true;
				itr.remove();
				BoomEffect boom = world.getBoomEffect();
				boom.setPosition(bullet.getPosition());
				boom.setPosition(bullet.getPosition());
				boom.isCreated = true;

			}
		}
		// un-scale velocity (not in frame time)
		bullet.getVelocity().scl(1 / delta);
		return collision;

	}
	private boolean isCollisionWithBlocks(float delta, Bullet bullet) {
		boolean collision = false;
		// scale velocity to frame units
				bullet.getVelocity().scl(delta);
		collidable = world.getDrawableBlocks(10, 7);
		//System.out.println(collidable.size());
		bullet.setBounds(bullet.getPosition().x,bullet.getPosition().y);
		for (Block block : collidable) {
			if (block.doesHit(bullet.getBounds())){
				System.out.println(getClass().getName()+" Collsioan!");
				collision = true;
//				BoomEffect boom = world.getBoomEffect();
//				boom.setPosition(bullet.getPosition());
//				boom.setPosition(bullet.getPosition());
//				boom.isCreated = true;
				//world.g
			}
		}
		return collision;
		
	}

}
