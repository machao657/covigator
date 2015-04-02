package com.almondach.machao.covigator.CodeHighlighter;

import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import com.almondach.machao.covigator.Options.HighlightOptions;

/**
 * Created by machao on 4/2/15.
 */
public class ColoreSpanRender {
    private HighlightOptions opts;
    public ColoreSpanRender(){
    }

    public void SetHighlightOptions(HighlightOptions opts){
        this.opts = opts;
    }

    public ForegroundColorSpan[] GetForegroundColorSpans(){

    }

    public BackgroundColorSpan[] GetBackgroundColorSpans(){

    }



    private ForegroundColorSpan GetForegroundSpan(HighlightOptions.KeywordHighlightOpt opt){
        return new ForegroundColorSpan(opt.foregroundColor);

    }

    private BackgroundColorSpan GetBackgroundSpan(HighlightOptions.KeywordHighlightOpt opt){
        return new BackgroundColorSpan(opt.backgroundColor);
    }

}
