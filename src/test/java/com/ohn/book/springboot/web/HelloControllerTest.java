package com.ohn.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈을 주입받음.
    private MockMvc mvc; //스프링Mvc테스트의 시작점.

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void returnHelloDto() throws Exception{
        String name = "hello";
        int amount = 1000;
        System.out.println("hello");
        mvc.perform(get("/hello/dto")
                   .param("name", name)
                    .param("amount", String.valueOf(amount))) //param: 요청파라미터 설정, String값만 허용
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
                //jsonPath : JSON응답값을 필드별로 검증할 수 있는 메소드.
                // $를 기준으로 필드명을 명시함.
    }
}
