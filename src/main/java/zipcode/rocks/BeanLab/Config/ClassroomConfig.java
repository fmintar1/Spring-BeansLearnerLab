package zipcode.rocks.BeanLab.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipcode.rocks.BeanLab.Models.Classroom;

@Configuration
public class ClassroomConfig {

    @Autowired
    InstructorsConfig instructorsConfig;

    @Autowired
    StudentConfig studentsConfig;

    @Bean
    public Classroom currentCohort() {
        return new Classroom(instructorsConfig.instructors(), studentsConfig.currentStudents());
    }

    @Bean
    public Classroom previousCohort() {
        return new Classroom(instructorsConfig.instructors(), studentsConfig.previousStudents());
    }



}
