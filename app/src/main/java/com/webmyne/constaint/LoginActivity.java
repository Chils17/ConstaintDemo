package com.webmyne.constaint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.webmyne.constaint.custom.Functions;
import com.webmyne.constaint.custom.TfButton;
import com.webmyne.constaint.custom.TfTextView;

public class LoginActivity extends AppCompatActivity {

    private TfTextView txtRegister;
    private TfButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (this.getIntent().hasExtra("item_id")) {
            // read the item id from the intent
            String itemId = this.getIntent().getStringExtra("item_id");

            // load the item associated with item id
            Log.i("MyTestApp", "Just deep linked with item id: " + itemId);
        }

        txtRegister = (TfTextView) findViewById(R.id.txtRegister);
        btnLogin = (TfButton) findViewById(R.id.btnLogin);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.fireIntent(getApplicationContext(), RegisterActivity.class);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.fireIntent(getApplicationContext(), ShopActivity.class);
            }
        });
    }
}
