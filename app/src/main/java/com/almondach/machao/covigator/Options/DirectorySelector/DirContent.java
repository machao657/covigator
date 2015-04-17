package com.almondach.machao.covigator.Options.DirectorySelector;

import android.os.Environment;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by machao on 4/15/15.
 */
public class DirContent {
    private static String topPath;
    private static String curPath;

    public static ArrayList<DirItem> dirs;
    static {
        topPath = Environment.getExternalStorageDirectory().getAbsolutePath();

        UpdateCurrentDirList(topPath);
    }

    public static void UpdateCurrentDirList(String curDir){
        curPath = curDir;
        LinkedList<String > subdirs = SelectDirActivity.SubDirsInfo.GetSubDirs(curPath);
        dirs = new ArrayList<>(subdirs.size());

        for (String dir:subdirs){
            dirs.add(new DirItem(curPath + "/" + dir ,""));
        }
    }

    public static void Add(String curDir,String subDirFiles){
        dirs.add(new DirItem(curDir,subDirFiles));
    }

    public static void Clear(){
        dirs.clear();
    }

    public static String GetCurDir(){
        return curPath;
    }

    static public class DirItem{
        String curDir;
        String subFileDirs;

        public DirItem(String curDir,String subDir){
            this.curDir = curDir;
            this.subFileDirs = subDir;
        }

        public String toString(){
            return curDir + "\n" + subFileDirs;
        }
    }
}
