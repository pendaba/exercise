package main.java.designmodel.filter;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        /*List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("MALE")){
                malePersons.add(person);
            }
        }*/
        return persons.stream().filter(person -> person.getGender().equalsIgnoreCase("MALE")).collect(Collectors.toList());
    }


}
