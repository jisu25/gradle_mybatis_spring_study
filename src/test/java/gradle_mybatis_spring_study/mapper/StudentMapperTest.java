package gradle_mybatis_spring_study.mapper;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gradle_mybatis_spring_study.ContextRoot;
import gradle_mybatis_spring_study.dto.Gender;
import gradle_mybatis_spring_study.dto.PhoneNumber;
import gradle_mybatis_spring_study.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
public class StudentMapperTest {

	protected static final Log log= LogFactory.getLog(StudentMapperTest.class);
	
	@Autowired
	private StudentMapper mapper;
	
	@After
	public void tearDown() throws Exception {
	   System.out.println();
	}
	
	@Test
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectedStd = mapper.selectStudentByNo(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}
	
	@Test
	public void test02SelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		mapper.selectStudentByNo(student);
		Student selectedStd = mapper.selectStudentByNoWithResultMap(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}
	
	@Test
	public void test03SelectStudentAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> list = mapper.selectStudentAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test04InsertStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student std = new Student();
		std.setStudId(4);
		std.setName("banana");
		std.setEmail("banana@gmail.com");
		std.setPhone(new PhoneNumber("010-1234-1234"));
		std.setDob(newDate.getTime());
		int res = mapper.insertStudent(std);
		log.debug(mapper.selectStudentByNo(std).toString());
		log.debug("res: " + res);
	}
	
	@Test
	public void test05UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student std = new Student();
		std.setStudId(4);
		std.setName("banana");
		std.setEmail("banana@banana.com");
		std.setPhone(new PhoneNumber("010-1234-4321"));
		std.setDob(newDate.getTime());
		int res = mapper.updateStudent(std);
		log.debug(mapper.selectStudentByNo(std).toString());
		log.debug("res: " + res);
	}
	
	@Test
	public void test06DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student std = new Student();
		std.setStudId(4);
		int res = mapper.deleteStudent(std);
		log.debug("res: " + res);
	}
	
	@Test
	public void test07SelectStudentAllWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> list = mapper.selectStudentAllWithResultMap();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test08SelectStudentAllWithHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Map<String, Object>> list = mapper.selectStudentAllWithHashMap();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test09SelectStudentByNoAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		List<Student> list = mapper.selectStudentByNoAssociation(student);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
//	@Test
	public void test10InsertStudentForEnum() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student std = new Student();
		std.setStudId(5);
		std.setName("banana");
		std.setEmail("banana@gmail.com");
		std.setPhone(new PhoneNumber("010-1234-1234"));
		std.setDob(newDate.getTime());
		std.setGender(Gender.FEMALE);
		int res = mapper.insertStudent(std);
		log.debug(mapper.selectStudentByNo(std).toString());
		log.debug("res: " + res);
	}
	
	@Test
	public void test11SelectStudentByNoForEnum() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectedStd = mapper.selectStudentByNoForEnum(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}

	@Test
	public void test12SelectStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, String> maps = new HashMap<>();
		maps.put("name", "Timothy");
		maps.put("email", "timothy@gmail.com");
		Student student = mapper.selectStudentByMap(maps);
		Assert.assertNotNull(student);
		log.debug(student.toString());
		
		maps.remove("email");
		student = mapper.selectStudentByMap(maps);
		log.debug(student.toString());
		
		maps.clear();
		maps.put("email", "timothy@gmail.com");
		student = mapper.selectStudentByMap(maps);
		log.debug(student.toString());
	}
	
	@Test
	public void test13SelectStudentAllByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("name", "Timothy");
		maps.put("email", "timothy@gmail.com");
		List<Student> list = mapper.selectStudentAllByMap(maps);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		maps.remove("email");
		list = mapper.selectStudentAllByMap(maps);
		list.stream().forEach(System.out::println);
		
		maps.clear();
		maps.put("email", "timothy@gmail.com");
		list = mapper.selectStudentAllByMap(maps);
		list.stream().forEach(System.out::println);
		
		maps.clear();
		list = mapper.selectStudentAllByMap(maps);
		list.stream().forEach(System.out::println);
		
	}
}
