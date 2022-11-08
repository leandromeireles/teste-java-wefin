package br.com.wefin.models;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClientGroupSequenceProvider implements DefaultGroupSequenceProvider<Person> {


    @Override
    public List<Class<?>> getValidationGroups(Person person) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Person.class);

        if(isPersonSelect(person)){

            groups.add(person.getTypePerson().getGroup());
        }
        return groups;
    }

    protected boolean isPersonSelect(Person person){

        return person != null && person.getTypePerson() != null;
    }
}
