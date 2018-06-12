package in.co.businesshouse;

public abstract class User {
  double amount;
  String userId;

  abstract boolean sendMoney(User user, double amount);

  abstract void receiveMoney(double amount);

  public double getAmount() {
    return amount;
  }

  public String getUserId() {
    return userId;
  }
}
