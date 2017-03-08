package com.hand.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOoutputStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			FileOutputStream fos = new FileOutputStream("test1.txt");
			byte input[] = new byte[50];
			while (fis.read(input) != -1) {
				fos.write(input);
				input = new byte[50];
			}
			fos.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
