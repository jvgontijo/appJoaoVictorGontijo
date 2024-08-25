package br.com.infnet.appJoaoVictorGontijo.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.String.format;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    @Autowired
    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public void add(Character character) {
        this.repository.save(character);
    }

    public void remove(UUID id) {
        Optional<Character> character = this.repository.findById(id);
        character.ifPresent(this.repository::delete);
    }

    public List<Character> get() {
        return this.repository.findAll();
    }

    public Character getCharacterById(UUID id) {
        Optional<Character> character = this.repository.findById(id);
        return Optional.of(character)
                .get()
                .orElseThrow(() -> new RuntimeException(format("Character [ ID: '%s' ] not found!", id)));
    }
}
