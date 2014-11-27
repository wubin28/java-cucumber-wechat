import java.util.HashMap;
import java.util.ArrayList;

public class User {
  private String username;
  private String password;
  private String smsVerificationCode;
  private ArrayList<User> friends = new ArrayList<User>();
  private ArrayList<User> recommendedFriends = new ArrayList<User>();

  public User (String username, String password, String smsVerificationCode) {
    this.username = username;
    this.password = password;
    this.smsVerificationCode = smsVerificationCode;
  }
  public void sendFriendAddingRequestTo(User user) {
    user.addToRecommendedFriendsList(this);
  }
  public void acceptFriendAddingRequestFrom(User user) {
    friends.add(user);
    user.addFriendWhoAcceptsFriendAddingRequest(this);
  }
  public void sendMoment(String momentString) {
    MomentsService.addMoment(this, momentString);
  }
  public HashMap<User, Moment> checkMoments() {
    return MomentsService.getFriendsMomentsOf(this);
  }
  public String getUsername() {
    return this.username;
  }
  public boolean isAFriendOf(User user) {
    return friends.contains(user);
  }
  public void addToRecommendedFriendsList(User user) {
    recommendedFriends.add(user);
  }
  public void addFriendWhoAcceptsFriendAddingRequest(User user) {
    friends.add(user);
  }
}

