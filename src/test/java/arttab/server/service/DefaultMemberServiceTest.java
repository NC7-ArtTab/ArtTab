package arttab.server.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

class DefaultMemberServiceTest {
    @Autowired
    private PasswordEncoder encoder = PasswordEncoderFactories
            .createDelegatingPasswordEncoder();;


    @Test
    void 비밀번호가_동일한가() {
        String originalPassword = "1111";
        String encodedPassword = encoder.encode(originalPassword);

        // 원본 비밀번호와 암호화된 비밀번호가 일치하는지 확인
        Assertions.assertTrue(encoder.matches(originalPassword, encodedPassword));
    }

}