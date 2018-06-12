package in.co.businesshouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStore {

  private static Map<String, User> usersStore = new HashMap<>();

  public static void saveUsers(List<? extends User> users) {
    for (User user : users) {
      usersStore.put(user.getUserId(), user);
    }
  }

  public static User fetchById(String userId) {
    return usersStore.get(userId);
  }
}
