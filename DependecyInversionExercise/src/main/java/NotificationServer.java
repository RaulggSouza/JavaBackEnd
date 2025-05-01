public class NotificationServer {
    private final NotificationSender sender;

    public NotificationServer(NotificationSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String message){
        sender.send(message);
    }
}
