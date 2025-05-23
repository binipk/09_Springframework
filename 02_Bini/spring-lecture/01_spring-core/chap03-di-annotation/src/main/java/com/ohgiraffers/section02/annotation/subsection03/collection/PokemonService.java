package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Spring이 이 클래스를 Bean으로 등록하도록 지정
public class PokemonService {

    // 여러 Pokemon 구현체들을 List 형태로 주입받음
    private final List<Pokemon> pokemonList;

    /**
     * 생성자 주입 방식
     * Spring이 등록된 모든 Pokemon 타입의 Bean을 List에 자동으로 주입해줌
     */
    @Autowired
    public PokemonService(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    /**
     * 모든 포켓몬의 attack() 메서드를 실행하는 메서드
     * 주입된 List를 반복하면서 각각의 포켓몬 공격 출력
     */
    public void pokemonAttack() {
        for (Pokemon pokemon : pokemonList) {
            pokemon.attack();  // 각 포켓몬의 고유 공격 메서드 실행
        }
    }
}
