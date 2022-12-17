package zipcode.rocks.BeanLab.Models;

import zipcode.rocks.BeanLab.Repositories.Learner;

public class Student extends Person implements Learner {

    double totalStudyTime;

    public Student(Long id, String name) {
        super(id, name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void learn(double numberOfHours) {
        totalStudyTime = numberOfHours;
        // TODO Auto-generated method stub
        
    }

    public double getTotalStudyTime() {
        return totalStudyTime;
    }
    


}
