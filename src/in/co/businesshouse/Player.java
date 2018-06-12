package in.co.businesshouse;

public class Player extends User {

  private int position;

  public Player(double amount, String userId, int position) {
    this.amount = amount;
    this.userId = userId;
    this.position = position;
  }

  @Override
  public boolean sendMoney(User user, double amount) {

    boolean sent = false;
    if (this.amount - amount >= 0) {
      sent = true;
      this.amount = this.amount - amount;
      user.receiveMoney(amount);
    }else{
      System.out.println("insufficient balance in user " + this + " to pay " + amount + " to " + user);
    }
    return sent;
  }

  @Override
  public void receiveMoney(double amount) {
    this.amount = this.amount + amount;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "Player{" + "amount=" + amount + ", userId='" + userId + '\'' + '}';
  }

}
