package zipcode.rocks.BeanLab.Alumni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import zipcode.rocks.BeanLab.Models.Instructors;
import zipcode.rocks.BeanLab.Models.Student;
import zipcode.rocks.BeanLab.Models.Students;

@Component
public class Alumni {

    @Autowired
    @Qualifier("previousStudents")
    Students students;

    @Autowired
    Instructors instructors;

    // @PostConstruct
    // public void executeBootcamp() {
    //     for(Instructor i : instructors.findAll()) {
    //         i.lecture(students, students.size()*1200);
    //     }
    // }

    @PostConstruct
    public void executeBootcamp() {
        for (Student s : students.findAll()) {
            s.learn(1200);
        }
    }

    public Students getStudents() {
        return students;
    }

    public Instructors getInstructors() {
        return instructors;
    }
    

}
