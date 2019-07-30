package com.parley.parley;

import com.parley.parley.controllers.DummyController;
import com.parley.parley.models.Assessments;
import com.parley.parley.repository.AssessmentsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParleyApplicationTests {

	@Autowired
	AssessmentsRepository assessmentsRepository;

	@Test
	public void contextLoads(){
	}

//	@Test
//	public void testFileCreate() throws FileNotFoundException {
//		long id = 1;
//		Assessments testAss = assessmentsRepository.findById(id).get();
//		testContr.saveToTxt(testAss);
//	}

}
