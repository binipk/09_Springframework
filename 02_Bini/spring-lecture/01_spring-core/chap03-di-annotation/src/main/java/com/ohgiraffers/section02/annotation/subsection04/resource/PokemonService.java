package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * PokemonService 클래스는 @Resource를 사용해서 Pokemon 빈을 주입받는 예제입니다.
 * @Resource는 자바의 표준 DI 어노테이션이며, name 속성으로 주입 대상을 지정할 수 있습니다.
 */
@Service("pokemonServiceResource")
public class PokemonService {

    /**
     * @Resource
     * - Java 표준 애너테이션 (jakarta.annotation)
     * - name 속성으로 특정 Bean 이름을 기준으로 의존성 주입
     * - name → 타입 순으로 찾음
     * - name을 생략하면 필드명과 같은 이름을 가진 Bean을 찾음
     * - List 타입에도 사용할 수 있음
     *
     * 여기서는 name = "squiretle"로 지정했기 때문에
     * '꼬부기(Squirtle)' Bean이 주입됩니다.
     *
     * (주의: 클래스 이름 오타가 있으면 주입이 안 될 수 있어요!)
     */
    @Resource(name = "squiretle")
    private Pokemon pokemon;

    /**
     * 주입된 포켓몬의 공격 메서드를 실행하는 비즈니스 로직
     */
    public void pokemonAttack() {
        pokemon.attack(); // "꼬부기 물대포 발사♒♒♒" 가 출력될 것으로 예상
    }
}
