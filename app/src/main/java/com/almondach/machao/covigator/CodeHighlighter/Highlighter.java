package com.almondach.machao.covigator.CodeHighlighter;

import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import com.almondach.machao.covigator.Options.HighlightOptions;


/**
 * Created by machao on 4/2/15.
 */
public class Highlighter {
    private Spannable spanSource;


    public Highlighter(){
    }

    public void SetSpans(Spannable spans){
        spanSource = spans;
    }

    public void SetHighLightOpts(HighlightOptions opts){

    }


}
