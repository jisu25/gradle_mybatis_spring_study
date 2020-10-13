package gradle_mybatis_spring_study.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gradle_mybatis_spring_study.dto.Student;
import gradle_mybatis_spring_study.resulthandlers.StudentResultHandler;

@Service
public class StudentService {
	private final String namespace = "gradle_mybatis_spring_study.mapper.StudentMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public Map<Integer, String> selectStudentForMap(int studId) {
		Map<Integer, String> map = new HashMap<>();
		StudentResultHandler resultHandler = new StudentResultHandler(map);
		
		sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);
		return map;
	}
	
	// 내부 클래스 이용
	public Map <Integer, Student> selectStudentForMap2(int studId) {
		Map<Integer, Student> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
			}
		};
		
		sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);
		return map;
	}
 }
