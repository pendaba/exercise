package main.java.designmodel.filter;

import main.java.designmodel.filter.Criteria;
import main.java.designmodel.filter.Person;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaSingle implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        return persons.stream().filter(person -> person.getMaritalStatus().equalsIgnoreCase("single")).collect(Collectors.toList());
    }
}
