package com.almondach.machao.covigator.CodeHighlighter;

import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import com.almondach.machao.covigator.Options.HighlightOptions;


/**
 * Created by machao on 4/2/15.
 */
public class Highlighter {
    private Spannable source;
    private ColoreSpanRender spanRender = new ColoreSpanRender();

    public Highlighter(){
    }

    public void SetSpans(Spannable source){
        this.source = source;
    }

    public void SetHighLightOpts(HighlightOptions opts){
        spanRender.SetHighlightOptions(opts);

        for (ForegroundColorSpan span:spanRender.GetForegroundColorSpans()){

        }
    }


}
