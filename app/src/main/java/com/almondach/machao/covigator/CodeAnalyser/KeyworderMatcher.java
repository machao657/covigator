package com.almondach.machao.covigator.CodeAnalyser;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by machao on 4/10/15.
 */
public class KeyworderMatcher {
    static public class Occurences{
        static public String keyword;
        LinkedList<Location> locations = new LinkedList<Location>();

        static public class Location{
            public int start;
            public int end;
        }
    }

    static private String source;

    public KeyworderMatcher(){

    }

    static public void SetSource(String source){
        KeyworderMatcher.source = source;
    }

    static public Occurences LocateOccurences(String keyword){
        Occurences occurences = new Occurences();
        occurences.keyword = keyword;

        Pattern pattern = Pattern.compile(PadWhitespace(keyword));
        Matcher matcher = pattern.matcher(source);
        FindAllMatches(matcher,occurences);

        return occurences;
    }

    static private void FindAllMatches(Matcher matcher,Occurences occurences){

        while (matcher.find()){
            Occurences.Location loct = new Occurences.Location();
            loct.start = matcher.start() + 1;
            loct.end = matcher.end() - 1;
            occurences.locations.add(loct);
        }
    }

    static private String PadWhitespace(String keyword){
        return "\\s" + keyword + "\\s";
    }
}
