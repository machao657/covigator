package com.almondach.machao.covigator.CodeHighlighter;

import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import com.almondach.machao.covigator.CodeAnalyser.KeyworderMatcher;
import com.almondach.machao.covigator.Options.HighlightOptions;

/**
 * Created by machao on 4/2/15.
 */
public class ColoreSpanRender {
    private HighlightOptions opts;
    private HighlightOptions.KeywordHighlightOpt[] optsArray;
    public static class SpanInfo{
        String keyword;
        static public final int MODE = Spannable.SPAN_INCLUSIVE_INCLUSIVE;
        KeyworderMatcher.Occurences occurences;
        int foregroundColor;
        int backgroundColor;

        public ForegroundColorSpan fgColorSpan(){
            return new ForegroundColorSpan(foregroundColor);
        }
    }


    public ColoreSpanRender(){
    }


    public void SetHighlightOptions(HighlightOptions opts){
        this.opts = opts;
        optsArray = opts.GetArray();
    }

    public SpanInfo[] GetSpanColorInfos(){

        SpanInfo[] spanInfos = new SpanInfo[optsArray.length];
        for (int n = 0;n<optsArray.length;n++){
            spanInfos[n] = new SpanInfo();
            spanInfos[n].keyword = optsArray[n].keyword;
            spanInfos[n].foregroundColor = optsArray[n].foregroundColor;

        }
        return spanInfos;
    }




}
