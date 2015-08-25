package View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class FontAsset {
	public BitmapFont font;
	private TextureAtlas atlas;
	
	public FontAsset(){
		load();
		//font = new BitmapFont(Gdx.files.internal("images/fonts/text.fnt"));
		//font = new BitmapFont(Gdx.files.internal("images/fon/text.fnt"));
	
		//font.setScale(.25f, -.25f);
//		shadow = new BitmapFont(Gdx.files.internal("images/fonts/shadow.fnt"));
//		shadow.setScale(.25f, -.25f);
	}
	public void load(){
		atlas = new TextureAtlas(Gdx.files.internal("images/textures/textures.pack"));
		
	}
	

	public static void main(String[] args) {
		FontAsset  q = new FontAsset();
		// TODO Auto-generated method stub

	}

}
