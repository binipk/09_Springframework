package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.inject.Inject; // Java 표준 DI 애너테이션
import jakarta.inject.Named; // 이름 기반 Bean 주입에 사용
import org.springframework.stereotype.Service;

/**
 * PokemonService 클래스는 @Inject와 @Named를 이용한 의존성 주입 예제입니다.
 * @Inject는 타입 기준으로, @Named는 이름 기준으로 Bean을 선택합니다.
 */
@Service("pokemonServiceInject")
public class PokemonService {

    /**
     * @Inject
     * - JSR-330 표준 의존성 주입 애너테이션 (자바 진영에서 제공)
     * - Spring에서도 완벽히 지원됨
     *
     * @Named("charmander")
     * - 이름이 "charmander"인 Bean을 주입하라는 뜻
     * - @Qualifier와 역할이 같음
     *
     * 이 두 애너테이션을 조합하면
     * 타입 + 이름 기준으로 정확한 Bean을 주입할 수 있음
     */
    @Inject
    @Named("charmander")
    private Pokemon pokemon;

    /**
     * 실제 공격 실행 메서드
     * 주입된 Pokemon 인스턴스의 공격 메서드를 호출함
     */
    public void pokemonAttack() {
        pokemon.attack();  // "파이리 불꽃 공격 🔥🔥" 출력 예상
    }
}
