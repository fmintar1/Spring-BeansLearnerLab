package zipcode.rocks.BeanLab.Config;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zipcode.rocks.BeanLab.Models.Student;
import zipcode.rocks.BeanLab.Models.Students;

@Configuration
public class StudentConfig {
    
    @Bean(name = "students")
    public Students currentStudents() {
        ArrayList<Student> aList = new ArrayList<>();
        aList.add(new Student(1L, "Prathibha Annamaneni"));
        aList.add(new Student(2L, "Andrew Ascone"));
        aList.add(new Student(3L, "Troyanne Butler"));
        aList.add(new Student(4L, "Daniel Casey"));
        aList.add(new Student(5L, "Nina Chen"));
        aList.add(new Student(6L, "Collin Cleveland"));
        aList.add(new Student(7L, "Taylor Corbin"));
        aList.add(new Student(8L, "Elijha Couch"));
        aList.add(new Student(9L, "Carolina Diazgranados"));
        aList.add(new Student(10L, "Kash Elcock"));
        aList.add(new Student(11L, "Anna Fu"));
        aList.add(new Student(12L, "Deepthi Ganji"));
        aList.add(new Student(13L, "Tarin Jahan"));
        aList.add(new Student(14L, "Thien Le"));
        aList.add(new Student(15L, "Eryk Liszewski"));
        aList.add(new Student(16L, "Hanquan Liu"));
        aList.add(new Student(17L, "Emory Miller"));
        aList.add(new Student(18L, "Freddy Mintarja"));
        aList.add(new Student(19L, "John Morris"));
        aList.add(new Student(20L, "Zachary Prongua"));
        aList.add(new Student(21L, "Adrienne Rainey"));
        aList.add(new Student(22L, "Calvin Tran"));
        aList.add(new Student(23L, "Yingjie Yang"));
        return new Students(aList);
    }

    @Bean
    public Students previousStudents(List<Student> currentCohort) {
        return new Students(currentCohort);
    }
}
