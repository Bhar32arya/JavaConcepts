package design.pattern;

import java.util.List;

public class FactoryDesignPattern {

    public static void main(String[] args) {
        Notification phNotification = new PhoneNotification();
        phNotification.notification(List.of());
        Notification smsNotification = new SMSNotification();
        smsNotification.notification(List.of());
    }
}
