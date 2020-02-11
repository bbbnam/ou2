package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.ReviewService;
import kr.co.fastcampus.eatgo.domain.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void createWithValidAttributes() throws Exception {
        given(reviewService.addReview(eq(1L), any())).willReturn(
                Review.builder()
                .id(1004L)
                .build()
        );
         /* 아래 mvc.perform에서 해당 url 테스트를 진행하는데... 그 때에 MockBean이 적용된 reviewService 는
         해당 url 안에 정의된 컨트롤러 내 메소드에 있는 reviewService 가 아니라 여기에서 MockBean으로 주입받은 Mock 객체가
         실행된다. 그래서 /restaurants/1/reviews 을 받는 컨트롤러에 로그 찍어보면 찍히는데
         reviewService 내의 메소드에 로그 찍어보면 안찍힌다. 실제 reviewService 가 아니라 Mock 객체로 실행되기 때문으로 추정.. */

        mvc.perform(post("/restaurants/1/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"JOKER\",\"score\":3,\"description\":\"Mat-it-da\"}"))
                .andExpect(status().isCreated()) //요청이 성공적이었으며 그 결과로 새로운 리소스가 생성. 이 요청은 일반적으로 Post, Put 요청 이후 따라옴.
                .andExpect(header().string("location","/restaurants/1/reviews/1004")); //Response header 값이 <<< 이러할 것이다 라고 예측해보는 것

        verify(reviewService).addReview(eq(1L), any());
    }

    @Test
    public void createWithInValidAttributes() throws Exception {
        mvc.perform(post("/restaurants/1/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());

        verify(reviewService, never()).addReview(eq(1L), any());
    }

}