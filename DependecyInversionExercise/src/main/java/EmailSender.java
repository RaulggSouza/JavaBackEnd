public class EmailSender implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println("Sending e-mail: "+message);
    }
}
