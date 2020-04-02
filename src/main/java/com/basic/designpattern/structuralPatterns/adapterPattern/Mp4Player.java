package com.basic.designpattern.structuralPatterns.adapterPattern;

public class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Play mp4 fileName: " + fileName);
	}

}
