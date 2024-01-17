package Transformer;

import SupportClasses.Constants;
import SupportClasses.Mode;

import java.util.LinkedHashMap;
import java.util.Map;

public class TextTransformer {
    private final MapAlphabet preparedAlphabet = new MapAlphabet();
    public String moveLetterOnRightPosition(int key, String text){
        Map<Character, Character> alphabet = preparedAlphabet.getMapAlphabet(key, Constants.RIGHT_MODE);
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
        Map<Character, Character> alphabet = preparedAlphabet.getMapAlphabet(key, Constants.LEFT_MODE);
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
