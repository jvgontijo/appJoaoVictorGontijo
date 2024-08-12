package br.com.infnet.appJoaoVictorGontijo;

import br.com.infnet.appJoaoVictorGontijo.character.CharacterLoader;
import br.com.infnet.appJoaoVictorGontijo.user.UserLoader;

public class Loader {

    public static void main(String[] args) {
        UserLoader userLoader = new UserLoader();
        userLoader.loadFromFile();

        CharacterLoader characterLoader = new CharacterLoader();
        characterLoader.loadFromFile();
    }
}
