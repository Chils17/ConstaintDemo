package com.webmyne.constaint.custom;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;



import java.util.regex.Pattern;

public class Functions {

    /**
     * The Progress loader.
     */
   // public static AppProgressLoader progressLoader;

    /**
     * This method is used to check is email is valid or not.
     *
     * @param email email of user
     * @return boolean that email is valid or not
     */
    public static boolean isValidEmailAddress(String email)
    {
        return Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}").matcher(email).matches();
    }
   // private static Gson gson;

    public static void fireIntent(Context context, Class cls) {
        Intent i = new Intent(context, cls);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public static void fireIntent(Activity baseActivity, Intent intent) {
        Activity activity = (Activity) baseActivity;
        baseActivity.startActivity(intent);
    }
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        return manufacturer + " " + model;
    }
    public static void fireIntent(Activity context) {
        context.finish();
    }
    public static void fireIntentForResult(Activity context, Class<?> cls, int requestCode) {

        Intent intent = new Intent(context, cls);
        context.startActivityForResult(intent, requestCode);
    }
    public static void fireIntentForResult(Activity context, Intent intent, int requestCode) {

        context.startActivityForResult(intent, requestCode);
    }
    public static void fireIntentWithClearFlag(Activity context, Class cls) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

    }

    public static void FunctionsfireIntentWithClearFlagWithWithPendingTransition(Activity context, Class cls) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        context.finish();
    }

    public static void fireIntentWithClearFlagWithWithPendingTransition(Activity context, Intent intent) {

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        context.finish();
    }
    public static void fireIntentWithClearFlagWithWithPendingTransition(Activity context, Class cls) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        context.finish();
    }

    public static void fireIntentWithData(Context context, Intent intent) {
        context.startActivity(intent);
        Activity activity = (Activity) context;
    }

    public static boolean checkNetworkConnection(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /*public static String jsonString(Object obj) {
        return "" + MyApplication.getGson().toJson(obj);
    }*/
    public static String toStingEditText(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static boolean isEmptyEditText(EditText editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }
    public static Typeface getFontType(Context _context, int typeValue) {

        Typeface typeface;

        if (typeValue == 1) {
            typeface = Typeface.createFromAsset(_context.getAssets(), "fonts/regular.ttf");

        } else if (typeValue == 2) {
            typeface = Typeface.createFromAsset(_context.getAssets(), "fonts/medium.ttf");

        } else if (typeValue == 3) {
            typeface = Typeface.createFromAsset(_context.getAssets(), "fonts/semibold.ttf");

        } else if (typeValue == 4) {
            typeface = Typeface.createFromAsset(_context.getAssets(), "fonts/bold.ttf");

        } else {
            typeface = Typeface.createFromAsset(_context.getAssets(), "fonts/regular.ttf");
        }

        return typeface;
    }

    public static void openPlayStore(Context context) {
        String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object

        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    /*public static void shareApp(Context context) {
        String appPackageName = context.getPackageName();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        //i.putExtra(Intent.EXTRA_TEXT, context.getResources().getString(R.string.share_text) + "\n" + "http://play.google.com/store/apps/details?id=" + appPackageName);
        i.putExtra(Intent.EXTRA_TEXT, context.getResources().getString(R.string.refer_code_for_libon) + "\n" + Preferences.getInstance(context).getString(Preferences.KEY_REFER_CODE));
        // i.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.share));
        context.startActivity(Intent.createChooser(i, "Share"));
    }*/

    public static void noInternet(final Context context) {
        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("No Internet Connection");
        dialog.setMessage("There is no internet connectivity. Turn on your data/wifi.");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
                ((Activity) context).finish();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
    /**
     *
     * @param object convert to json from object
     * @return
     */
   /* public static String getGson(Object object) {
        try {
            gson = new Gson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(object);
    }*/

   /* public static void loadImage(final Context context, String url, final ImageView imageView, final ProgressBar progressBar) {
        Glide.with(context).load(url)
                .fitCenter()
                .crossFade()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .error(R.drawable.no_image_placeholder)
                .crossFade()
                .into(imageView);
    }*/
    /**
     * common method to show progress dialog
     */
   /* public static void showProgress(Context context) {
        if (progressLoader != null) {
            try {
                if (progressLoader.isShowing()) {
                    progressLoader.dismiss();
                }
            } catch (Exception e) {
            }
        }
        progressLoader = new AppProgressLoader(context);
        progressLoader.show(context, null, false);
        progressLoader.getWindow().setGravity(Gravity.CENTER);
    }*/
    /**
     * common method to close progress dialog
     */
    /*public static void closeProgress() {
        try {
            if (progressLoader != null && progressLoader.isShowing()) {
                progressLoader.dismiss();
            }
        } catch (Exception e) {
        }
    }*/


}
