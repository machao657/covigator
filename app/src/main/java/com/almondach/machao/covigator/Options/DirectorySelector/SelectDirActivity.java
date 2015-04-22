package com.almondach.machao.covigator.Options.DirectorySelector;

import android.app.Activity;

import android.app.FragmentManager;


import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;


import com.almondach.machao.covigator.Configures;
import com.almondach.machao.covigator.Editor.EditorActivity;
import com.almondach.machao.covigator.R;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class SelectDirActivity extends Activity implements DirPickerFragment.OnItemClickListener{

    static DirContent dirContent = new DirContent();
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
        if (!dirContent.isDir(position)){
            return;
        }
        String selectedDir = dirContent.GetAbsPath(position);
        dirContent.UpdateCurrentDirList(selectedDir);
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

        String workingDir = dirContent.GetCurDir();
        editor.putString(Configures.CUR_DIR_KEY,workingDir);
        Configures.currentWorkingDirectory = workingDir;
        editor.commit();
        StartPrimaryActivity();
    }

    private void StartPrimaryActivity(){
        Intent intent = new Intent(this, EditorActivity.class);
        startActivity(intent);
    }

    static public class SubDirsInfo{
        private static int numOfFiles;
        private static LinkedList<String> files;
        private static LinkedList<String> dirs = new LinkedList<String>();

        static public void Reset(){
            numOfFiles = 0;
            files = new LinkedList<String>();
            dirs.clear();
        }

        static private void HandleNewFile(File file){
            numOfFiles++;
            files.add(file.getName());
        }

        static private void HandleNewDir(File dir){
            dirs.add(dir.getName());
        }


        static public LinkedList<String> GetSubFiles(String path){
            Reset();
            File curDir = new File(path);
            File[] fileArr= curDir.listFiles();

            for (File subFile: fileArr){
                if (subFile.isFile()){
                    HandleNewFile(subFile);
                }
            }

            return files;
        }

        static public LinkedList<String> GetSubDirs(String path){
            Reset();
            File curDir = new File(path);
            File[] filesArr = curDir.listFiles();

            for (File subFile:filesArr){
                if (subFile.isDirectory()){
                    HandleNewDir(subFile);
                }
            }

            return dirs;
        }

        static public ArrayList<DirContent.FileDirPath> GetSubItems(String path){
           return GetSubItemsWithExtra(path,0);
        }

        static public ArrayList<DirContent.FileDirPath> GetSubItemsWithExtra(String path,int numExtra){
            File curDir = new File(path);
            File[] subFiles = curDir.listFiles();

            if (subFiles == null){
                return HandleEmptyDir(numExtra);
            }

            int numTotalItems = numExtra + subFiles.length;
            ArrayList<DirContent.FileDirPath> subItems = new ArrayList<>(numTotalItems);
            FillWithNullElements(subItems,numExtra);

            int pos = numExtra;
            for (File file:subFiles){
                subItems.add(pos,new DirContent.FileDirPath(file.getAbsolutePath()
                        ,file.getName(),file.isFile()));
                pos++;
            }

            return subItems;
        }

        static private void FillWithNullElements(ArrayList<DirContent.FileDirPath> list, int num){
            for (int n=0;n<num;n++){
                list.add(null);
            }
        }

        static ArrayList<DirContent.FileDirPath> HandleEmptyDir(int extraNullElements){
            ArrayList<DirContent.FileDirPath> subItems = new ArrayList<>(extraNullElements);
            FillWithNullElements(subItems,extraNullElements);
            return subItems;
        }


    }

}
