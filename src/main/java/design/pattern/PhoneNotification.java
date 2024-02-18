package design.pattern;

import java.util.List;

public class PhoneNotification implements Notification {
    @Override
    public void notification(List<User> list) {
        System.out.println("Phone notification service");
    }
}
