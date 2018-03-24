package at.refugeescode.encoder.endpoint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class EncoderTest {

    @Autowired
    private Encoder encoder;
    @MockBean
    private TestRestTemplate restTemplate;

    @Test
    void encode() {
        String plain_text = "plain text";
        encoder.encode(plain_text);
        verify(restTemplate, times(plain_text.length())).postForEntity(anyString(), any(), any());

    }

}