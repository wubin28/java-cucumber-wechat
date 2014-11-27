import java.util.Map;
import java.util.HashMap;

public class MomentsService {
  private static HashMap<User, Moment> allMoments = new HashMap<User, Moment>();

  public static HashMap<User, Moment> getFriendsMomentsOf(User user) {
    HashMap<User, Moment> momentsOfFriends = new HashMap<User, Moment>();
    for (Map.Entry<User, Moment> e : allMoments.entrySet()) {
      if (user.isAFriendOf(e.getKey())) momentsOfFriends.put(e.getKey(), e.getValue());
    }
    return momentsOfFriends;
  }

  public static void addMoment(User user, String momentString) {
    allMoments.put(user, new Moment(momentString));
  }

}