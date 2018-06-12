package in.co.businesshouse;

public class JailCell extends Cell {

  private double amount = 150;

  public JailCell() {
    this.cellType = CellType.JAIL;
  }


  @Override
  public boolean process(User player, User bank) {
    System.out.println(player + " paying to " + bank + " : " + amount);
    return player.sendMoney(bank, amount);
  }
}
