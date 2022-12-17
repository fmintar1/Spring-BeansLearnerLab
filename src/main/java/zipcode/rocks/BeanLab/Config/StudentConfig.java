package zipcode.rocks.BeanLab.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zipcode.rocks.BeanLab.Models.Student;
import zipcode.rocks.BeanLab.Models.Students;

@Configuration
public class StudentConfig {
    
    @Bean(name = "students")
    public Students currentStudents(List<Student> students) {
        return new Students(students);
    }

    @Bean
    public Students previousStudents(List<Student> currentCohort) {
        return new Students(currentCohort);
    }
}
