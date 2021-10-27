package com.douzone.container.videosystem;

public class DVDPlayer {
	private DigitalVideoDisc dvd;
	
	// 기본 생성자가 없으면 에러남
	public DVD
	
	
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public void play() {
		dvd.play();
	}

	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
}