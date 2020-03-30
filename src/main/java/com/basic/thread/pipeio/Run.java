package com.basic.thread.pipeio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {

    public static void main(String[] args) {

        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedOutputStream out = new PipedOutputStream();
            PipedInputStream input = new PipedInputStream();

            ThreadWrite threadWrite = new ThreadWrite(writeData, out);
            ThreadRead threadRead = new ThreadRead(readData, input);

            // 连接管道
            out.connect(input);

            threadRead.start();

            Thread.sleep(2000);

            threadWrite.start();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
