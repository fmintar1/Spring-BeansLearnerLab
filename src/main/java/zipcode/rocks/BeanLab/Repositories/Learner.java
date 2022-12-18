package zipcode.rocks.BeanLab.Repositories;

import java.util.Collection;

public interface Learner extends Collection<Learner>{

    public void learn(double numberOfHours);
    
}
