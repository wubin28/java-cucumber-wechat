import org.junit.*;
import static org.junit.Assert.*;
import cucumber.api.java.en.*;
import java.util.HashMap;

public class MomentsStepDef {
  private User ben = null;
  private User kongzi = null;
  private HashMap<User, Moment> moments = null;

  @Given("^Kongzi is the Wechat friend of Ben$")
  public void kongziIsTheWechatFriendOfBen() throws Throwable {
    ben = IdentityAndAccessService.getUser("Ben", "password", "231234");
    kongzi = IdentityAndAccessService.getUser("Kongzi", "password", "213987");
    ben.sendFriendAddingRequestTo(kongzi);
    kongzi.acceptFriendAddingRequestFrom(ben);
  }

  @Given("^Kongzi sends a moment \"(.*?)\" in Wechat Moments$")
  public void kongziSendsAMomentInWechatMoments(String moment) throws Throwable {
    kongzi.sendMoment(moment);
  }

  @When("^Ben checks the Wechat Moments$")
  public void benChecksTheWechatMoments() throws Throwable {
    moments = ben.checkMoments();
  }

  @Then("^Ben could see the moment \"(.*?)\" from Kongzi in Wechat Moments$")
  public void benCouldSeeTheMomentFromKongziInWechatMoments(String moment) throws Throwable {
    System.out.println(">>>moments: " + moments);
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
}

