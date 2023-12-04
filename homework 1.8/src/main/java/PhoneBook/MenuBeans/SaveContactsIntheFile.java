package PhoneBook.MenuBeans;

import PhoneBook.PersonBeans.MapOfPerson;
import PhoneBook.Menu.MenuInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("4")
public class SaveContactsIntheFile implements MenuInterface {
    @Autowired
    MapOfPerson mapOfPerson;
    @Override
    public void choosingCommand() {
        mapOfPerson.saveContactsIntheFile();

    }
}
