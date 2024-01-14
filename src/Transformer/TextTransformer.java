package Transformer;

import java.util.LinkedHashMap;
import java.util.Map;

public class TextTransformer {
    private final MapAlphabet preparedAlphabet = new MapAlphabet();
    public String moveLetterOnRightPosition(int key, String text){
        Map<Character, Character> alphabet = preparedAlphabet.getMapAlphabet(key, "right");
        StringBuilder stringBuilder = new StringBuilder();
        char[] textInChar= text.toCharArray();
        for(char letter: textInChar){
            if(alphabet.containsKey(letter)){
                stringBuilder.append(alphabet.get(letter));
            }
            else{
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }

    public String moveLetterOnLeftPosition(int key, String text){
        Map<Character, Character> alphabet = preparedAlphabet.getMapAlphabet(key, "left");
        StringBuilder stringBuilder = new StringBuilder();
        char[] textInChar= text.toCharArray();
        for(char letter: textInChar){
            if(alphabet.containsKey(letter)){
                stringBuilder.append(alphabet.get(letter));
            }
            else{
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }
}
