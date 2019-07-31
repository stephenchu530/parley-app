package com.parley.parley;

import com.parley.parley.models.UserAccount;
import com.parley.parley.repository.RoleRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration
@WebAppConfiguration
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParleyApplicationTests {
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

//	@Before
//	public void setup(){
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
//	}
//	public static RequestPostProcessor testUser(){
//		return user("TestUser").password("pass");
//	}

//	public UserAccount createTestUser(){
//		UserAccount testUser = new UserAccount ("joe", "smith", "joe", "password", "joe@smith.com");
//		testUser.getRoleTypes().add(roleRepository.findByRole("admin"));
//		return testUser;
//	}

	public static RequestPostProcessor testUser(){
		return user("user").password("pass").authorities(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "role_admin";
			}
		});
	}

	@Test
	public void testMyProfileNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/myprofile")).andExpect(status().is3xxRedirection());	}

	@Test
	public void testLoginNotSignedIn() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testLogoutCompletedNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/logout_complete")).andExpect(status().isOk());
	}

	@Test
	public void testAboutUsNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/aboutus")).andExpect(status().isOk());
	}

	@Test
	public void contextLoads(){
	}

	@WithMockUser
	@Test
	public void testSignedInMyProfile() throws Exception {
		mockMvc.perform(get("/myprofile").with(testUser())).andExpect(content().string(containsString("Welcome, ")));
	}

}
