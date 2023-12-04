package PhoneBook.Menu;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Scanner;

public class WriteMenu {
    Scanner scanner = new Scanner(System.in);

    public String writeTextOfMenu(){
        System.out.println("Выберете вариант взаимодействия с приложением \n" +
                "1. Распечатать все контакты \n" +
                "2. Добавить контакт \n" +
                "3.Удалить контакт \n" +
                "4.Сохранить имеющиеся контакты в файл \n");

        String in = scanner.nextLine();
        return in;

    }
}
