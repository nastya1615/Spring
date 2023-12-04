package PhoneBook.Config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("PhoneBook")
@PropertySource("classpath:application.properties")
public class AppConfig {


}
