package PhoneBook.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Setter
@Getter
@AllArgsConstructor
public class Person {

    public String name;
    public String phone;
    public String email;
}
