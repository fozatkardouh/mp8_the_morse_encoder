package at.refugeescode.encoder.endpoint;

import at.refugeescode.encoder.Model.Form;
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
        Form form = new Form();
        form.setMessage("plain text");
        encoder.encode(form);
        verify(restTemplate, times(form.getMessage().length())).postForEntity(anyString(), any(), any());

    }

}