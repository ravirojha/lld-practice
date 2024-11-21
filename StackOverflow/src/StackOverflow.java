import java.util.ArrayList;
import java.util.List;

public class StackOverflow {
    public List<Question> questions;
    public List<User> users;

    public StackOverflow() {
        questions = new ArrayList<>();
        users = new ArrayList<>();
    }

    public Question askQuestion(  User author, String title,String content, List<String> tagsList) {
        List<Tag> tags = new ArrayList<>();
        for(String tag: tagsList) {
            Tag newTag = new Tag(tag);
            tags.add(newTag);
        }
        Question newquestion = new Question(content, tags, title, author);
        questions.add(newquestion);
        return newquestion;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        return question.addAnswer(content, user);
    }

    public void addComment(User user, Question question, String content) {
        question.addComment(content, user);
    }

    public void addComment(User user, Answer answer, String content) {
        answer.addComment(content, user);
    }

    public void voteQuestion(User user, Question question) {
        question.upvote(user);
    }

    public void voteAnswer(User user, Answer answer) {
        answer.upvote(user);
    }



    public User createUser(String name, String email) {
        User newuser = new User(name, email);
        users.add(newuser);
        return newuser;
    }

    public List<Question> searchQuestions(String query) {
        List<Question> result = new ArrayList<>();

        for(Question question: questions) {
            boolean present = question.getTags().stream().anyMatch((tag) -> tag.getTagContent().contains(query));
            if(question.getContent().contains(query) || question.getTitle().contains(query) || question.getAuthor().getName().contains(query) || present) {
                result.add(question);
            }
        }

        return result;
    }

    public List<Question> getQuestionsByUser(User user) {
        List<Question> result = new ArrayList<>();
        for(Question q: questions) {
            if(q.getAuthor().equals(user)) {
                result.add(q);
            }
        }

        return result;
    }
}
