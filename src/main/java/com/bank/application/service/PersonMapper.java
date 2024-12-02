package com.bank.application.service;

import com.bank.application.repository.entity.Person;
import com.bank.model.PersonRequest;
import com.bank.model.PersonResponse;

public class PersonMapper {
    public static PersonResponse mapToPersonResponse(Person person, PersonResponse personResponse){
        personResponse.setFirstName(person.getFirstName());
        personResponse.setLastName(person.getLastName());
        personResponse.setEmail(person.getEmail());
        personResponse.setPhoneNumber(person.getPhoneNumber());

        return personResponse;
    }

    public static Person mapToPersonEntity(PersonRequest personRequest, Person person){
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setEmail(personRequest.getEmail());
        person.setPhoneNumber(personRequest.getPhoneNumber());
        person.setPassword(personRequest.getPassword());

        return person;
    }

    public static PersonResponse mapToPersonResponse11(PersonRequest personRequest, PersonResponse personResponse){
        personResponse.setFirstName(personRequest.getFirstName());
        personResponse.setLastName(personRequest.getLastName());
        personResponse.setEmail(personRequest.getEmail());
        personResponse.setPhoneNumber(personRequest.getPhoneNumber());

        return personResponse;
    }
}
