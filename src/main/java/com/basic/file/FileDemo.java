package com.basic.file;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) {
        FileDemo fileDemo = new FileDemo();
        File file = new File("E:\\12技术文档");
        fileDemo.printName(file, "");
    }

    private void printName(File file, String prefix) {
        System.out.println(prefix + file.getName());
        String[] list = file.list();
        for (String path : list) {
            File nextFile = new File(file.getPath() + "\\" + path);
            if (nextFile.isFile() || nextFile.list() == null || nextFile.list().length == 0) {
                System.out.println(prefix + "-" + nextFile.getName());
            } else {
                printName(nextFile, prefix + "-");
            }
        }
    }

}
