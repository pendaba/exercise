package main.java.designmodel.filter;

import main.java.designmodel.filter.Criteria;
import main.java.designmodel.filter.Person;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrCriteria implements Criteria {
    private Criteria otherCriteria;
    private Criteria anotherCriteria;
    public OrCriteria(Criteria otherCriteria,Criteria anotherCriteria){
        this.otherCriteria = otherCriteria;
        this.anotherCriteria = anotherCriteria;
    }
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        /*List<Person> firstCriteriaItems = otherCriteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = anotherCriteria.meetCriteria(persons);

        for (Person person : otherCriteriaItems) {
            if(!firstCriteriaItems.contains(person)){
                firstCriteriaItems.add(person);
            }
        }
        return firstCriteriaItems;*/
        List<Person> firstPersons = otherCriteria.meetCriteria(persons);
        firstPersons.addAll(anotherCriteria.meetCriteria(persons));
        return firstPersons.stream().distinct().collect(Collectors.toList());
    }
}
