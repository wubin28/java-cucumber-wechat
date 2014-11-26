import java.util.Map;
import java.util.HashMap;

public class MomentsService {
  public static Map<User, Moment> getMoments(User user) {
    return new HashMap<User, Moment>() {{
      put(new User("Kongzi", "password", "213987"), new Moment("Yanhui did not repeat a fault."));
    }};
  }
}