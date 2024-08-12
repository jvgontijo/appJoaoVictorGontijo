package br.com.infnet.appJoaoVictorGontijo.person;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Person {

    private final UUID id = UUID.randomUUID();

    private String name;

    private int age;
}
