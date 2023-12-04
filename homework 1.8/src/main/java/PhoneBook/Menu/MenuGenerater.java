package PhoneBook.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MenuGenerater {

    @Autowired
    private Map<String,MenuInterface> map;

    public void getResult(){
        WriteMenu writeMenu = new WriteMenu();
        while (true){
        MenuInterface menuInterface = map.get(writeMenu.writeTextOfMenu());
        try {
            menuInterface.choosingCommand();
        }
        catch (NullPointerException e){
            System.out.println("Данной команды не существует\n");}
        }

    }
}