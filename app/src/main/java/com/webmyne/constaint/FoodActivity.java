package com.webmyne.constaint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.webmyne.constaint.custom.TfEditText;


public class FoodActivity extends AppCompatActivity {

    private TfEditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        init();
        actionListener();

    }

    private void init() {
        edtSearch = (TfEditText) findViewById(R.id.edtSearch);

        final float radius = 20;

        /*final View decorView = getWindow().getDecorView();
        //Activity's root View. Can also be root View of your layout (preferably)
        final ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        //set background, if your root layout doesn't have one
        final Drawable windowBackground = decorView.getBackground();*/

       /* blurView.setupWith(rootView)
                .windowBackground(windowBackground)
                .blurAlgorithm(new RenderScriptBlur(this))
                .blurRadius(radius);*/
    }

    private void actionListener() {
    }


}
