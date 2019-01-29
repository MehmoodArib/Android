package com.example.mehmood.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

public class Info extends AppCompatActivity {
    private TextView email;
    private TextView fname;
    private ProfilePictureView profilePictureView;
    private JSONObject json_object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        email = findViewById(R.id.email);
        fname = findViewById(R.id.f_name);
        profilePictureView = findViewById(R.id.image);
        try {
            json_object = new JSONObject(getIntent().getStringExtra("ITEM_EXTRA"));
            email.setText(json_object.get("email").toString());
            fname.setText(json_object.get("first_name").toString());
            profilePictureView.setProfileId(json_object.get("id").toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
