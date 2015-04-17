package com.almondach.machao.covigator;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;

import com.almondach.machao.covigator.ViewEditor.Editor;


public class TestActivity extends Activity {
    private Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareText();
    }



    public class Test{
        public void testHighLight(){

        }
    }

    public void prepareText() {
        EditText editText = (EditText) findViewById(R.id.text_editor);
        editor = new Editor(editText);

    }
        /* editor.setText("The Manhattan Project, a research-and-development program " +
                "operated during and immediately after World War II. Led by the United States with the United Kingdom and Canada participating, it aimed to produce an atomic bomb.[1] Brigadier General Leslie Groves of the U.S. Army Corps of Engineers became its director in September 1942.[2] The Manhattan Project operated under a tight blanket of security lest its discovery induce Axis powers, particularly Germany, to accelerate their own nuclear projects or to undertake covert operations against the project.[3]\n" +
                "After the Allied invasion of Italy in September 1943, Brigadier General Wilhelm D. Styer,[4] the Chief of Staff of Army Service Forces,[5] approached Groves on behalf of the Chief of Staff of the Army, General George Marshall, and asked if the Manhattan Project could take over responsibility for coordination of foreign intelligence activities related to nuclear energy. Styer felt that the existing efforts were not being properly coordinated, and that the importance of items might be overlooked unless those responsible were properly briefed, but at the same time he wished to minimize the number of personnel with access to such secret information. The best option therefore seemed to be to have the effort undertaken by the Manhattan Project itself.[6]\n" +
                "The Manhattan Project intelligence staff believed that the Japanese atomic program was not far advanced because Japan had little access to uranium ore, the industrial effort required exceeded Japan's capacity, and, according to American physicists at the University of California, Berkeley, who knew the leading Japanese physicists personally, there were too few Japanese qualified to work in the area.[7] The German nuclear energy project seemed very different; German scientists had reputations as leaders in the field, and the fear of Germany developing nuclear weapons first was one of the reasons for the establishment of the Manhattan Project.[8] The Chancellor of Germany, Adolf Hitler, frequently claimed that Germany was developing secret weapons, and it was feared that these might include nuclear weapons.[9] Reports of German nuclear activity were taken very seriously. At the instigation of the Manhattan Project, Norwegian saboteurs and Allied bombers attacked heavy-water infrastructure in German-occupied Norway.[10]\n" +
                "Groves created a small mission jointly staffed by the Office of Naval Intelligence (ONI), the Office of Scientific Research and Development (OSRD), the Manhattan Project, and Army Intelligence (G-2). It aimed to investigate enemy scientific developments, including nuclear weapons research.[11] The mission was codenamed Alsos, the Greek word for \"grove\". Groves was not pleased with the codename, but in the end decided that changing it would only draw further unwanted attention.[12]\n" +
                "The Chief of Army Intelligence, Major General George V. Strong, appointed Lieutenant Colonel Boris Pash to command the unit.[13] Pash had served as the head of the Counter Intelligence Branch of the Western Defense Command, where he had investigated suspected Soviet espionage at the Radiation Laboratory at Berkeley.[14] Pash's command comprised his executive officer Captain Wayne B. Stanard, four Counter Intelligence Corps (CIC) agents, four interpreters, and four scientists: Dr. James B. Fisk from the Bell Telephone Company, Dr. John R. Johnson from Cornell University, Commander Bruce Olds from ONI and the Massachusetts Institute of Technology (MIT), and Major William Allis, originally from MIT although then serving on the War Department scientific staff.[15][16]");
        Spannable spans = editor.getText();
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.GREEN);
        spans.setSpan(colorSpan,0,10,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        ViewTreeObserver viewObv = editor.getViewTreeObserver();
        viewObv.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Layout textLayout = editor.getLayout();
                editor.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        int currentAction = event.getAction();
                        return false;

                    }
                });
                editor.setOnGenericMotionListener(new View.OnGenericMotionListener() {
                    @Override
                    public boolean onGenericMotion(View v, MotionEvent event) {
                        return false;
                    }
                });
                int count = textLayout.getLineCount();
                int left = editor.getLeft();
                int right = editor.getRight();
                int bottom = editor.getBottom();
                int top = editor.getTop();
                float x = editor.getX();
                float y = editor.getY();
                int start = editor.getOffsetForPosition(editor.getLeft(),editor.getTop());
                int end = editor.getOffsetForPosition(editor.getRight(),editor.getBottom());
                int offsetStart = textLayout.getLineStart(0);
                int offsetEndWhole = textLayout.getLineEnd(textLayout.getLineCount() - 1);
            }
        });
        */

        // Spannable currentSpan = (Spannable)textLayout.getText();
        //ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.GREEN);
        //currentSpan.setSpan(colorSpan,0,10,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
}
