package natek.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
		SpringApplication app = new SpringApplicationBuilder(Application.class).build();
		app.run(args);
    }
}
