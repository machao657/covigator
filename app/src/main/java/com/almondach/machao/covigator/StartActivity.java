package com.almondach.machao.covigator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.almondach.machao.covigator.Options.DirectorySelector.SelectDirActivity;


public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (NeedToSelectDir()){
            StartDirPicker();
        }
        else {
            StartEditor();
        }
    }

    private void StartDirPicker(){
        Intent intent = new Intent(this, SelectDirActivity.class);
        startActivity(intent);
    }

    private void StartEditor(){

    }

    private boolean NeedToSelectDir(){
        SharedPreferences preferences = getSharedPreferences(Configures.PreferenceFile,0);
        String workingDir = preferences.getString(Configures.CUR_DIR_KEY,Configures.BLANK_STR);
        if (workingDir.equals(Configures.BLANK_STR)){
            return true;
        }
        return false;
    }

}
