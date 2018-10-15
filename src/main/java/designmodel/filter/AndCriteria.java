package main.java.designmodel.filter;

import main.java.designmodel.filter.Criteria;
import main.java.designmodel.filter.Person;

import java.util.List;

public class AndCriteria implements Criteria {
    private Criteria otherCriteria;
    private Criteria anotherCriteria;
    public AndCriteria(Criteria otherCriteria,Criteria anotherCriteria){
        this.otherCriteria = otherCriteria;
        this.anotherCriteria = anotherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        return anotherCriteria.meetCriteria(otherCriteria.meetCriteria(persons));
    }
}
