package View;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BoomEffect {
	
	public static final float SIZE = 1.5f;
	
	Rectangle 	bounds = new Rectangle();
	
	Vector2 position = new Vector2();
	SpriteBatch spriteBatch;
	private Animation boomEffectAnimation;
	private TextureRegion[] boomEffectTextureRegion;
	public  TextureRegion textureRegion;
	public boolean isCreated = false;
	public BoomEffect(){
		//isCreated = true;
		loadTextures();
		
	}
	public BoomEffect(Vector2 pos){
		//isCreated = true;
		this.position = pos;
		this.bounds.x = pos.x;
		this.bounds.y = pos.y;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		loadTextures();
		
	}
	
	private void loadTextures() {
		TextureAtlas atlas = new TextureAtlas(
				Gdx.files.internal("images/flash/packName.atlas"));
		boomEffectTextureRegion = new TextureRegion[4];
		boomEffectTextureRegion[0] = atlas.findRegion("flash1");
		boomEffectTextureRegion[1] = atlas.findRegion("flash2");
		boomEffectTextureRegion[2] = atlas.findRegion("flash3");
		boomEffectTextureRegion[3] = atlas.findRegion("flash4");
		boomEffectAnimation = new Animation(0.2f, boomEffectTextureRegion);
		textureRegion = boomEffectAnimation.getKeyFrame(1f, false);
	}
	
	public TextureRegion[] getTextureRegion(){
		return boomEffectTextureRegion;
	}
	public boolean isBoom(){
		if (isCreated==true){
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  isCreated=false;
				  }
				}, 500);
		}
		return isCreated;
	}
	public void setPosition(Vector2 pos){
		this.position = pos;
	}
	public Vector2 getPosition(){
		return position;
	}
	public Rectangle getBounds(){
		return bounds;
	}
	public void setBounds(Vector2 pos){
		this.bounds.x = pos.x;
		this.bounds.y = pos.y;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}
	
}
