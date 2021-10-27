package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.videosystem.DVDPack;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml" })
public class DVDPlayerXmlConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	// @Autowired
	// 예외 발생
	// XML Bean 설정(Avengers)에서는 id를 자동으로 부여하지 않는다.
	// @Qualifer 사용없음
	private DigitalVideoDisc dvd1;

	@Autowired
	@Qualifier("ironMan") // DVDPlayerConfig.xml 의 id를 찾아감
	private DigitalVideoDisc dvd2;

	@Autowired
	@Qualifier("avengersInfinityWar") // DVDPlayerConfig.xml 의 id를 찾아감
	private DigitalVideoDisc dvd3;
	
	@Autowired
	@Qualifier("avengersEndgame") // DVDPlayerConfig.xml 의 id를 찾아감
	private DigitalVideoDisc dvd4;
	
	@Autowired
	@Qualifier("avengersAgeOfUltron") // DVDPlayerConfig.xml 의 id를 찾아감
	private DigitalVideoDisc dvd5;
	
	@Autowired
	@Qualifier("avengersCaptainAmerica") // DVDPlayerConfig.xml 의 id를 찾아감
	private DigitalVideoDisc dvd6;
	
	@Autowired
	@Qualifier("avengersDirectorEdition") // DVDPlayerConfig.xml 의 id를 찾아감
	private DigitalVideoDisc dvd7;
	
	@Autowired
	private DVDPack dvdPack;
	
	@Autowired
	@Qualifier("avengersExpansionEdition1")
	private DigitalVideoDisc dvd9;	
	
	@Autowired
	@Qualifier("avengersExpansionEdition2")
	private DigitalVideoDisc dvd10;	

	@Autowired
	@Qualifier("avengersExpansionEdition3")
	private DigitalVideoDisc dvd11;	

	@Autowired
	@Qualifier("dvdPlayer1")
	private DVDPlayer dvdplayer1;

	@Autowired
	@Qualifier("dvdPlayer2")
	private DVDPlayer dvdplayer2;

	@Autowired
	@Qualifier("dvdPlayer3")
	private DVDPlayer dvdplayer3;

	@Autowired
	@Qualifier("dvdPlayer4")
	private DVDPlayer dvdplayer4;
	
	// dvd1이 널인지 아닌지 확인
	@Ignore
	@Test
	public void testDVD1() {
		assertNotNull(dvd1);
	}

	@Test
	public void testDVD2() {
		assertNotNull(dvd2);
	}
	
	@Test
	public void testDVD3() {
		assertNotNull(dvd3);
	}	
	
	@Test
	public void testDVD4() {
		assertNotNull(dvd4);
	}	
	
	@Test
	public void testDVD5() {
		assertNotNull(dvd5);
	}	
	
	@Test
	public void testDVD6() {
		assertNotNull(dvd6);
	}	
	
	@Test
	public void testDVD7() {
		assertNotNull(dvd7);
	}
	
	@Test
	public void testDVDPack() {
		// System.out.println(dvdPack);
		assertNotNull(dvdPack);
	}

	@Test
	public void testDVD8() {
		assertNotNull(dvd9);
	}

	@Test
	public void testDVD9() {
		assertNotNull(dvd10);
	}

	@Test
	public void testDVD10() {
		assertNotNull(dvd11);
	}

	@Test
	public void testPlay1() {
		dvdplayer1.play();
		assertEquals("Playing Movie MAVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}

	@Test
	public void testPlay2() {
		dvdplayer2.play();
		assertEquals("Playing Movie MAVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}

	@Test
	public void testPlay3() {
		dvdplayer3.play();
		assertEquals("Playing Movie MAVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
	
	@Test
	public void testPlay4() {
		dvdplayer4.play();
		assertEquals("Playing Movie MAVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}