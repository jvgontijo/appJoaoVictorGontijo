package br.com.infnet.appJoaoVictorGontijo.user;

import br.com.infnet.appJoaoVictorGontijo.FileLoader;
import br.com.infnet.appJoaoVictorGontijo.character.Character;
import br.com.infnet.appJoaoVictorGontijo.character.CharacterLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserLoader implements FileLoader {

    @Override
    public List<User> loadFromFile() {
        String filePath = "src/main/resources/users.txt";
        List<User> users = new ArrayList<>();
        CharacterLoader characterLoader = new CharacterLoader();
        List<Character> allCharacters = characterLoader.loadFromFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            User user = new User();
            List<Character> characters = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User {")) {
                    user = new User();
                    characters = new ArrayList<>();
                } else if (line.startsWith("id:")) {
                    UUID userId = UUID.fromString(line.split(":")[1].trim());
                    characters = filterCharactersByUserId(allCharacters, userId);
                } else if (line.startsWith("name:")) {
                    user.setName(line.split(":")[1].trim());
                } else if (line.startsWith("age:")) {
                    user.setAge(Integer.parseInt(line.split(":")[1].trim()));
                } else if (line.startsWith("email:")) {
                    user.setEmail(line.split(":")[1].trim());
                } else if (line.startsWith("}")) {
                    user.setCharacters(characters);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--- Inicio UserLoader ---");
        users.forEach(System.out::println);
        System.out.println("--- Fim UserLoader ---");
        return users;
    }

    private List<Character> filterCharactersByUserId(List<Character> characters, UUID userId) {
        return characters.stream()
                .filter(it -> it.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
