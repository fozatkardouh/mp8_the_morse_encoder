package at.refugeescode.morse.initializer;

import at.refugeescode.morse.persistance.DatabaseHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Starter {

    @Autowired
    private DatabaseHolder databaseHolder;

    @Bean
    public ApplicationRunner startPoint() {
        return args -> {
            String plaintCHars = "a b c d e f g h i j k l m n o p q r s t u v w x y z " +
                    "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
            String moresCode = ".- / -... / -.-. / -.. / . / ..-. / --. / .... / .. / .--- / -.- / .-.. / -- / -. / " +
                    "--- / .--. / --.- / .-. / ... / - / ..- / ...- / .-- / -..- / -.-- / --.. / .- / -... / -.-. / " +
                    "-.. / . / ..-. / --. / .... / .. / .--- / -.- / .-.. / -- / -. / --- / .--. / --.- / .-. / " +
                    "... / - / ..- / ...- / .-- / -..- / -.-- / --..";

            String[] plaintSplits = plaintCHars.split(" ");
            String[] moresSplits = moresCode.split(" / ");

            for (int i = 0; i < plaintSplits.length; i++) {
                databaseHolder.addEntry(plaintSplits[i], moresSplits[i]);
            }
            databaseHolder.addEntry(" ", " / ");
        };
    }

}
