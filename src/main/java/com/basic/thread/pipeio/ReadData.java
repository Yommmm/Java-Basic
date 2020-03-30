package com.basic.thread.pipeio;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {

    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("Read start: ");
            byte[] byteArray = new byte[200];
            int readLength = input.read(byteArray);
            while (-1 != readLength) {
                String newData = new String(byteArray, 0, readLength);
                System.out.println(newData + " ");
                readLength = input.read(byteArray);
            }

            System.out.println("\n");
            input.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
