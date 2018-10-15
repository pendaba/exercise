package main.java.designmodel.filter;

import java.util.List;

public interface Criteria {
     List<Person> meetCriteria(List<Person> persons);
}
