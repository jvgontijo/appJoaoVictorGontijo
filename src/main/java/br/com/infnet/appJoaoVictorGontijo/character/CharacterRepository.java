package br.com.infnet.appJoaoVictorGontijo.character;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {

    List<Character> findAll(Sort sort);
}
