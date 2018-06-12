package in.co.businesshouse;

public class EmptyCell extends Cell {
  public EmptyCell() {
    this.cellType = CellType.EMPTY;
  }

  @Override
  public boolean process(User player, User bank) {
    return true;
  }
}
