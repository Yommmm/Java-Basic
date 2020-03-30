package com.basic.thread.pipeio;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {

    private ReadData readData;

    private PipedInputStream input;

    public ThreadRead(ReadData readData, PipedInputStream input) {
        super();
        this.readData = readData;
        this.input = input;
    }

    @Override
    public void run() {
        super.run();
        readData.readMethod(input);
    }

}
