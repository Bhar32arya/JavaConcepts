package design.pattern;

import java.util.List;

public class SMSNotification implements Notification {
    @Override
    public void notification(List<User> list) {
        System.out.println("SMS notification service");
    }
}
