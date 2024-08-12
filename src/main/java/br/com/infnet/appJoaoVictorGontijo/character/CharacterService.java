package br.com.infnet.appJoaoVictorGontijo.character;

import java.util.*;

public class CharacterService {

    private final Map<UUID, Character> characterMap = new HashMap<>();

    public void add(Character character) {
        characterMap.put(character.getId(), character);
    }

    public List<Character> get() {
        return new ArrayList<>(characterMap.values());
    }

    public Character getCharacterById(UUID id) {
        return characterMap.get(id);
    }
}
