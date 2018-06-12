package in.co.businesshouse;

public abstract class Cell {

  CellType cellType;

  public CellType getCellType() {
    return cellType;
  }

  abstract public boolean process(User player, User bank);
}
