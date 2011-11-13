/**
 * 
 */
package edu.sju.tankwar;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author team_f
 * 
 */
// activity when clicking the new button
public class NewGame extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_layout);
		GameView gameView = (GameView) findViewById(R.id.tankwar);
		gameView.setFocusable(true);
	}
}
