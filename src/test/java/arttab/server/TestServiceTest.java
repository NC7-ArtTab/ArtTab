package arttab.server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestServiceTest {

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    private TestService testService;


    @Test
    void 테스트메소드테스트_정답입니다() {
        Assertions.assertEquals("a", testService.test());
    }

    @Test
    void 테스트메소드테스트_오답입니다() {
        Assertions.assertNotEquals("b", testService.test());
    }
}