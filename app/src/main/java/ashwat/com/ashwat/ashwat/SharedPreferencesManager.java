package ashwat.com.ashwat.ashwat;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager();
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static final String NAME = "General";

    public static SharedPreferencesManager getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(NAME, Activity.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
        return sharedPreferencesManager;
    }

    public void start(){
        editor.putInt("Counter", 1).commit();
    }

    public void end(){
        editor.putInt("Counter", 0).commit();
    }

    public void increment(){
        editor.putInt("Counter", sharedPreferences.getInt("Counter", 0)+1).commit();

    }

    public int getResult(){
        return sharedPreferences.getInt("Counter", 0);

    }




}
