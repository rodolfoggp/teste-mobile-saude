package rodolfogusson.testemobilesaude.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;

import rodolfogusson.testemobilesaude.R;

/**
 * Class that has some utilities methods to show or manipulate some UI elements on screen.
 */
public class UIUtil {

    /**
     * Gets the root view, given the current {@code activity} and shows a snackbar containing the desired
     * {@code message}.
     * @param activity Current activity.
     * @param message Desired message to show on snackbar.
     */
    public static void showSnackbar(Activity activity, String message){
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Shows a more precise error, depending on the phone status.
     * @param activity Current activity.
     */
    public static void showError(Activity activity){
        String message;
        if(!CommUtil.isNetworkAvailable(activity)){
            message = activity.getString(R.string.error_no_network);
        } else {
            message = activity.getString(R.string.error_unexpected);
        }
        UIUtil.showSnackbar(activity, message);
    }

    /**
     * Formats an array of Strings {@code categories} to a single String.
     * @param categories Array of news categories.
     * @return A single string, with all the categories, separated by commas.
     */
    public static String getCategoriesText(String[] categories){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < categories.length; i++){
            if(i >= 1){
                builder.append(", ");
            }
            builder.append(categories[i]);
        }
        return builder.toString();
    }
}
