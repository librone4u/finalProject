package Transformer;

import SupportClasses.Constants;
import SupportClasses.Mode;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapAlphabet {
    final private String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
    final private String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final private String specialSymbol = ".,«»\"\'\\:!? ";

    public Map<Character, Character> getMapAlphabet(int key, String mode) {
        Map<Character, Character> transformedAlphabet = new LinkedHashMap<>();

        if (mode.equals(Constants.RIGHT_MODE)) {
            addToMap(lowerCaseAlphabet, key, transformedAlphabet);
            addToMap(upperCaseAlphabet, key, transformedAlphabet);
            addToMap(specialSymbol, key, transformedAlphabet);
        } else if (mode.equals(Constants.LEFT_MODE)) {
            addToMap(lowerCaseAlphabet, -key, transformedAlphabet);
            addToMap(upperCaseAlphabet, -key, transformedAlphabet);
            addToMap(specialSymbol, -key, transformedAlphabet);
        }

        return transformedAlphabet;
    }

    private void addToMap(String input, int key, Map<Character, Character> map) {
        int length = input.length();

        for (int i = 0; i < length; i++) {
            int shiftedIndex = (i + key + length) % length;
            if (shiftedIndex < 0) {
                shiftedIndex += length;  // Обработка отрицательных значений
            }
            char originalChar = input.charAt(i);
            char shiftedChar = input.charAt(shiftedIndex);
            map.put(originalChar, shiftedChar);
        }
    }
}
