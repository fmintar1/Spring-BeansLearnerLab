package zipcode.rocks.BeanLab.Models;

import zipcode.rocks.BeanLab.Repositories.Teacher;

public class Classroom {

    Instructors instructors;
    Students students;
    
    public Classroom(Instructors instructors, Students students) {
        this.instructors = instructors;
        this.students = students;
    }

    public void hostLecture(Teacher teacher, double numberOfHours) {
        teacher.lecture(students, numberOfHours);
    }

    public Instructors getInstructors() {
        return instructors;
    }

    public Students getStudents() {
        return students;
    }

}
