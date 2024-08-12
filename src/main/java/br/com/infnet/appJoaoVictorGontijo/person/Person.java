package br.com.infnet.appJoaoVictorGontijo.person;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Person {

    private UUID id;

    private String name;

    private int age;
}
