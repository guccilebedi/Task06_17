package com.company;

public class CustomHashMapUtils {

    public static CustomHashMap findProperNames(String[] txtArr) {
        CustomHashMap customHashMap = new CustomHashMap();
        for (int i = 1; i < txtArr.length; i++) {
            String prevWord = txtArr[i - 1];
            if (Character.isUpperCase(txtArr[i].charAt(0)) && !prevWord.endsWith(".") && !prevWord.endsWith(",") && !prevWord.endsWith("!") && !prevWord.endsWith("?")) {
                String word = txtArr[i];
                if (word.endsWith(".") || word.endsWith(",") || word.endsWith("!") || word.endsWith("?") || word.endsWith(":") || word.endsWith(";")) {
                    word = word.substring(0, word.length() - 1);
                }
                if (customHashMap.get(word) != null) {
                    customHashMap.put(word, (int) customHashMap.get(word) + 1);
                } else {
                    customHashMap.put(word, 1);
                }
            }
        }
        return customHashMap;
    }
}
