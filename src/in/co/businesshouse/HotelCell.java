package in.co.businesshouse;

public class HotelCell extends Cell {

  private String userId;

  public HotelCell(CellType cellType) {
    this.cellType = cellType;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean process(User player, User bank) {
    boolean isProcessed = false;

    double value = value();
    double rent = rent();

    if (userId == null) {

      if (value <= player.getAmount()) {
        player.sendMoney(bank, value);
        userId = player.getUserId();
        isProcessed = true;
        System.out.println(player + " paid to " + bank + " : " + value);
      } else if (rent <= player.getAmount()) {
        player.sendMoney(bank, rent);
        isProcessed = true;
        System.out.println(player + " paid to " + bank + " : " + rent);
      }

    } else if (userId.equals(player.getUserId())) {

      if (cellType.equals(CellType.HOTEL_P)) {
        if (rent <= player.getAmount()) {
          player.sendMoney(bank, rent);
          isProcessed = true;
          System.out.println(player + " paid to " + bank + " : " + value);
        }
      } else {
        double upgradeValue = upgradeValue();

        if (upgradeValue <= player.getAmount()) {
          player.sendMoney(bank, upgradeValue);
          isProcessed = true;
          System.out.println(player + " paid to " + bank + " : " + upgradeValue);
        }
      }

    } else {
      User owner = UserStore.fetchById(userId);
      if (rent <= player.getAmount()) {
        player.sendMoney(owner, rent);
        isProcessed = true;
        System.out.println(player + " paid to " + owner + " : " + rent);
      }
    }


    return isProcessed;
  }

  private double rent() {

    double rent = 0;
    switch (cellType) {
      case HOTEL_S:
        rent = 50;
        break;
      case HOTEL_P:
        rent = 150;
        break;
      case HOTEL_G:
        rent = 300;
        break;
    }

    return rent;

  }

  private double value() {

    double value = 0;
    switch (cellType) {
      case HOTEL_S:
        value = 200;
        break;
      case HOTEL_G:
        value = 300;
        break;
      case HOTEL_P:
        value = 500;
        break;
    }

    return value;

  }

  private double upgradeValue() {
    double value = 0;
    switch (cellType) {
      case HOTEL_S:
        value = 100;
        break;
      case HOTEL_G:
        value = 200;
        break;
    }
    return value;
  }
}
