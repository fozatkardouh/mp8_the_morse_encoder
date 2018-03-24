package at.refugeescode.encoder.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@RequestMapping
@RestController
public class Encoder {

    private final String url = "http://localhost:9052/morse";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/encode")
    public String encode(@RequestBody String plaintext) {
        return plaintext.chars().boxed()
                .map(i -> (char) i.intValue())
                .map(Object::toString)
                .map(this::sentToMoris)
                .collect(Collectors.joining());
    }

    private String sentToMoris(String s) {
        ResponseEntity<String> response = restTemplate.postForEntity(url, s, String.class);
        return response.getBody();
    }

}
