package com.almondach.machao.covigator.CodeHighlighter;

import android.text.Spannable;
import com.almondach.machao.covigator.CodeAnalyser.KeyworderMatcher;
import com.almondach.machao.covigator.Options.HighlightOptions;

/**
 * Created by machao on 4/2/15.
 */
public class Highlighter {
    private Spannable spannable;
    private ColoreSpanRender spanRender = new ColoreSpanRender();

    private HighlightOptions opts;
    private String visibleText;
    private int visibleTextOffset;


    public Highlighter(){

    }

    private void SetOptions(HighlightOptions opts,Spannable spannable,String visibleText,int visibleTextOffset){
        this.spannable = spannable;
        this.opts = opts;
        this.visibleText = visibleText;
        this.visibleTextOffset = visibleTextOffset;
        spanRender.SetHighlightOptions(opts);
        KeyworderMatcher.SetSource(visibleText,visibleTextOffset);
    }

    public void Highlight(HighlightOptions opts,Spannable spannable,String visibleText,int visibleTextOffset){
        SetOptions(opts,spannable,visibleText,visibleTextOffset);

        for (ColoreSpanRender.SpanInfo spanInfo:spanRender.GetSpanColorInfos()){
            FindMatches(spanInfo);
            HighlightAllMatches(spanInfo);
        }
    }

    private void FindMatches(ColoreSpanRender.SpanInfo spanInfo){

        spanInfo.occurences = KeyworderMatcher.LocateOccurences(spanInfo.keyword);
    }

    private void HighlightAllMatches(ColoreSpanRender.SpanInfo spanInfo){
        for (KeyworderMatcher.Occurences.Location loc :spanInfo.occurences.locations){
            spannable.setSpan(spanInfo.foregroundColorSpan,loc.start,loc.end,spanInfo.MODE);
        }
    }

}
