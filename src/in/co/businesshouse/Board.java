package in.co.businesshouse;

import java.util.List;

public class Board {

  private List<Cell> cells;

  public Board(List<Cell> cells) {
    this.cells = cells;
  }

  public Cell getCell(int index) {
    return cells.get(index);
  }
}
