package zipcode.rocks.BeanLab.Repositories;

public interface Teacher {

    public void teach(Learner learner, double numberOfHours);

    public void lecture(Iterable<? extends Learner> learners, double numberOfHours);
    
}
