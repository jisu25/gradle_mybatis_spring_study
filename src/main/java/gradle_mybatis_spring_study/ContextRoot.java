package gradle_mybatis_spring_study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ContextDataSource.class, ContextSqlSession.class/*, ContextTransaction.class*/})
@ComponentScan(basePackages = {
		"gradle_mybatis_spring_study.mapper",
		"gradle_mybatis_spring_study.service"})
public class ContextRoot {

}
