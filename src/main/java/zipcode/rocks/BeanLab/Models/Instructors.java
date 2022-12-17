package zipcode.rocks.BeanLab.Models;

import java.util.Iterator;
import java.util.List;

import zipcode.rocks.BeanLab.Repositories.People;

public class Instructors extends People<Instructor>{

    public Instructors(List<Instructor> personList) {
        super(personList);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Iterator<Instructor> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
