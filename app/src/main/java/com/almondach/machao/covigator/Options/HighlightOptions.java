package com.almondach.machao.covigator.Options;


import android.text.Spanned;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by machao on 4/2/15.
 */
public class HighlightOptions {
    static public class KeywordHighlightOpt{

        public String keyword = "";
        public int foregroundColor = 0;
        public int backgroundColor = 0;
        public int spanStartEndPointOpt = Spanned.SPAN_INCLUSIVE_INCLUSIVE;
        public boolean isBold = false;
        public boolean isItalic = false;
        public boolean HighlightCurrentLine = false;
    }



    private static Map<String,KeywordHighlightOpt> opts = new WeakHashMap<String,KeywordHighlightOpt>();


    public KeywordHighlightOpt[] GetArray(){
        Object[] objArray = opts.values().toArray();
        KeywordHighlightOpt[] optsArray = new KeywordHighlightOpt[objArray.length];
        System.arraycopy(objArray,0,optsArray,0,objArray.length);
        return optsArray;
    }

    public KeywordHighlightOpt GetKeywordOpt(String keyword){
        synchronized (this){
            return opts.get(keyword);
        }
    }

    public void AddKeywordOpt(KeywordHighlightOpt opt){
        synchronized (this){
            opts.put(opt.keyword,opt);
        }
    }

}
