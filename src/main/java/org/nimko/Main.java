package org.nimko;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TextAnalyzer analyzer = new TextAnalyzer(getText());
        System.out.println("Result - " + analyzer.getResult());
    }

    private static String getText(){
        StringBuilder text = new StringBuilder();
        try(FileReader reader = new FileReader("text.txt")){
            int c;
            while((c=reader.read())!=-1){
                text.append((char) c);
            }
        }
        catch(IOException ex){
            System.err.println("File text.txt - not found!\nPlease put file in directory with this program!");
            System.exit(0);
        }
        return text.toString();
    }
}