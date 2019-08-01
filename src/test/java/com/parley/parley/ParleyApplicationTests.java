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

	public static RequestPostProcessor testUser(){
		return user("TestUser").password("pass");
	}

	public UserAccount createTestUser(){
		UserAccount testUser = new UserAccount ("joe", "smith", "joe", "password", "joe@smith.com");
		testUser.getRoleTypes().add(roleRepository.findByRole("admin"));
		return testUser;
	}

//	public static RequestPostProcessor testUser(){
//		return user("TestUser").password("pass").authorities(new GrantedAuthority() {
//			@Override
//			public String getAuthority() {
//				return "role_admin";
//			}
//		});
//	}

	@Test
	public void testMyProfileNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/myprofile")).andExpect(status().is3xxRedirection());	}

	@Test
	public void testScheduleNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/schedule")).andExpect(status().is3xxRedirection());	}

	@Test
	public void testAddPromptNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/addprompt")).andExpect(status().is3xxRedirection());	}

	@Test
	public void testMakeAdminNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/makeadmin")).andExpect(status().is3xxRedirection());	}

	@Test
	public void testAddClassNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/addclass")).andExpect(status().is3xxRedirection());	}

	@Test
	public void testAddStudentNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/addstudent")).andExpect(status().is3xxRedirection());	}

	@Test
	public void testEditProfileNotSignedIn() throws Exception{
		this.mockMvc.perform(get("/editprofile")).andExpect(status().is3xxRedirection());	}

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

//	@Test
//	@WithMockUser
//	public void testMyProfileSignedIn() throws Exception {
//		mockMvc.perform(get("/myprofile").with(testUser())).andExpect(status().isOk());
//	}

//	@WithMockUser
//	@Test
//	public void testLoginSignedIn() throws Exception {
//		this.mockMvc.perform(get("/login").with(testUser())).andExpect(status().isOk());
//	}

	@Test
	public void testCreateUser(){
		UserAccount testUser = new UserAccount();
		assertNotNull(testUser);
	}

}
