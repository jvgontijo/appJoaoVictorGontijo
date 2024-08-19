package br.com.infnet.appJoaoVictorGontijo.character;

import br.com.infnet.appJoaoVictorGontijo.FileLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Component
public class CharacterLoader implements FileLoader {

    private final CharacterService characterService;

    public CharacterLoader(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public void loadFromFile() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/characters.txt"));
        Character character = null;

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("Character {")) {
                character = new Character();
            } else if (line.startsWith("id:")) {
                character.setId(UUID.fromString(line.split(":")[1].trim()));
            } else if (line.startsWith("userId:")) {
                character.setUserId(UUID.fromString(line.split(":")[1].trim()));
            } else if (line.startsWith("name:")) {
                character.setName(line.split(":")[1].trim());
            } else if (line.startsWith("age:")) {
                character.setAge(Integer.parseInt(line.split(":")[1].trim()));
            } else if (line.startsWith("weapon:")) {
                character.selectWeapon(Weapon.valueOf(line.split(":")[1].trim()));
            } else if (line.startsWith("}")) {
                characterService.add(character);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character character : characterService.get()) {
            sb.append(character.toString()).append("\n");
        }
        return sb.toString();
    }

}