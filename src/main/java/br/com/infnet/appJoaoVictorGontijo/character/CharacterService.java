package br.com.infnet.appJoaoVictorGontijo.character;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CharacterService {

    private final Map<UUID, Character> characterMap = new HashMap<>();

    public void add(Character character) {
        characterMap.put(character.getId(), character);
    }

    public void remove(UUID id) {
        characterMap.remove(id);
    }

    public List<Character> get() {
        return new ArrayList<>(characterMap.values());
    }

    public Character getCharacterById(UUID id) {
        return characterMap.get(id);
    }
}
