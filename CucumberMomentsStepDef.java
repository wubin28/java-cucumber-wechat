import org.junit.*;
import static org.junit.Assert.*;
import cucumber.api.java.zh_cn.*;
import java.util.HashMap;

public class CucumberMomentsStepDef {
  private User ben = null;
  private User kongzi = null;
  private User laozi = null;
  private HashMap<User, Moment> moments = null;

  @假如("^孔子是Ben的微信朋友$")
  public void 孔子是Ben的微信朋友() throws Throwable {
    ben = IdentityAndAccessService.getUser("Ben", "password", "231234");
    kongzi = IdentityAndAccessService.getUser("Kongzi", "password", "213987");
    ben.sendFriendAddingRequestTo(kongzi);
    kongzi.acceptFriendAddingRequestFrom(ben);
  }

  @假如("^孔子在朋友圈发了一条朋友圈微信\"(.*?)\"$")
  public void 孔子在朋友圈发了一条朋友圈微信(String moment) throws Throwable {
    kongzi.sendMoment(moment);
  }

  @当("^Ben查看微信朋友圈时$")
  public void Ben查看微信朋友圈时() throws Throwable {
    moments = ben.checkMoments();
  }

  @那么("^Ben能在微信朋友圈中看到孔子所发的朋友圈微信\"(.*?)\"$")
  public void Ben能在微信朋友圈中看到孔子所发的朋友圈微信(String moment) throws Throwable {
    assertTrue(momentsContains(moments, "Kongzi", moment));
  }

  private boolean momentsContains(HashMap<User, Moment> moments, String username, String momentString) {
    if (!momentsContainAMoment(moments, momentString)) return false;
    if (!momentsContainAnUser(moments, username)) return false;
    if (!momentsContainTheMomentFromTheUser(moments, momentString, username)) return false;
    return true;
  }

  private boolean momentsContainAMoment(HashMap<User, Moment> moments, String momentString) {
    for (Moment moment : moments.values()) {
      if (moment.getMomentString().equals(momentString)) return true;
    }
    return false;
  }

  private boolean momentsContainAnUser(HashMap<User, Moment> moments, String username) {
    for (User user : moments.keySet()) {
      if (user.getUsername().equals(username)) return true;
    }
    return false;
  }

  private boolean momentsContainTheMomentFromTheUser(HashMap<User, Moment> moments, String momentString, String username) {
    for (User user : moments.keySet()) {
      if (user.getUsername().equals(username) && moments.get(user).getMomentString().equals(momentString)) return true;
    }
    return false;
  }

  @假如("^老子不是Ben的微信朋友$")
  public void 老子不是Ben的微信朋友() throws Throwable {
    ben = IdentityAndAccessService.getUser("Ben", "password", "231234");
    laozi = IdentityAndAccessService.getUser("Laozi", "password", "293987");
  }

  @假如("^老子在朋友圈发了一条朋友圈微信\"(.*?)\"$")
  public void 老子在朋友圈发了一条朋友圈微信(String moment) throws Throwable {
    laozi.sendMoment(moment);
  }

  @那么("^Ben不能在微信朋友圈中看到老子所发的朋友圈微信\"(.*?)\"$")
  public void Ben不能在微信朋友圈中看到老子所发的朋友圈微信(String moment) throws Throwable {
    assertFalse(momentsContains(moments, "Laozi", moment));
  }
}
