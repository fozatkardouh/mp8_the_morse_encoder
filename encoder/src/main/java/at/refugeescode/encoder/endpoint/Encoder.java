package at.refugeescode.encoder.endpoint;

import at.refugeescode.encoder.Model.Form;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class Encoder {

    private final String url = "http://localhost:9053/morse";
    private final RestTemplate restTemplate;

    @PostMapping("/encode")
    public String encode(@RequestBody Form form) {
        return form.getMessage().chars().boxed()
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
