package com.ohn.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
//Junit의 기본 assertThat이 아닌 assertj의 assertThat을 사용
//-> CoreMatchers와 달리 추가적인 라이브러리가 필요하지 않음.
public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then //테스트 검증 라이브러리의 검증 메소드
        assertThat(dto.getName()).isEqualTo(name); //동등한지 비교
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
