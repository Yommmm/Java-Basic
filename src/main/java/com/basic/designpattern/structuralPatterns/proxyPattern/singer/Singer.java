package com.basic.designpattern.structuralPatterns.proxyPattern.singer;

/**
 * 实现歌手接口的歌手
 * @author 170186
 *
 */
public class Singer implements Sing {

	private String songName;
	
	private String agentName;
	
	public Singer(String songName, String agentName) {
		this.songName = songName;
		this.agentName = agentName;
		this.agent();
	}

	@Override
	public void sing() {
		System.out.println("singing " + songName);
	}
	
	public void agent() {
		System.out.println("agentBy " + agentName);
	}

}
