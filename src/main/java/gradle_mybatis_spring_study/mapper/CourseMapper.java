package gradle_mybatis_spring_study.mapper;

import java.util.List;
import java.util.Map;

import gradle_mybatis_spring_study.dto.Course;

public interface CourseMapper {
	
	/* 동적 SQL - if */
	List<Course> selectCourseByCondition(Map<String, Object> map);
	
	/* 동적 SQL - chose */
	List<Course> selectCaseCourses(Map<String, Object> map);
	
	/* 동적 SQL - where */
	List<Course> selectWhereCourses(Map<String, Object> map);
	
}
