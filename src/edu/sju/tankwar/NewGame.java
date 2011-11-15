package edu.sju.tankwar;

import android.app.Activity;
import android.os.Bundle;

/**
 * @file NewGame.java
 * @brief activity when clicking the new button
 * @author 
 *  The team name Team F
 *  The principal author's name : Suhao Qin
 *  Acknowledgment of help from other team members, by name: n/a
 * @version 1.0
 */
public class NewGame extends Activity {
	/**
	 * oncreate for NewGame activity
	 * @param savedInstanceState savedInstanceState
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_layout);
		GameView gameView = (GameView) findViewById(R.id.tankwar);
		gameView.setFocusable(true);
	}
}
