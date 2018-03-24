package at.refugeescode.morse.endpoint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MoresTest {

    @Autowired
    private Mores mores;

    @Test
    void morse() {
        String result = mores.morse(" ");
        assertEquals(" / ", result);
    }

}