package com.webmyne.constaint.model;

import java.io.Serializable;

/**
 * Created by Chiragpatel on 08-09-2017.
 */

public class CategoryBuy implements Serializable {
    /**
     * CategoryID : 12
     * CategoryName : ART And Craft
     */

    private String CategoryID;
    private String CategoryName;

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
}
