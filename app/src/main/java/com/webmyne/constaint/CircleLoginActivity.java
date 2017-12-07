package com.webmyne.constaint;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.webmyne.constaint.custom.FlipViewController;


public class CircleLoginActivity extends AppCompatActivity {
    private FlipViewController flipView;

    /*private TfTextView txtSignUp;
    private TfTextView txtLogin;
    private LinearLayout lvLogin;
    private LinearLayout lvSignUp;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_login);

        init();
        clickListener();
    }

    private void init() {
        /*lvLogin = (LinearLayout) findViewById(R.id.lvLogin);
        lvSignUp = (LinearLayout) findViewById(R.id.lvSignUp);
        txtSignUp = (TfTextView) findViewById(R.id.txtSignUp);
        txtLogin = (TfTextView) findViewById(R.id.txtLogin);*/

        flipView = new FlipViewController(this,FlipViewController.HORIZONTAL);

        flipView.setAdapter(new MyBaseAdapter(this));

        setContentView(flipView);
    }



    private void clickListener() {

       /* txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCard();

            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCard();
            }
        });*/

    }

    private void flipCard() {

       /* FlipAnimation flipAnimation = new FlipAnimation(lvLogin, lvSignUp);

        if (lvLogin.getVisibility() == View.GONE) {
            flipAnimation.reverse();
        }
        lvLogin.startAnimation(flipAnimation);*/
    }

    private static class MyBaseAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        private MyBaseAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (i == 0) {
                return inflater.inflate(R.layout.item_signin, null);
            } else {
                return inflater.inflate(R.layout.item_signup, null);
            }
        }

    }
}
