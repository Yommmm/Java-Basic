package com.basic.thread.pipeiochar;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData {

	public void writeData(PipedWriter out) {
		try {
			System.out.println("Write start: ");
			for(int i = 1; i <= 300; i++) {
				String outData = " " + i;
				out.write(outData);
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
