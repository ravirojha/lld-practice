import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {
    private String content;
    private List<Tag> tags;
    private List<Vote> votes;
    private String title;
    private List<Comment> comments;
    private List<Answer> answers;
    private final UUID id;
    private final LocalDateTime createdAt;
    private final User author;


    public Question(String content, List<Tag> tags, String title, User author) {
        this.tags = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.content = content;
        this.tags = tags;
        this.title = title;
        this.author = author;
        author.increaseReputation();
    }

    public  void changeContent(String content) {
        this.content = content;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public Comment addComment(String content, User user) {
        Comment newcomment = new Comment(content, user);
        comments.add(newcomment);
        user.increaseReputation();
        return newcomment;
    }

    public Answer addAnswer(String content, User user) {
        Answer newanswer = new Answer(content, user);
        answers.add(newanswer);
        user.increaseReputation();
        return newanswer;
    }

    public void upvote(User user) {
        Vote newvote = new Vote(user);
        votes.add(newvote);
    }

    public String getContent() {
        return content;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public String getTitle() {
        return title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getAuthor() {
        return author;
    }

}
