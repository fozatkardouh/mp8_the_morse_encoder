package at.refugeescode.morse.endpoint;

import at.refugeescode.morse.persistance.DatabaseHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Mores {

    private final DatabaseHolder databaseHolder;

    @PostMapping("/morse")
    public String morse(@RequestBody String s) {
        return databaseHolder.getValue(s);
    }

}
