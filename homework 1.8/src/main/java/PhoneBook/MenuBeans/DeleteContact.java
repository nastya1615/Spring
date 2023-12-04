package PhoneBook.MenuBeans;

import PhoneBook.PersonBeans.MapOfPerson;
import PhoneBook.Menu.MenuInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("3")
public class DeleteContact implements MenuInterface {
    @Autowired
    MapOfPerson mapOfPerson;
    Scanner scanner = new Scanner(System.in);
    @Override
    public void choosingCommand() {
        System.out.println("Введите email контакта, который необходимо удалить.");
        mapOfPerson.deleteContact(scanner.nextLine());

    }
}
