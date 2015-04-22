package com.almondach.machao.covigator.Options.DirectorySelector;

import android.os.Environment;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by machao on 4/15/15.
 */
public class DirContent {
    public static final boolean IS_DIR = false;
    public static final boolean IS_FILE = true;

    private  final String TOPDIR_INDICATOR = "top directory";
    private  final String PARENT_DIR_INDICATOR = "..";
    protected   String topPath;
    protected   String curPath;

    public  ArrayList<FileDirPath> dirs ;


    public DirContent(){
        topPath = Environment.getExternalStorageDirectory().getAbsolutePath();

        UpdateCurrentDirList(topPath);
    }

    public DirContent(String topDir){
        topPath = topDir;
        UpdateCurrentDirList(topDir);
    }

    public void UpdateCurrentDirList(String curDir){
        curPath = curDir;
        dirs = SelectDirActivity.SubDirsInfo.GetSubItemsWithExtra(curDir,2);
        InsertIndicators();
    }

    public  String GetAbsPath(int position){
        String dir = dirs.get(position).absPath;
        if (dir.equals(PARENT_DIR_INDICATOR)){
            return (new File(curPath)).getParent();
        }
        if (dir.equals(TOPDIR_INDICATOR)){
            return topPath;
        }

        return dir;
    }

    public String GetRelPath(int pos){
        return dirs.get(pos).relpath;
    }

    public boolean isDir(int pos){
        return !dirs.get(pos).isFile;
    }

    public boolean isFile(int pos){
        return dirs.get(pos).isFile;
    }

    protected   void InsertIndicators(){
        dirs.set(0,new FileDirPath(TOPDIR_INDICATOR,TOPDIR_INDICATOR,IS_DIR));
        dirs.set(1,new FileDirPath(PARENT_DIR_INDICATOR,PARENT_DIR_INDICATOR,IS_DIR));

    }

    public  void Add(String curDir,String subDirFiles,boolean isFile){
        dirs.add(new FileDirPath(curDir,subDirFiles,isFile));
    }

    public  String GetCurDir(){
        return curPath;
    }

    static public class FileDirPath{
        public String absPath;
        public String relpath;
        public boolean isFile;

        public FileDirPath(String absPath,String relpath,boolean isFile){
            this.absPath = absPath;
            this.relpath = relpath;
            this.isFile = isFile;
        }

        public String toString(){
            return relpath  ;
        }
    }
}
