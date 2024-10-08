package br.com.infnet.appJoaoVictorGontijo.character;

import br.com.infnet.appJoaoVictorGontijo.person.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
public class Character extends Person {

    private final LocalDate creationDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UUID userId;

    @ElementCollection
    @CollectionTable(name = "character_weapons", joinColumns = @JoinColumn(name = "character_id"))
    @Enumerated(STRING)
    private List<Weapon> weapons = new ArrayList<>();

    @Embedded
    private Appearance appearance = new Appearance();

    private boolean isBrought = false;

    public Character() {
    }

    public Character(List<Weapon> weapons, Appearance appearance) {
        super();
        this.weapons = weapons;
        this.appearance = appearance;
    }

    public void selectWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void customizeAppearance(Appearance appearance) {
        this.appearance.updateAppearance(
                appearance.getHairColor(),
                appearance.getEyesColor(),
                appearance.getHeight(),
                appearance.getWeight(),
                appearance.isVisible()
        );
    }

    public void hasBeenBrought() {
        this.isBrought = true;
    }

    @Override
    public String toString() {
        return "Character { " + "\n" +
                "userId: " + this.getUserId() + "\n" +
                "id: " + this.getId() +
                ", name: " + this.getName() +
                ", age: " + this.getAge() +
                ", creationDate: " + this.creationDate +
                ", weapons: " + this.weapons +
                ", isBrought: " + this.isBrought + ",\n" +
                "appearance: " + this.appearance +
                "} " + "\n";
    }
}
