package com.basic.basic;

import java.io.File;
import java.util.Arrays;

public class FilenameReader {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\170186\\Desktop\\fl\\sql_0107");

        System.out.println(file.getName());
        String[] list = file.list();
        for (String name : list) {
            System.out.println("source " + name + ";");
        }
    }

}
