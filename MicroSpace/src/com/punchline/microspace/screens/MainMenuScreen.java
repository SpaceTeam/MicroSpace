package com.punchline.microspace.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.punchline.javalib.BaseGame;
import com.punchline.javalib.states.screens.MenuScreen;
import com.punchline.microspace.Worlds;

/**
 * Base class for a game's Main Menu screen.
 * @author Nathaniel
 * @created Jul 24, 2013
 */
public class MainMenuScreen extends MenuScreen {
	
	/**
	 * Makes a MainMenuScreen.
	 * @param game The game.
	 * @param skinHandle A FileHandle pointing to the menu's skin.
	 * @param textureHandle A FileHandle pointing to the background texture.
	 */
	public MainMenuScreen(BaseGame game) {
		super(game, Gdx.files.internal("data/Skin/uiskin.json"), "Micro Space", null);
	}

	@Override
	protected void initialize() {
		
		super.initialize();
		
		Button playButton = new TextButton("Play Game", skin);
		Button settingsButton = new TextButton("Settings", skin);
		Button quitButton = new TextButton("Quit", skin);
		
		//TODO: Add buttons events.
		playButton.addListener(new ClickListener() {
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				onPlayGamePressed();
			}
			
		});
		
		settingsButton.addListener(new ClickListener() {
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				onSettingsPressed();
			}
			
		});
		
		quitButton.addListener(new ClickListener() {
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				onQuitPressed();
			}
			
		});
		
		window.add(playButton);
		window.row();
		window.add(settingsButton);
		window.row();
		window.add(quitButton);
		window.row();
		
	}
	
	/**
	 * Called when the Play Game button is pressed.
	 */
	private void onPlayGamePressed() {
		game.setScreen(new GameplayScreen(game));
	}
	
	/**
	 * Called when the Settings button is pressed.
	 */
	private void onSettingsPressed() {
		
	}
	
	/**
	 * Called when the Quit button is pressed.
	 */
	private void onQuitPressed() {
		Worlds.dispose(); //TODO Find another way
		Gdx.app.exit();
	}
	
}