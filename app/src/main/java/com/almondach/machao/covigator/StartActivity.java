package com.almondach.machao.covigator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.almondach.machao.covigator.Options.DirectorySelector.SelectDirActivity;
import com.almondach.machao.covigator.Editor.EditorActivity;


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
        Intent intent = new Intent(this, EditorActivity.class);
        startActivity(intent);
    }

    private boolean NeedToSelectDir(){
        SharedPreferences preferences = getSharedPreferences(Configures.PreferenceFile,0);
        String workingDir = preferences.getString(Configures.CUR_DIR_KEY,Configures.BLANK_STR);
        Configures.currentWorkingDirectory = workingDir;
        if (workingDir.equals(Configures.BLANK_STR)){
            return true;
        }
        return false;
    }

}
