package com.basic.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Heap OOM Demo
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
 */
public class JavaHeapOOMDemo {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject{

    }

}
