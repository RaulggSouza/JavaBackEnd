import java.time.LocalDate;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;
    private UserAccount user;

    public Post(UserAccount account, String quote){
        this.user = account;
        this.quote = quote;
        date = LocalDate.now();
        claps = 0;
        boos = 0;
    }

    public String show(){
        StringBuilder output = new StringBuilder();
        output.append(date).append(" ");
        String quoteText = user+" says \""+quote+"\"";
        output.append(quoteText);
        String clapsAndBoos = " | Claps: "+claps+" | Boos: "+boos;
        output.append(clapsAndBoos);
        return output.toString();
    }

    public void clap(){
        claps++;
    }

    public void boo(){
        boos++;
    }
}
