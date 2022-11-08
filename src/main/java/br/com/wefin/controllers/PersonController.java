package br.com.wefin.controllers;

import br.com.wefin.models.TypePerson;
import br.com.wefin.payload.request.PersonRequest;
import br.com.wefin.payload.response.TypePersonResponse;
import br.com.wefin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping()
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public void registerPerson(@Valid @RequestBody PersonRequest person) {

    personService.registerPerson(person);
  }

    @GetMapping("/cpf-cnpj")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public TypePersonResponse getTypePerson(@RequestParam String cpfOrCnpj)  {

      return personService.getTypePerson(cpfOrCnpj);
    }

}
