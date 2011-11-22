package edu.sju.tankwar;

import android.app.Activity;
import android.os.Bundle;
import android.content.*;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Description: activity for first launched view
 * 
 * @file TankWarGameAndroidActivity.java
 * @author The team name Team F The principal author's name : Xiaohui Liu
 *         Acknowledgment of help from other team members, by name: n/a
 * @version 1.0
 */

public class TankWarGameAndroidActivity extends Activity implements OnClickListener {
	/**
	 * @param savedInstanceState
	 *            savedInstanceState Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); // content display/view of the layout
		// for new game button
		View newButton = findViewById(R.id.new_button);
		newButton.setOnClickListener(this);
		// about button
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		// help button
		View helpButton = findViewById(R.id.help_button);
		helpButton.setOnClickListener(this);

	}

	/**
	 * method to invoke click action
	 * 
	 * @param v
	 *            view
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.about_button: // when clicking about button
			Intent i1 = new Intent(this, About.class);
			startActivity(i1); // to start the activity for about page
			break;
		case R.id.help_button: // when clicking help button
			Intent i2 = new Intent(this, Help.class);
			startActivity(i2); // to start the activity for help page
			break;
		case R.id.new_button: // when clicking new game button
			Intent i3 = new Intent(this, NewGame.class);
			startActivity(i3);// start the game panel
			break;
		}

	}

}