import java.time.LocalDate;
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
        updateTimeline(newPost);
    }

    public void updateTimeline(Post newPost){
        for (int i = 0; i < sizeFollowers; i++){
            UserAccount follower = followers[i];
            if (follower.getSizeTimeline() == 10) follower.setSizeTimeline(findOldestPostIndex(timeline));
            follower.timeline[follower.getSizeTimeline()] = newPost;
            follower.setSizeTimeline(getSizeTimeline()+1);
        }
    }

    private int findOldestPostIndex(Post[] timeline){
        LocalDate oldestPost = timeline[0].getDate();
        int indexOldest = 0;
        for (int i = 1; i < sizeTimeline; i++){
            if (timeline[i].getDate().isBefore(oldestPost)) {
                oldestPost = timeline[i].getDate();
                indexOldest = i;
            }
        }
        return indexOldest;
    }

    public boolean delete(int postIdx){
        if (postIdx > sizePosts) return false;
        for (int i = postIdx; i < sizePosts-1; i++) {
            posts[i] = posts[i+1];
        }
        return true;
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
        if (size < 1){
            return falseOutput;
        }
        for (int i = 0; i < size; i++) {
            Post post = posts[i];
//            System.out.println(post);
            joiner.add(post.show());
        }
        return joiner.toString();
    }

    public String showMyFriends(){
        if (sizeFollowers < 1){
            return "You don't have any friends yet :(";
        }
        StringJoiner output = new StringJoiner(", ", "Friends: ", " :)");
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

    public void acceptFollower(UserAccount newFollower){
        followers[sizeFollowers++] = newFollower;
    }

    public void blockFollower(UserAccount follower){
        int indexToBlock = findFollowerIndex(follower);
        if (indexToBlock < 0) return;
        for (int i = indexToBlock; i < sizeFollowers-1; i++) {
            followers[i] = followers[i+1];
        }
    }

    private int findFollowerIndex(UserAccount follower){
        for (int i = 0; i < sizeFollowers; i++) {
             if (followers[i] == follower) return i;
        }
        return -1;
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

    public int getSizePosts() {
        return sizePosts;
    }

    public int getSizeTimeline() {
        return sizeTimeline;
    }

    public void setSizeTimeline(int sizeTimeline) {
        this.sizeTimeline = sizeTimeline;
    }

    public int getSizeFollowers() {
        return sizeFollowers;
    }
}
