package com.webmyne.constaint;

import android.content.Intent;
import android.net.LinkProperties;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.webmyne.constaint.custom.Functions;

import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private Button btnOk;
    private Button btnSubmit;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this);
        // Initialize Branch automatic session tracking
        Branch.getAutoInstance(this);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.fireIntent(getApplicationContext(),LoginActivity.class);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.fireIntent(getApplicationContext(),CircleLoginActivity.class);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.fireIntent(getApplicationContext(),FoodActivity.class);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Branch branch = Branch.getInstance();
        branch.initSession(new Branch.BranchUniversalReferralInitListener() {
            @Override
            public void onInitFinished(BranchUniversalObject branchUniversalObject, io.branch.referral.util.LinkProperties linkProperties, BranchError error) {
                if (error == null && branchUniversalObject != null) {
                    // This code will execute when your app is opened from a Branch deep link, which
                    // means that you can route to a custom activity depending on what they clicked.
                    // In this example, we'll just print out the data from the link that was clicked.

                    Log.i("BranchTestBed", "referring Branch Universal Object: " + branchUniversalObject.toString());

                    // check if the item is contained in the metadata
                    if (branchUniversalObject.getMetadata().containsKey("item_id")) {
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        i.putExtra("picture_id", branchUniversalObject.getMetadata().get("item_id"));
                        startActivity(i);
                    }
                }
            }
        }, this.getIntent().getData(), this);
    }
}
