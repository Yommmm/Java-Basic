package com.basic.thread.pipeiochar;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData {

	public void readMethod(PipedReader input) {
		try {
			System.out.println("Read start: ");
			char[] byteArray = new char[1024];
			int readLength = input.read(byteArray);
			while(-1 != readLength) {
				String newData = new String(byteArray, 0, readLength);
				System.out.println(newData);
				readLength = input.read(byteArray);
			}
			System.out.println();
			System.out.println();
			input.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
