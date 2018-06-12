package in.co.businesshouse;

public class Bank extends User {

  public Bank(double amount, String userId) {
    this.amount = amount;
    this.userId = userId;
  }

  @Override
  public boolean sendMoney(User user, double amount) {

    boolean sent = false;
    if (this.amount - amount >= 0) {
      sent = true;
      this.amount = this.amount - amount;
      user.receiveMoney(amount);
    } else {
      System.out
          .println("insufficient balance in user " + this + " to pay " + amount + " to " + user);
    }
    return sent;
  }

  @Override
  public void receiveMoney(double amount) {
    this.amount = this.amount + amount;
  }

  @Override
  public String toString() {
    return "Bank{" + "amount=" + amount + ", userId='" + userId + '\'' + '}';
  }
}
