package com.basic.thread.pipeiochar;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Run {

    public static void main(String[] args) {
        try {
            WriteData write = new WriteData();
            ReadData read = new ReadData();

            PipedWriter out = new PipedWriter();
            PipedReader input = new PipedReader();

            ThreadRead threadRead = new ThreadRead(read, input);
            ThreadWrite threadWrite = new ThreadWrite(write, out);

            out.connect(input);

            threadWrite.start();
            Thread.sleep(3000);
            threadRead.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
