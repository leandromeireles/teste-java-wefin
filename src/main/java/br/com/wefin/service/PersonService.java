package br.com.wefin.service;

import br.com.wefin.models.TypePerson;
import br.com.wefin.payload.request.PersonRequest;
import br.com.wefin.payload.response.TypePersonResponse;

public interface PersonService {

    void registerPerson(PersonRequest person);

    TypePersonResponse getTypePerson(String cpfOrCnpj);
}
