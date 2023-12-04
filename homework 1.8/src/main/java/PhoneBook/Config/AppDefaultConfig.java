package PhoneBook.Config;

import PhoneBook.BeansProfile.DefaultProfiles;
import PhoneBook.BeansProfile.ProfileWorker;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("PhoneBook")
@PropertySource("classpath:application-default.properties")
@Profile("default")
public class AppDefaultConfig {
    @Bean
    public ProfileWorker profileWorker(){
        return new DefaultProfiles();
    }
}
