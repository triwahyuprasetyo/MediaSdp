package com.why.mediasdp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonWeb, buttonTelp, buttonKamera, buttonMp3, buttonVideo, buttonSMS,
            buttonPeta, buttonActivity, buttonAlertDialog, buttonWhatsApp,
            buttonFacebook, buttonTwitter, buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        buttonWeb = (Button) findViewById(R.id.buttonWeb);
        buttonTelp = (Button) findViewById(R.id.buttonTelp);
        buttonKamera = (Button) findViewById(R.id.buttonKamera);
        buttonMp3 = (Button) findViewById(R.id.buttonMp3);
        buttonVideo = (Button) findViewById(R.id.buttonVideo);
        buttonSMS = (Button) findViewById(R.id.buttonSms);
        buttonPeta = (Button) findViewById(R.id.buttonPeta);
        buttonActivity = (Button) findViewById(R.id.buttonActivity);
        buttonAlertDialog = (Button) findViewById(R.id.buttonAlertDialog);
        buttonWhatsApp = (Button) findViewById(R.id.buttonWhatsApp);
        buttonFacebook = (Button) findViewById(R.id.buttonFacebook);
        buttonTwitter = (Button) findViewById(R.id.buttonTwitter);
        buttonExit = (Button) findViewById(R.id.buttonExit);

        buttonWeb.setOnClickListener(this);
        buttonTelp.setOnClickListener(this);
        buttonKamera.setOnClickListener(this);
        buttonMp3.setOnClickListener(this);
        buttonVideo.setOnClickListener(this);
        buttonSMS.setOnClickListener(this);
        buttonPeta.setOnClickListener(this);
        buttonActivity.setOnClickListener(this);
        buttonAlertDialog.setOnClickListener(this);
        buttonWhatsApp.setOnClickListener(this);
        buttonFacebook.setOnClickListener(this);
        buttonTwitter.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonWeb.getId()) {
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sebangsa.com"));
            startActivity(intentWeb);
        } else if (view.getId() == buttonTelp.getId()) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (getApplicationContext().checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intentTelp = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0274373737"));
                    startActivity(intentTelp);
                }
            } else {
                Intent intentTelp = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0274373737"));
                startActivity(intentTelp);
            }
        } else if (view.getId() == buttonKamera.getId()) {
            Intent intentKamera = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intentKamera, 0);
        } else if (view.getId() == buttonMp3.getId()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri
                            .parse("file:///mnt/sdcard/06 Seize The Day.mp3"),
                    "audio/mpeg3");
            startActivity(intent);
        } else if (view.getId() == buttonVideo.getId()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("file:///mnt/sdcard/The Beatles - Please Please Me..mp4"));
            intent.setDataAndType(Uri.parse("file:///mnt/sdcard/The Beatles - Please Please Me..mp4"), "video/mp4");
            startActivity(intent);
        } else if (view.getId() == buttonSMS.getId()) {
            Uri uri = Uri.parse("smsto:08995362814");
            Intent intentSMS = new Intent(Intent.ACTION_SENDTO, uri);
            intentSMS.putExtra("sms body", "Test Intent SMS");
            startActivity(intentSMS);
        } else if (view.getId() == buttonPeta.getId()) {

        } else if (view.getId() == buttonActivity.getId()) {
            Intent intentActivity = new Intent(MainActivity.this, NextActivity.class);
            startActivity(intentActivity);
        } else if (view.getId() == buttonAlertDialog.getId()) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Delete entry")
                    .setMessage("Are you sure you want to delete this entry?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                            Toast.makeText(getApplicationContext(), "Positive", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                            Toast.makeText(getApplicationContext(), "Negative", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (view.getId() == buttonWhatsApp.getId()) {

        } else if (view.getId() == buttonFacebook.getId()) {

        } else if (view.getId() == buttonTwitter.getId()) {

        } else if (view.getId() == buttonExit.getId()) {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
