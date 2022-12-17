package zipcode.rocks.BeanLab.Config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zipcode.rocks.BeanLab.Models.Classroom;
import zipcode.rocks.BeanLab.Models.Instructor;
import zipcode.rocks.BeanLab.Models.Student;

@Configuration
public class ClassroomConfig {

    @Autowired
    InstructorsConfig instructorsConfig;

    @Autowired
    StudentConfig studentsConfig;

    @Bean
    public Classroom currentCohort(List<Instructor> instructors, List<Student> students) {
        return new Classroom(instructorsConfig.instructors(instructors), studentsConfig.currentStudents(students));
    }

    @Bean
    public Classroom previousCohort(List<Instructor> instructors, List<Student> students) {
        return new Classroom(instructorsConfig.instructors(instructors), studentsConfig.previousStudents(students));
    }



}
