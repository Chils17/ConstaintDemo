package com.webmyne.constaint.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.webmyne.constaint.R;
import com.webmyne.constaint.custom.TfTextView;
import com.webmyne.constaint.model.CategoryBuy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chiragpatel on 08-09-2017.
 */

public class ShopCategoryAdapter extends RecyclerView.Adapter<ShopCategoryAdapter.MyViewHolder> implements Filterable {
    private Activity activity;
    private List<CategoryBuy> categoryBuyList;
    private List<CategoryBuy> originalData = null;
    private ItemFilter mFilter = new ItemFilter();

    public ShopCategoryAdapter(Activity activity, List<CategoryBuy> categoryBuyList) {
        this.activity = activity;
        this.categoryBuyList = categoryBuyList;
        originalData = categoryBuyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.shop_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopCategoryAdapter.MyViewHolder holder, int position) {
        holder.setValues(categoryBuyList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryBuyList.size();
    }


    public void setDataList(List<CategoryBuy> data) {
        categoryBuyList = new ArrayList<>();
        categoryBuyList = data;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TfTextView txtName;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtName = (TfTextView) itemView.findViewById(R.id.txtName);
        }

        public void setValues(CategoryBuy categoryBuy) {
            categoryBuy.getCategoryID();
            txtName.setText(categoryBuy.getCategoryName());
            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* Intent intent = new Intent(activity, ProductListActivity.class);
                    intent.putExtra(activity.IS_FROM, categoryBuy.getCategoryName());
                    intent.putExtra(activity.CATEGORY_ID, categoryBuy.getCategoryID());
                    Functions.fireIntent(activity, intent);
                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);*/
                }
            });
        }
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final ArrayList<CategoryBuy> list = (ArrayList<CategoryBuy>) originalData;

            int count = list.size();
            final ArrayList<CategoryBuy> nlist = new ArrayList<>(count);

            String filterableString;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).getCategoryName();
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(list.get(i));
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            categoryBuyList = (ArrayList<CategoryBuy>) results.values;
            notifyDataSetChanged();
        }
    }
}
