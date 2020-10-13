package gradle_mybatis_spring_study.mapper;

import java.util.List;
import java.util.Map;

import gradle_mybatis_spring_study.dto.Student;

public interface StudentMapper {
	
	// TypeHandler 이용
	Student selectStudentByNo(Student student);
	
	// ResultMap 이용
	Student selectStudentByNoWithResultMap(Student student);
	
	// List 반환
	List<Student> selectStudentAll();
	List<Student> selectStudentAllWithResultMap(); // resultMap
	List<Map<String, Object>> selectStudentAllWithHashMap(); // map
	List<Student> selectStudentByNoAssociation(Student student); // association with Address
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);

	// 열거타입
	int insertStudentForEnum(Student student); // typehandlers에 EnumOrdinalTypeHandler 추가
	Student selectStudentByNoForEnum(Student student);  // Enum도 읽으면서 association with Address
	
	/* 여러 개의 입력 파라미터 전달 */
	Student selectStudentByMap(Map<String, String> map);
	List<Student> selectStudentAllByMap(Map<String, String> map);
	
	/* ResultSet */
	Map<Integer, Student> selectStudentForMap(Student student);
	
}
