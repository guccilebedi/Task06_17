package com.company;

import java.util.HashMap;

public class HashMapUtils {

    public static HashMap findProperNames(String[] txtArr) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i < txtArr.length; i++) {
            if (Character.isUpperCase(txtArr[i].charAt(0)) && txtArr[i - 1].charAt(txtArr[i - 1].length() - 1) != '.') {
                String word = txtArr[i];
                if (word.endsWith(".")) {
                    word = word.replace(".", "");
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
