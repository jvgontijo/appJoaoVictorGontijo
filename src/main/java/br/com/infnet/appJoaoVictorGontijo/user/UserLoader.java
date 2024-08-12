package br.com.infnet.appJoaoVictorGontijo.user;

import br.com.infnet.appJoaoVictorGontijo.FileLoader;
import br.com.infnet.appJoaoVictorGontijo.character.Character;
import br.com.infnet.appJoaoVictorGontijo.character.CharacterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserLoader implements FileLoader {

    private final UserService userService;
    private final CharacterService characterService;

    public UserLoader(UserService userService, CharacterService characterService) {
        this.userService = userService;
        this.characterService = characterService;
    }

    @Override
    public void loadFromFile() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/users.txt"));
        User user = null;
        boolean isParsingCharacters = false;
        List<UUID> characterIds = new ArrayList<>();

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("User {")) {
                user = new User();
            } else if (line.startsWith("id:")) {
                user.setId(UUID.fromString(line.split(":")[1].trim()));
            } else if (line.startsWith("name:")) {
                user.setName(line.split(":")[1].trim());
            } else if (line.startsWith("age:")) {
                user.setAge(Integer.parseInt(line.split(":")[1].trim()));
            } else if (line.startsWith("email:")) {
                user.setEmail(line.split(":")[1].trim());
            } else if (line.startsWith("characters:")) {
                isParsingCharacters = true;
            } else if (isParsingCharacters) {
                if (line.equals("]")) {
                    isParsingCharacters = false;
                    associateCharactersToUser(user, characterIds);
                    characterIds.clear();
                } else {
                    UUID characterId = UUID.fromString(line.replace("\"", "").replace(",", "").trim());
                    characterIds.add(characterId);
                }
            } else if (line.startsWith("}")) {
                if (user != null) {
                    userService.add(user);
                }
            }
        }
    }

    private void associateCharactersToUser(User user, List<UUID> characterIds) {
        if (user != null) {
            for (UUID characterId : characterIds) {
                Character character = characterService.getCharacterById(characterId);
                if (character != null) {
                    user.getCharacters().add(character);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (User user : userService.get()) {
            sb.append(user.toString()).append("\n");
        }
        return sb.toString();
    }

}
