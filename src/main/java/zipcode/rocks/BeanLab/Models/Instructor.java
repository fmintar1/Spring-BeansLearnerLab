package zipcode.rocks.BeanLab.Models;

import java.util.Collection;
import zipcode.rocks.BeanLab.Repositories.Learner;
import zipcode.rocks.BeanLab.Repositories.Teacher;

public class Instructor extends Person implements Teacher {

    public Instructor(Long id, String name) {
        super(id, name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
        // TODO Auto-generated method stub
        
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        Double numberOfHoursPerLearner = numberOfHours / ((Collection<?>) learners).size();
        for(Learner l : learners) {
            l.learn(numberOfHoursPerLearner);
        }
        // int count = 0;
        // for(Learner l : learners) {
        //     count++;
        // }
        // for(Learner l : learners) {
        //     l.learn(numberOfHours/count);
        // }
        // TODO Auto-generated method stub
    }
}
