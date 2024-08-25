package br.com.infnet.appJoaoVictorGontijo.user;

import br.com.infnet.appJoaoVictorGontijo.character.Character;
import br.com.infnet.appJoaoVictorGontijo.person.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Character> characters = new ArrayList<>();

    public Character createCharacter() {
        return new Character();
    }

    public void purchaseCharacter(Character character) {
        character.hasBeenBrought();
    }

    @Override
    public String toString() {
        return "User { " + "\n" +
                "id: " + this.getId() +
                ", name: " + this.getName() +
                ", age: " + this.getAge() +
                ", email: " + this.email +
                ", quantidade de personagens: " + this.characters.size() + ",\n" +
                "personagens: " + this.characters +
                "}" + "\n";
    }
}
