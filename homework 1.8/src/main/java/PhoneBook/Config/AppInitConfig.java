package PhoneBook.Config;

import PhoneBook.BeansProfile.InitProfiles;
import PhoneBook.BeansProfile.ProfileWorker;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("PhoneBook")
@PropertySource("classpath:application-init.properties")
@Profile("init")
public class AppInitConfig {
    @Bean
    public ProfileWorker profileWorker(){
        return new InitProfiles();
    }
}
