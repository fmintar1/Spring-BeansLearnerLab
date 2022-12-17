package zipcode.rocks.BeanLab.Models;

import java.util.Iterator;
import java.util.List;

import zipcode.rocks.BeanLab.Repositories.People;

public class Students extends People<Student> {

    public Students(List<Student> personList) {
        super(personList);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Iterator<Student> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
