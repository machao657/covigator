package com.almondach.machao.covigator.CodeHighlighter;

import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.almondach.machao.covigator.Options.HighlightOptions;

/**
 * Created by machao on 4/2/15.
 */
public class ColoreSpanRender {
    private HighlightOptions opts;
    private HighlightOptions.KeywordHighlightOpt[] optsArray;
    public ColoreSpanRender(){
    }

    public void SetHighlightOptions(HighlightOptions opts){
        this.opts = opts;
        optsArray = opts.GetArray();
    }

    public ForegroundColorSpan[] GetForegroundColorSpans(){

        ForegroundColorSpan[] foregroundColorSpans = new ForegroundColorSpan[optsArray.length];
        for (int n = 0;n<optsArray.length;n++){
            foregroundColorSpans[n] = GetForegroundSpan(optsArray[n]);
        }
        return foregroundColorSpans;
    }

    public BackgroundColorSpan[] GetBackgroundColorSpans(){

        BackgroundColorSpan[] backgroundColorSpans= new BackgroundColorSpan[optsArray.length];
        for (int n = 0;n<optsArray.length;n++){
            backgroundColorSpans[n] = GetBackgroundSpan(optsArray[n]);
        }

        return backgroundColorSpans;
    }



    private ForegroundColorSpan GetForegroundSpan(HighlightOptions.KeywordHighlightOpt opt){
        return new ForegroundColorSpan(opt.foregroundColor);

    }

    private BackgroundColorSpan GetBackgroundSpan(HighlightOptions.KeywordHighlightOpt opt){
        return new BackgroundColorSpan(opt.backgroundColor);
    }

}
