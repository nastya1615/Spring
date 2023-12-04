package PhoneBook.BeansProfile;

import PhoneBook.Menu.MenuGenerater;
import PhoneBook.PersonBeans.MapOfPerson;
import org.springframework.beans.factory.annotation.Autowired;


public class InitProfiles implements ProfileWorker {

    @Autowired
    MapOfPerson mapOfPerson;
    @Autowired
    MenuGenerater menuGenerater = new MenuGenerater();
    @Override
    public void writeAllContacts(){
        System.out.println("профиль инит");
        mapOfPerson.initializationFile();
        menuGenerater.getResult();

    }
}
