package hibermvc;

import hibermvc.entity.User;
import hibermvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class TestDataInit {

    private final UserService userService;

    @Autowired
    public TestDataInit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.saveUser(new User("Ivan", "Ivanov", 35, 1200, "ivanovich81@gmail.com"));
        userService.saveUser(new User("Victor", "Petrov", 22, 950, "petrovich3000@mail.ru"));
        userService.saveUser(new User("Софья", "Риановна", 43, 1030, "sophico11@yahoo.com"));
        userService.saveUser(new User("Sidr", "Sidorov", 31, 870, "sidr.sidr@list.ru"));
        userService.saveUser(new User("Петр", "Лебедев", 39, 720, "lebed.white@yahoo.com"));
    }
}
