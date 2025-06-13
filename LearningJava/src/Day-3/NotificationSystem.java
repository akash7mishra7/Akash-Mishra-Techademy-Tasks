interface Notifier {
    public void send(String message);
}

abstract class BaseNotifier implements Notifier {
    String recipient;

    BaseNotifier(String recipient) {
        this.recipient = recipient;
    }
}

class EmailNotifier extends BaseNotifier {
    EmailNotifier(String recipient) {
        super(recipient);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

class SMSNotifier extends BaseNotifier {
    SMSNotifier(String recipient) {
        super(recipient);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        EmailNotifier email = new EmailNotifier("user@example.com");
        SMSNotifier sms = new SMSNotifier("+1234567890");

        email.send("Your order has shipped!");
        sms.send("Your verification code is 1234");
    }
}