package com.douzone.container.config.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.soundsystem.CDPlayer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:com/douzone/container/config/soundsystem/CDPlayerConfig.xml")
public class DVDPlayerXmlConfigTest {
		
	@Autowired
	CDPlayer cdPlayer;
		
	@Test
	public void testCDPlayerNot() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing 붕붕 by 김하온", cdPlayer.play());
	}
}
