package com.webmyne.constaint.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.webmyne.constaint.R;


/**
 * Created by raghavthakkar on 22-11-2016.
 */

public class TfEditTextSimple extends AppCompatEditText {

    private final String TAG = getClass().getName();
    private Context _ctx;
    private boolean isBold;
    private int fTypeValue = 0;

    public TfEditTextSimple(Context context) {
        super(context);
        if (!isInEditMode()) {
            this._ctx = context;
            init();
        }
    }
    public TfEditTextSimple(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TfEditTextSimple, 0, 0);
            try {
                isBold = a.getBoolean(R.styleable.TfEditTextSimple_isBoldEditText, false);

                if (a.hasValue(R.styleable.TfEditTextSimple_fEdittype)) {
                    fTypeValue = a.getInt(R.styleable.TfEditTextSimple_fEdittype, 0);
                }

            } finally {
                a.recycle();
            }

            this._ctx = context;
            init();
        }
    }
    private void init() {
        try {
            setTypeface(Functions.getFontType(getContext(), fTypeValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
