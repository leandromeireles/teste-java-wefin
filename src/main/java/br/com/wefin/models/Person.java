package br.com.wefin.models;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cpf_cnpj")
        })
@GroupSequenceProvider(ClientGroupSequenceProvider.class)
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Nome é obrigatório")
  private String name;

  @NotNull(message = "Tipo Pessoa é obrigatória")
  @Enumerated(EnumType.STRING)
  @Column(name = "type_person")
  private TypePerson typePerson;

  @NotBlank(message = "CPF/CNPJ é obrigatório")
  @CNPJ(groups = CnpjGroup.class)
  @CPF(groups = CpfGroup.class)
  @Column(name = "cpf_cnpj")
  private String cpfCnpj;

  public Person() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TypePerson getTypePerson() {
    return typePerson;
  }

  public void setTypePerson(TypePerson typePerson) {
    this.typePerson = typePerson;
  }

  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfOrCnpj) {
    this.cpfCnpj = cpfOrCnpj;
  }
}
