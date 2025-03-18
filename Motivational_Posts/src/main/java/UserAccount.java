import java.util.StringJoiner;

public class UserAccount {
    private String email;
    private String userName;
    private final UserAccount[] followers;
    private final Post[] timeline;
    private final Post[] posts;
    private int sizeTimeline;
    private int sizePosts;
    private int sizeFollowers;

    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;
        followers = new UserAccount[9999];
        timeline = new Post[10];
        posts = new Post[9999];
    }

    public void publish(String quote){
        Post newPost = new Post(this, quote);
        posts[sizePosts++] = newPost;
    }

    public boolean delete(int postIdx){
        return false;
    }

    public String showTimeline(){
        StringJoiner joiner = new StringJoiner(", ", "Timeline: ", ".");
        return showList(joiner, timeline, sizeTimeline, "Your timeline is empty");
    }

    public String showMyPosts(){
        StringJoiner joiner = new StringJoiner(", ", "Posts: ", ".");
        return showList(joiner, posts, sizePosts, "You don't have posts");
    }

    private String showList(StringJoiner joiner, Post[] posts, int size, String falseOutput){
        if (size < 0){
            return falseOutput;
        }
        for (int i = 0; i < size; i++) {
            Post post = posts[i];
            joiner.add(post.show());
        }
        return joiner.toString();
    }

    public String showMyFriends(){
        if (sizeFollowers < 0){
            return "You don't have any friends yet :(";
        }
        StringJoiner output = new StringJoiner(", ", "Friends: ", ":)");
        for (int i = 0; i < sizeFollowers; i++) {
            UserAccount follower = followers[i];
            output.add(follower.getUserName());
        }
        return output.toString();
    }

    public void clapPost(int postIdx){
        timeline[postIdx].clap();
    }

    public void booPost(int postIdx){
        timeline[postIdx].boo();
    }

    public void updateTimeline(Post newPost){

    }

    public void acceptFollower(UserAccount newFollower){
        followers[sizeFollowers++] = newFollower;
    }

    public void blockFollower(UserAccount follower){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
