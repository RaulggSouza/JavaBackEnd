public class Main {
    public static void main(String[] args) {
        UserAccount conta1 = new UserAccount("teste", "t");
        UserAccount conta2 = new UserAccount("testa", "a");
        conta1.acceptFollower(conta2);
        conta1.publish("publicacao");
        System.out.println(conta1.getSizePosts());
        System.out.println(conta2.showTimeline());
    }
}
