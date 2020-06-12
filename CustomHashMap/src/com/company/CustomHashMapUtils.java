package com.company;

public class CustomHashMapUtils {

    public static CustomHashMap findProperNames(String[] txtArr) {
        CustomHashMap customHashMap = new CustomHashMap();
        for (int i = 1; i < txtArr.length; i++) {
            if (Character.isUpperCase(txtArr[i].charAt(0)) && txtArr[i - 1].charAt(txtArr[i - 1].length() - 1) != '.') {
                String word = txtArr[i];
                if (word.endsWith(".")) {
                    word = word.replace(".", "");
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
