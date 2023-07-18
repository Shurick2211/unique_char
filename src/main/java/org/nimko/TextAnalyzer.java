package org.nimko;

import java.util.Arrays;

public class TextAnalyzer {
    private final String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public char getResult() {
        String [] words = text.toLowerCase()
                .replaceAll("\n"," ")
                .replaceAll("\\.", "")
                .replaceAll("\\?", "")
                .replaceAll("\"", "")
                .replaceAll("-", "")
                .replaceAll("!", "")
                .replaceAll(",", "")
                .split(" ");
        StringBuilder uniqChars = new StringBuilder();
        Arrays.stream(words)
                .filter(word -> !word.trim().isEmpty())
                .map(this::uniqChar)
                .forEach(uniqChars::append);
        return uniqChar(uniqChars.toString());
    }

    private char uniqChar(String word){
        for(int i = 0; i < word.length(); i++){
            if(word.indexOf(word.charAt(i), i+1) == -1)
                return word.charAt(i);
        }
        return ' ';
    }
}
