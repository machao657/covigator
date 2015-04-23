package com.almondach.machao.covigator.CodeAnalyser;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by machao on 4/10/15.
 */
public class KeyworderMatcher {
    public static final String RGX_NON_DIGIT_CHARACTER = "[^0-9A-Za-z]";
    static public class Occurences{
        public LinkedList<Location> locations = new LinkedList<Location>();

        static public class Location{
            public int start;
            public int end;
        }
    }

    static private String source;
    static private int sourceStartOffset;

    public KeyworderMatcher(){
    }

    static public void SetSource(String source,int sourceOffset){
        KeyworderMatcher.source = source;
        KeyworderMatcher.sourceStartOffset = sourceOffset;
    }

    static int GetOffset(int offsetInSource){
        return sourceStartOffset + offsetInSource;
    }

    static public Occurences LocateOccurences(String keyword){
        Occurences occurences = new Occurences();

        Pattern pattern = Pattern.compile(PadWhitespace(keyword));
        Matcher matcher = pattern.matcher(source);
        FindAllMatches(matcher,occurences);

        return occurences;
    }

    static private void FindAllMatches(Matcher matcher,Occurences occurences){

        while (matcher.find()){
            Occurences.Location loct = new Occurences.Location();
            loct.start = GetOffset(matcher.start() + 1);
            loct.end = GetOffset(matcher.end() - 1);
            occurences.locations.add(loct);
        }
    }

    static private String PadWhitespace(String keyword){
        return RGX_NON_DIGIT_CHARACTER + keyword + RGX_NON_DIGIT_CHARACTER;
    }
}
