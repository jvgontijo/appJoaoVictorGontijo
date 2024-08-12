package br.com.infnet.appJoaoVictorGontijo;

import br.com.infnet.appJoaoVictorGontijo.character.CharacterLoader;
import br.com.infnet.appJoaoVictorGontijo.character.CharacterService;
import br.com.infnet.appJoaoVictorGontijo.user.UserLoader;
import br.com.infnet.appJoaoVictorGontijo.user.UserService;

import java.io.IOException;

public class Loader {

    public static void main(String[] args) throws IOException {
        UserService userService = new UserService();
        CharacterService characterService = new CharacterService();

        UserLoader userLoader = new UserLoader(userService, characterService);
        CharacterLoader characterLoader = new CharacterLoader(characterService);

        characterLoader.loadFromFile();
        userLoader.loadFromFile();

        System.out.println(" --- Inicio UserLoader ---");
        System.out.println(userLoader);
        System.out.println(" --- Fim UserLoader ---");

        System.out.println(" --- Inicio Character Loading ---");
        System.out.println(characterLoader);
        System.out.println(" --- Fim Character Loading ---");
    }
}
