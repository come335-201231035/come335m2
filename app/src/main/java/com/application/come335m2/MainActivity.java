package com.application.come335m2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {



    private static final int PERMISSION_ACCESS_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ACCESS_FINE_LOCATION);
        }

        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Intent i = new Intent(getApplicationContext(), PlacePickerActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Uygulamanın lokasyon hizmetini açmanız gerekmektedir!", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onClick(View view) {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Intent i = new Intent(getApplicationContext(), PlacePickerActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Uygulamanın lokasyon hizmetini açmanız gerekmektedir!", Toast.LENGTH_LONG).show();
        }
    }
}
