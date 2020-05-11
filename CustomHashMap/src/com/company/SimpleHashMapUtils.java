package com.company;

public class SimpleHashMapUtils {

    public static SimpleHashMap findProperNames(String[] txtArr) {
        SimpleHashMap simpleHashMap = new SimpleHashMap(txtArr.length);
        for (int i = 1; i < txtArr.length; i++) {
            if (Character.isUpperCase(txtArr[i].charAt(0)) && txtArr[i - 1].charAt(txtArr[i - 1].length() - 1) != '.') {
                boolean checker = false;
                if (txtArr[i].endsWith(".")) {
                    txtArr[i] = txtArr[i].replace(".", "");
                    checker = true;
                }
                int counter = 1;
                for (int j = i + 1; j < txtArr.length; j++) {
                    if (txtArr[i].equals(txtArr[j])) {
                        counter++;
                        txtArr[j] = " ";
                    }
                }
                simpleHashMap.put(simpleHashMap.size, txtArr[i] + " " + counter);
                if (checker) {
                    txtArr[i] = ".";
                } else {
                    txtArr[i] = " ";
                }
            }
        }
        return simpleHashMap;
    }
}
