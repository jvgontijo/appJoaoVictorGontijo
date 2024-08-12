package br.com.infnet.appJoaoVictorGontijo.user;

import br.com.infnet.appJoaoVictorGontijo.character.Character;
import br.com.infnet.appJoaoVictorGontijo.person.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends Person {

    private String email;

    private List<Character> characters;

    public Character createCharacter() {
        return new Character();
    }

    public void purchaseCharacter(Character character) {
        character.hasBeenBrought();
    }

    @Override
    public String toString() {
        return "User { " + "\n" +
                "name: " + this.getName() +
                ", age: " + this.getAge() +
                ", email: '" + email + ",\n" +
                "characters: " + characters +
                "}" + "\n";
    }
}
