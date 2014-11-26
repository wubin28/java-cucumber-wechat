import java.util.Map;
import java.util.HashMap;

public class User {
  private String username;
  private String password;
  private String smsVerificationCode;

  public User (String username, String password, String smsVerificationCode) {
    this.username = username;
    this.password = password;
    this.smsVerificationCode = smsVerificationCode;
  }
  public void sendFriendAddingRequestTo(User user) {
  }
  public void acceptFriendAddingRequestFrom(User user) {
  }
  public void sendMoment(String moment) {
  }
  public Map<User, Moment> checkMoments() {
    return new HashMap<User, Moment>() {{
      put(new User("Kongzi", "password", "213987"), new Moment("Yanhui did not repeat a fault."));
    }};
  }
  public String getUsername() {
    return this.username;
  }
}