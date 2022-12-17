package zipcode.rocks.BeanLab.Repositories;

import java.util.List;

import zipcode.rocks.BeanLab.Models.Person;

public abstract class People <T extends Person> implements Iterable<T>{

    List<T> personList;

    public People(List<T> personList) {
        this.personList = personList;
    }
    
    public void add(T personType) {
        personList.add(personType);
    }

    public void remove(T personType) {
        personList.remove(personType);
    }

    public int size() {
        return personList.size();
    }

    public void clear() {
        personList.clear();
    }

    public void addAll(Iterable<T> personType) {
        for(T p : personType) {
            personList.add(p);
        }
    }

    public T findById(Long id) {
        for(T t : personList) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public List<T> findAll() {
        return personList;
    }
}
