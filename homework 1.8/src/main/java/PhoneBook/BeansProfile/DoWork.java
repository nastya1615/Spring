package PhoneBook.BeansProfile;

import org.springframework.stereotype.Component;

@Component
public class DoWork {

    ProfileWorker profileWorker;

    DoWork(ProfileWorker profileWorker){
    this.profileWorker = profileWorker;
    }

    public void work(){

        profileWorker.writeAllContacts();
    }
}
