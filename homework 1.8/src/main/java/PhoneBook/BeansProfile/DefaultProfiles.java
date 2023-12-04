package PhoneBook.BeansProfile;
import PhoneBook.Menu.MenuGenerater;
import org.springframework.beans.factory.annotation.Autowired;


public class DefaultProfiles implements ProfileWorker {

    @Autowired
    MenuGenerater menuGenerater = new MenuGenerater();
    @Override
    public void writeAllContacts(){
        System.out.println("дефолтный профиль");
        menuGenerater.getResult();

    }



}
