package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * PokemonService는 Pokemon 인터페이스를 구현한 Bean을 주입받아 사용하는 서비스 클래스입니다.
 * @Qualifier 어노테이션을 사용하여 동일한 타입의 여러 Bean 중 특정한 하나(charmander)를 선택합니다.
 */
@Service("pokemonServiceQualifier")
public class PokemonService {

    // Pokemon 인터페이스 타입의 필드 선언
    private final Pokemon pokemon;

    /**
     * 생성자 주입 방식
     * @Autowired를 통해 의존성 주입을 수행하며,
     * @Qualifier로 "charmander"라는 이름의 Bean을 명시적으로 주입합니다.
     */
    @Autowired
    public PokemonService(@Qualifier("charmander") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * 실제 공격 메서드
     * 주입받은 Pokemon 인스턴스를 사용하여 공격 기능 실행
     */
    public void pokemonAttack() {
        pokemon.attack(); // "파이리 불꽃 공격 🔥🔥" 출력 예상
    }
}
