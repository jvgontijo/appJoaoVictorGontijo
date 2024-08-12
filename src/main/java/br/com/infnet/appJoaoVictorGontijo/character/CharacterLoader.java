package br.com.infnet.appJoaoVictorGontijo.character;

import br.com.infnet.appJoaoVictorGontijo.FileLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CharacterLoader implements FileLoader {

    @Override
    public List<Character> loadFromFile() {
        String filePath = "src/main/resources/characters.txt";
        List<Character> characters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Character character = null;
            List<Weapon> weapons = new ArrayList<>(Collections.emptyList());
            Appearance appearance = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Character {")) {
                    character = new Character();
                    weapons = new ArrayList<>();
                    appearance = new Appearance();
                } else if (line.startsWith("userId:")) {
                    character.setUserId(UUID.fromString(line.split(":")[1].trim()));
                } else if (line.startsWith("name:")) {
                    character.setName(line.split(":")[1].trim());
                } else if (line.startsWith("age:")) {
                    character.setAge(Integer.parseInt(line.split(":")[1].trim()));
                } else if (line.startsWith("weapon:")) {
                    weapons.add(Weapon.valueOf(line.split(":")[1].trim().toUpperCase()));
                } else if (line.startsWith("hairColor:")) {
                    appearance.setHairColor(line.split(":")[1].trim());
                } else if (line.startsWith("eyeColor:")) {
                    appearance.setEyesColor(line.split(":")[1].trim());
                } else if (line.startsWith("height:")) {
                    appearance.setHeight(Double.parseDouble(line.split(":")[1].trim()));
                } else if (line.startsWith("weight:")) {
                    appearance.setWeight(Double.parseDouble(line.split(":")[1].trim()));
                } else if (line.startsWith("isVisible:")) {
                    appearance.setVisible(Boolean.parseBoolean(line.split(":")[1].trim()));
                } else if (line.startsWith("}")) {
                    character.setWeapons(weapons);
                    character.setAppearance(appearance);
                    characters.add(character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--- Inicio CharacterLoader ---");
        characters.forEach(System.out::println);
        System.out.println("--- Fim CharacterLoader ---");

        return characters;
    }
}