package com.almondach.machao.covigator.ViewEditor;

import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.almondach.machao.covigator.CodeHighlighter.Highlighter;
import com.almondach.machao.covigator.Options.HighlightOptions;

/**
 * Created by machao on 4/13/15.
 */
public class Editor {
    private HighlightOptions opts;
    private Highlighter highlighter = new Highlighter();
    private EditText editText;




    public Editor(EditText editText){
        this.editText = editText;
        ViewTreeObserver vto = editText.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Test testHighlight = new Test();
                testHighlight.SetTextAndHighlight();
            }
        });


    }


    private int visibleStartOffset;
    private int visibleEndOffset;

    public void SetText(String text){
        editText.setText(text);
    }

    public void UpdateCurrentScreenLoc(){
        visibleStartOffset = editText.getOffsetForPosition(editText.getLeft(),editText.getTop());
        visibleEndOffset = editText.getOffsetForPosition(editText.getRight(),editText.getBottom());
    }

    public String GetVisibleStr(){

        CharSequence charSequence = editText.getText();
        CharSequence visibleCharSequence = charSequence.subSequence(visibleStartOffset,visibleEndOffset);
        return visibleCharSequence.toString();
    }

    public void SetHighlightOptions(HighlightOptions opts){
        this.opts = opts;
    }

    public void HighLight(){
        highlighter.Highlight(opts,editText.getText(),GetVisibleStr(),visibleStartOffset);
    }

    public class Test{
        public HighlightOptions GetOpts(){
            HighlightOptions opts = new HighlightOptions();
            opts.AddKeywordOpt(GetAOption("int"));
            opts.AddKeywordOpt(GetAOption("String"));
            opts.AddKeywordOpt(GetAOption("return"));
            opts.AddKeywordOpt(GetAOption("public"));
            opts.AddKeywordOpt(GetAOption("class"));
            opts.AddKeywordOpt(GetAOption("import"));

            return opts;
        }

        public HighlightOptions.KeywordHighlightOpt GetAOption(String keyword){
            HighlightOptions.KeywordHighlightOpt opt = new HighlightOptions.KeywordHighlightOpt();
            opt.backgroundColor = 0xffffffff;
            opt.foregroundColor = 0xff00ff00;
            opt.keyword = keyword;

            return opt;
        }

        public void SetTextAndHighlight(){
            Editor.this.SetText(sourceCode);
            Editor.this.UpdateCurrentScreenLoc();
            Editor.this.SetHighlightOptions(GetOpts());
            Editor.this.HighLight();
        }

        public String sourceCode = " int com.almondach.machao.covigator.ViewEditor;\n" +
                "\n" +
                "import android.text.style.ForegroundColorSpan;\n" +
                "import android.widget.EditText;\n" +
                "\n" +
                "import com.almondach.machao.covigator.CodeHighlighter.ColoreSpanRender;\n" +
                "import com.almondach.machao.covigator.CodeHighlighter.Highlighter;\n" +
                "import com.almondach.machao.covigator.Options.HighlightOptions;\n" +
                "\n" +
                "/**\n" +
                " * Created by machao on 4/13/15.\n" +
                " */\n" +
                "public class Editor {\n" +
                "    private HighlightOptions opts;\n" +
                "    private Highlighter highlighter = new Highlighter();\n" +
                "    private EditText editText;\n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "    public Editor(EditText editText){\n" +
                "        this.editText = editText;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    private int visibleStartOffset;\n" +
                "    private int visibleEndOffset;\n" +
                "\n" +
                "    private void UpdateCurrentScreenLoc(){\n" +
                "        visibleStartOffset = editText.getOffsetForPosition(editText.getLeft(),editText.getTop());\n" +
                "        visibleEndOffset = editText.getOffsetForPosition(editText.getRight(),editText.getBottom());\n" +
                "    }\n" +
                "\n" +
                "    public String GetVisibleStr(){\n" +
                "\n" +
                "        CharSequence charSequence = editText.getText();\n" +
                "        CharSequence visibleCharSequence = charSequence.subSequence(visibleStartOffset,visibleEndOffset);\n" +
                "        return visibleCharSequence.toString();\n" +
                "    }\n" +
                "\n" +
                "    public void SetHightOptions(HighlightOptions opts){\n" +
                "        this.opts = opts;\n" +
                "    }\n" +
                "\n" +
                "    public void HighLight(){\n" +
                "        highlighter.Highlight(opts,editText.getText(),GetVisibleStr(),visibleStartOffset);\n" +
                "    }\n" +
                "\n" +
                "    static public class Test{\n" +
                "        String sourceCode = \"\"; \n" +
                "        \n" +
                "        static public HighlightOptions GetOpts(){\n" +
                "            HighlightOptions opts = new HighlightOptions();\n" +
                "            HighlightOptions.KeywordHighlightOpt opt = new HighlightOptions.KeywordHighlightOpt();\n" +
                "            opt.backgroundColor = 0xffffffff;\n" +
                "            opt.foregroundColor = 0xff00ff00;\n" +
                "            opt.keyword = \"int\";\n" +
                "            opts.AddKeywordOpt(opt);\n" +
                "            return opts;\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}
