package com.almondach.machao.covigator.Options.DirectorySelector;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.almondach.machao.covigator.Configures;
import com.almondach.machao.covigator.R;

import java.io.File;
import java.util.LinkedList;

public class SelectDirActivity extends Activity implements DirPickerFragment.OnItemClickListener{

    DirPickerFragment dirPickerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dir_picker);
        FragmentManager fm = getFragmentManager();
        dirPickerFragment = (DirPickerFragment)fm.findFragmentById(R.id.fragment_dir_picker);
    }

    @Override
    public void OnItemClicked(int position){
        String selectedDir = DirContent.dirs.get(position).curDir;

        DirContent.Clear();
        DirContent.UpdateCurrentDirList(selectedDir);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dirPickerFragment.RefreshView();
            }
        });
    }

    @Override
    public void OnOkButtonClicked(){
        SharedPreferences preferences = getSharedPreferences(Configures.PreferenceFile,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Configures.CUR_DIR_KEY,DirContent.GetCurDir());
        editor.commit();
    }


    static public class SubDirsInfo{
        private static File[] files;
        private static int numOfFiles;
        private static StringBuilder filesSb;
        private static LinkedList<String> dirs = new LinkedList<String>();

        static public void Reset(){
            numOfFiles = 0;
            filesSb = new StringBuilder();
            dirs.clear();
        }

        static private void HandleNewFile(File file,int numOfRequiredFiles){
            if (numOfFiles > numOfRequiredFiles)
            {
                return;
            }
            numOfFiles++;
            filesSb.append(file.getName() + " ");
        }

        static private void HandleNewDir(File dir){
            dirs.add(dir.getName());
        }


        static public String GetSubFilesInfo(String path,int numOfRequiredFiles){
            Reset();
            File curDir = new File(path);
            files = curDir.listFiles();

            for (File subFile:files){
                if (subFile.isFile()){
                    HandleNewFile(subFile,numOfRequiredFiles);
                }
            }

            return filesSb.toString();
        }

        static public LinkedList<String> GetSubDirs(String path){
            Reset();
            File curDir = new File(path);
            files = curDir.listFiles();

            for (File subFile:files){
                if (subFile.isDirectory()){
                    HandleNewDir(subFile);
                }
            }

            return dirs;
        }

    }

}
