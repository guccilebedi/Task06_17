package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {

    public static String[] read(String filename) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(filename));
        String txt = new String();
        while (scn.hasNext()) {
            if (txt.isEmpty()) {
                txt = scn.nextLine();
            } else {
                txt += " " + scn.nextLine();
            }
        }
        String[] txtArr = txt.split(" ");
        return txtArr;
    }
}
