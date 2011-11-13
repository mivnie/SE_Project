package edu.sju.tankwar;

import android.app.Activity;
import android.os.Bundle;
import android.content.*;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author team_f
 * 
 */
public class FirstAndroidActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		View newButton = findViewById(R.id.new_button);
		newButton.setOnClickListener(this);

		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);

		View helpButton = findViewById(R.id.help_button);
		helpButton.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.about_button:
			Intent i1 = new Intent(this, About.class);
			startActivity(i1);
			break;
		case R.id.help_button:
			Intent i2 = new Intent(this, Help.class);
			startActivity(i2);
			break;
		case R.id.new_button:
			Intent i3 = new Intent(FirstAndroidActivity.this, NewGame.class);
			startActivity(i3);
			break;
		}

	}

}