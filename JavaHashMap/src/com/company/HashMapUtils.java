package com.company;

import java.util.HashMap;

public class HashMapUtils {

    public static HashMap findProperNames(String[] txtArr) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i < txtArr.length; i++) {
            String prevWord = txtArr[i - 1];
            if (Character.isUpperCase(txtArr[i].charAt(0)) && !prevWord.endsWith(".") && !prevWord.endsWith(",") && !prevWord.endsWith("!") && !prevWord.endsWith("?")) {
                String word = txtArr[i];
                if (word.endsWith(".") || word.endsWith(",") || word.endsWith("!") || word.endsWith("?") || word.endsWith(":") || word.endsWith(";")) {
                    word = word.substring(0, word.length() - 1);
                }
                if (hashMap.get(word) != null) {
                    hashMap.put(word, (int) hashMap.get(word) + 1);
                } else {
                    hashMap.put(word, 1);
                }
            }
        }
        return hashMap;
    }
}
