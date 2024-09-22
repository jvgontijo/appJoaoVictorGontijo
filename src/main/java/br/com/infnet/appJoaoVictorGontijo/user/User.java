package br.com.infnet.appJoaoVictorGontijo.user;

import br.com.infnet.appJoaoVictorGontijo.character.Character;
import br.com.infnet.appJoaoVictorGontijo.person.Person;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    @Email(message = "Email should be valid")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
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
