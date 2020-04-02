package com.basic.designpattern.structuralPatterns.adapterPattern;

public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("mp3: " + fileName);
		} 
		// 适配器开始，上面是支持的格式，下面是不支持的格式
		// 适配器相当于一个接口转换工具，把不支持的格式支持、适配
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} 
		else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}

}
