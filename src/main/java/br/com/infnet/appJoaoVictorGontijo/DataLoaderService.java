package br.com.infnet.appJoaoVictorGontijo;

import br.com.infnet.appJoaoVictorGontijo.character.CharacterLoader;
import br.com.infnet.appJoaoVictorGontijo.user.UserLoader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DataLoaderService {

    private final UserLoader userLoader;
    private final CharacterLoader characterLoader;

    public DataLoaderService(UserLoader userLoader, CharacterLoader characterLoader) {
        this.userLoader = userLoader;
        this.characterLoader = characterLoader;
    }

    @PostConstruct
    public void init() throws IOException {
        characterLoader.loadFromFile();
        userLoader.loadFromFile();
    }
}
