package in.co.businesshouse;

public class LotteryCell extends Cell {

  private double amount = 200;


  public LotteryCell() {
    this.cellType = CellType.LOTTERY;
  }

  @Override
  public boolean process(User player, User bank) {
    System.out.println(player + " paying to " + bank + " : " + amount);
    return bank.sendMoney(player, amount);
  }
}
