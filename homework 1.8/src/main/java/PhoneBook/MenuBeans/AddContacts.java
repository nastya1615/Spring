package PhoneBook.MenuBeans;

import PhoneBook.PersonBeans.MapOfPerson;
import PhoneBook.Menu.MenuInterface;
import PhoneBook.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("2")
public class AddContacts implements MenuInterface {
    @Autowired
    MapOfPerson mapOfPerson;
    Scanner scanner = new Scanner(System.in);
    @Override
    public void choosingCommand() {
        System.out.println("Введите новый контакт в формате «Ф. И. О;номер телефона;адрес электронной почты»");
        String[] words = scanner.nextLine().split(";");



        try {

            if( words[2].matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){

                if(words[1].matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")){

            mapOfPerson.addContact(words[2], new Person(words[0], words[1], words[2]));}

                else System.out.println("номер телефона невалидный");
            }

            else System.out.println("email невалидный");
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Формат введённого контакта неверен \n");
        }


    }
}
