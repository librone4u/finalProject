package Transformer;

import SupportClasses.Constants;
import SupportClasses.Mode;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapAlphabet {
    final private String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
    final private String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //modes: right|left
    public Map<Character, Character> getMapAlphabet(int key, String mode){
        Map<Character, Character> transformedAlphabet = new LinkedHashMap<>();

        if(mode.equals(Constants.RIGHT_MODE)) {
            //adding to map lower case letter
            for (int i = 0; i < lowerCaseAlphabet.length(); i++) {
                int shiftedIndex = (i + key) % lowerCaseAlphabet.length();
                char originalChar = lowerCaseAlphabet.charAt(i);
                char shiftedChar = lowerCaseAlphabet.charAt(shiftedIndex);
                transformedAlphabet.put(originalChar, shiftedChar);
            }
            //adding to map upper case letter
            for (int i = 0; i < upperCaseAlphabet.length(); i++) {
                int shiftedIndex = (i + key) % upperCaseAlphabet.length();
                char originalChar = upperCaseAlphabet.charAt(i);
                char shiftedChar = upperCaseAlphabet.charAt(shiftedIndex);
                transformedAlphabet.put(originalChar, shiftedChar);
            }

        } else if (mode.equals(Constants.LEFT_MODE)) {
            //adding to map lower case letter
            for (int i = 0; i < lowerCaseAlphabet.length(); i++) {
                int shiftedIndex = (i - key + lowerCaseAlphabet.length()) % lowerCaseAlphabet.length();
                char originalChar = lowerCaseAlphabet.charAt(i);
                char shiftedChar = lowerCaseAlphabet.charAt(shiftedIndex);
                transformedAlphabet.put(originalChar, shiftedChar);
            }
            //adding to map upper case letter
            for (int i = 0; i < upperCaseAlphabet.length(); i++) {
                int shiftedIndex = (i - key + upperCaseAlphabet.length()) % upperCaseAlphabet.length();
                char originalChar = upperCaseAlphabet.charAt(i);
                char shiftedChar = upperCaseAlphabet.charAt(shiftedIndex);
                transformedAlphabet.put(originalChar, shiftedChar);
            }
        }
        return transformedAlphabet;
    }
}
