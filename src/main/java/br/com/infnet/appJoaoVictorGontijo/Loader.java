package br.com.infnet.appJoaoVictorGontijo;

import br.com.infnet.appJoaoVictorGontijo.character.CharacterLoader;
import br.com.infnet.appJoaoVictorGontijo.character.CharacterService;
import br.com.infnet.appJoaoVictorGontijo.user.UserLoader;
import br.com.infnet.appJoaoVictorGontijo.user.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Loader implements ApplicationRunner {

    private final UserLoader userLoader;

    private final CharacterLoader characterLoader;

    public Loader(UserLoader userLoader, CharacterLoader characterLoader) {
        this.userLoader = userLoader;
        this.characterLoader = characterLoader;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        characterLoader.loadFromFile();
        userLoader.loadFromFile();
    }

}
