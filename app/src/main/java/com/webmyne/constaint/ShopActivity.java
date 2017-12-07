package com.webmyne.constaint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.webmyne.constaint.adapter.ShopCategoryAdapter;
import com.webmyne.constaint.custom.TfEditText;
import com.webmyne.constaint.custom.TfTextView;
import com.webmyne.constaint.model.CategoryBuy;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    private ShopActivity context;
    private TfTextView txtAlert;
    private RecyclerView rvShop;
    private TfEditText edtSearch;
    private ArrayList<CategoryBuy> categoryBuyList;
    private ShopCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        init();
        initRecyclerView();
        actionListener();
    }

    private void init() {
        context = this;
        txtAlert = (TfTextView) findViewById(R.id.txtAlert);
        rvShop = (RecyclerView) findViewById(R.id.rvShop);
        edtSearch = (TfEditText) findViewById(R.id.edtSearch);
    }

    private void initRecyclerView() {

        categoryBuyList = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            CategoryBuy categoryBuy = new CategoryBuy();
            categoryBuy.setCategoryID("1");
            categoryBuy.setCategoryName("Art and Painting");
            categoryBuyList.add(categoryBuy);
        }

        adapter = new ShopCategoryAdapter(context, categoryBuyList);
        rvShop.setAdapter(adapter);
        rvShop.setLayoutManager(new LinearLayoutManager(context));
    }


    private void actionListener() {
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (adapter == null)
                    return;

                if (s.toString().trim().length() > 0) {
                    adapter.getFilter().filter(s.toString());
                } else {
                    adapter.setDataList(categoryBuyList);
                }
                if (adapter.getItemCount() < 1) {
                    rvShop.setVisibility(View.GONE);
                    txtAlert.setVisibility(View.VISIBLE);
                } else {
                    rvShop.setVisibility(View.VISIBLE);
                    txtAlert.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
