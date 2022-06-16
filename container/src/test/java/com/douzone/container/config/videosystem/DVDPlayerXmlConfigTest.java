package com.douzone.container.config.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.videosystem.DVDPack;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml")
public class DVDPlayerXmlConfigTest {
	
	// 예외 발생
	// XML Bean(Avengers) 설정에서는 id를 자동으로 부여하지 않는다.
	// 따라서 @Qualifier를 사용할 수 없음
	// @Autowired
	private DigitalVideoDisc dvd1;
	
	@Qualifier("ironMan")
	@Autowired
	private DigitalVideoDisc dvd2;

	@Qualifier("avengersInfinityWar")
	@Autowired
	private DigitalVideoDisc dvd3;
	
	@Qualifier("avengersEndGame")
	@Autowired
	private DigitalVideoDisc dvd4;
	
	@Qualifier("avengersAgeofUltron")
	@Autowired
	private DigitalVideoDisc dvd5;
	
	@Qualifier("avengersCaptainAmerica")
	@Autowired
	private DigitalVideoDisc dvd6;
	
	@Qualifier("avengersDirectorEdition")
	@Autowired
	private DigitalVideoDisc dvd7;
	
	@Autowired
	private DVDPack dvdPack;
	
	@Qualifier("avengersExpansionEdition1")
	@Autowired
	private DigitalVideoDisc dvd8;
	
	@Qualifier("avengersExpansionEdition2")
	@Autowired
	private DigitalVideoDisc dvd9;
	
	@Qualifier("avengersExpansionEdition3")
	@Autowired
	private DigitalVideoDisc dvd10;
	
	@Qualifier("dvdPlayer1")
	@Autowired
	private DVDPlayer dvdPlayer1;
		
	@Qualifier("dvdPlayer2")
	@Autowired
	private DVDPlayer dvdPlayer2;
	
	@Qualifier("dvdPlayer3")
	@Autowired
	private DVDPlayer dvdPlayer3;
	
	@Qualifier("dvdPlayer4")
	@Autowired
	private DVDPlayer dvdPlayer4;
	
	@Qualifier("dvdPlayer5")
	@Autowired
	private DVDPlayer dvdPlayer5;
	
	@Disabled
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
		assertNotNull(dvdPack);
		System.out.println(dvdPack);
	}
	
	@Test
	public void testDVD8() {
		assertNotNull(dvd8);
	}
	
	@Test
	public void testDVD9() {
		assertNotNull(dvd9);
	}
	
	@Test
	public void testDVD10() {
		assertNotNull(dvd10);
	}
	
	@Test
	public void testDVDPlayer1() {
		assertEquals("Playing Movie MARVEL's Iron Man", dvdPlayer1.play());
		assertEquals("Playing Movie MARVEL's Iron Man", dvdPlayer2.play());
		assertEquals("Playing Movie MARVEL's Iron Man", dvdPlayer3.play());
		assertEquals("Playing Movie MARVEL's Iron Man", dvdPlayer4.play());
		assertEquals("Playing Movie MARVEL's Iron Man", dvdPlayer5.play());
	}
	
}
