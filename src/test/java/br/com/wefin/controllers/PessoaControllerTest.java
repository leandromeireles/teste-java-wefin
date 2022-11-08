package br.com.wefin.controllers;

import br.com.wefin.models.Person;
import br.com.wefin.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;


@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerTest {

    @Autowired
    private PersonRepository repository;


    @Test
    public void registerCpfConstraintViolationException() throws Exception {

        StringBuilder cpfRequest = new StringBuilder();
        cpfRequest.append("8866886068");
        cpfRequest.append(+1);

        Person cpf = new Person();
        cpf.setCpf(cpfRequest.toString());
        Assertions.assertThrows(ConstraintViolationException.class, ()->{
            repository.save(cpf);
        });
    }


    @Test
    public void registerCpfDataIntegrityViolationException() throws Exception {

        String cpfRequest = "88668860682";
        Person cpf = new Person();
        cpf.setCpf(cpfRequest);
        Assertions.assertThrows(DataIntegrityViolationException.class, ()->{
            repository.save(cpf);
        });
    }

    @Test
    public void getCpf() throws Exception {

        StringBuilder cpfRequest = new StringBuilder();
        cpfRequest.append("88668860682");
        Person cpf = new Person();
        cpf.setCpf(cpfRequest.toString());
        repository.existsByCpf(cpf.getCpf());


    }
}