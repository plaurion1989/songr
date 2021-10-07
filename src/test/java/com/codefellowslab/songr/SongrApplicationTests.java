package com.codefellowslab.songr;

import com.codefellowslab.songr.models.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void Test_album_unit_test()
	{
		Album sut = new Album("test", "your", 5, 6, "heart out");

		assertEquals("test" , sut.getTitle());
		assertEquals("your" , sut.getArtist());
		assertEquals(5 , sut.getSongCount());
		assertEquals(6 , sut.getLength());
		assertEquals("heart out" , sut.getImageUrl());
	}

	@Test
	public void Test_songr_app() throws Exception
	{
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(content().string(containsString("<h1>Songr Java Application</h1>")))
				.andExpect(status().isOk());

	}

}
