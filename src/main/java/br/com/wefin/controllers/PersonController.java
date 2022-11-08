package br.com.wefin.controllers;

import br.com.wefin.payload.request.PersonRequest;
import br.com.wefin.payload.response.TypePersonResponse;
import br.com.wefin.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(value = "person")
@RequestMapping("/api/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping()
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  @ApiOperation(value = "registerPerson")
  public void registerPerson(@Valid @RequestBody PersonRequest person) {

    personService.registerPerson(person);
  }

    @GetMapping("/cpf-cnpj")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation(value = "getTypePerson")
    public TypePersonResponse getTypePerson(@RequestParam String cpfOrCnpj)  {

      return personService.getTypePerson(cpfOrCnpj);
    }

}
