package br.com.wefin.service;

import br.com.wefin.models.Person;
import br.com.wefin.models.TypePerson;
import br.com.wefin.payload.request.PersonRequest;
import br.com.wefin.payload.response.TypePersonResponse;
import br.com.wefin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  public PersonRepository personRepository;
  @Override
  public void registerPerson(PersonRequest person) {

      Person personRegistration = new Person();
      personRegistration.setName(person.getName());
      personRegistration.setCpfCnpj(person.getCpfOrCnpj());
      personRegistration.setTypePerson(getTypePersonEnum(person.getCpfOrCnpj()));
      personRepository.save(personRegistration);

  }

    private TypePerson getTypePersonEnum(String cpfOrCnpj) {

      if(cpfOrCnpj.length() == 11){
          return TypePerson.FISICA;
      }
      return TypePerson.JURIDICA;

    }

    @Override
    public TypePersonResponse getTypePerson(String cpfOrCnpj) {

        var person = personRepository.getPersonByCpfCnpj(cpfOrCnpj);

        var typePerson = TypePersonResponse.builder().typePerson(person.get().getTypePerson().toString()).build();


        return typePerson;

      }
}
