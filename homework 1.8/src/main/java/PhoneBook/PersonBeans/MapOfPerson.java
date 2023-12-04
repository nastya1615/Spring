package PhoneBook.PersonBeans;

import PhoneBook.Person.Person;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MapOfPerson {

    Map<String, Person> mapOfContacts = new HashMap<>();


    public void addContact(String emailContact,Person person){
        mapOfContacts.put(emailContact, person );
    }

    public void deleteContact(String email){
        mapOfContacts.remove(email);
    }

    public void writeAllContact(){
        mapOfContacts.forEach((s, person) -> {
            System.out.println(MessageFormat.format("{0} | {1} | {2} \n",person.getName(),person.getPhone(),person.getEmail()));
        });
    }

    public void saveContactsIntheFile(){

        try {
            PrintWriter writer = new PrintWriter("data/file.text");
            mapOfContacts.forEach((s, person) -> writer.write(MessageFormat.format("{0} | {1} | {2} \n",person.getName(),person.getPhone(),person.getEmail())));
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void initializationFile(){
        try {
            List<String> contact = Files.readAllLines(Paths.get("src/main/resources/default-contacts.txt"));
            contact.forEach(c ->{
                String[] words=  c.split(";");
                mapOfContacts.put(words[2], new Person(words[0], words[1], words[2]));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
