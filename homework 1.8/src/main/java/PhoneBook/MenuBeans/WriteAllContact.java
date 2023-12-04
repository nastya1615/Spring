package PhoneBook.MenuBeans;

import PhoneBook.PersonBeans.MapOfPerson;
import PhoneBook.Menu.MenuInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("1")
public class WriteAllContact implements MenuInterface {
    @Autowired
    MapOfPerson mapOfPerson;
    @Override
    public void choosingCommand() {

        mapOfPerson.writeAllContact();
    }
}
