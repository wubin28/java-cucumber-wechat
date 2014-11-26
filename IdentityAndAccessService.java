public class IdentityAndAccessService {
  public static User getUser(String username, String password, String smsVerificationCode) {
    return new User(username, password, smsVerificationCode);
  }
}
