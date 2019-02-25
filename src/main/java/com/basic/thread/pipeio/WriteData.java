package com.basic.thread.pipeio;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {

	public void writeMethod(PipedOutputStream out) {
		try {
			System.out.println("Write start: ");
			for(int i = 0; i <= 300; i++) {
				String outData = i + " ";
				out.write(outData.getBytes());
				System.out.print(outData);
			}
			System.out.println("\n");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
