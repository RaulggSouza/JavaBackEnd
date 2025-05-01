public class Main {
    public static void main(String[] args) {
        NotificationSender emailSender = new EmailSender();
        NotificationSender smsSender = new SmsSender();

        NotificationServer server = new NotificationServer(smsSender);
        server.notifyUser("Hello World!");
    }
}
