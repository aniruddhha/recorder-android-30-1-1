package com.melayer.recorder;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private MediaRecorder recorder;
	private Button btnStart, btnStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		recorder.setOutputFile("/mnt/sdcard/a.3gp");

		btnStart = (Button) findViewById(R.id.btnStartRec);
		btnStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					recorder.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				recorder.start();
			}
		});

		btnStop = (Button) findViewById(R.id.btnStopRec);
		btnStop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				recorder.stop();
				//recorder.reset(); // You can reuse the object by going back to
									// setAudioSource() step
				recorder.release();
			}
		});
	}
}
