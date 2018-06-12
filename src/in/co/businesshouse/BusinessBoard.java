package in.co.businesshouse;

import java.util.ArrayList;
import java.util.List;

public class BusinessBoard implements BoardGenerator {
  @Override
  public Board build() {
    List<Cell> cells = buildBoard();
    Board board = new Board(cells);
    return board;
  }

  private List<Cell> buildBoard() {
    List<Cell> cells = new ArrayList<>();

    for (int index = 0; index < 10; index++) {
      Cell cell = new EmptyCell();
      cells.add(cell);
    }

    addJails(cells);
    addLottery(cells);
    addHotelS(cells);
    addHotelG(cells);
    addHotelP(cells);

    return cells;
  }

  private void addJails(List<Cell> cells) {

    cells.set(0, new JailCell());
    cells.set(9, new JailCell());
  }

  private void addLottery(List<Cell> cells) {

    cells.set(2, new LotteryCell());
    cells.set(5, new LotteryCell());
    cells.set(7, new LotteryCell());
  }

  private void addHotelS(List<Cell> cells) {

    cells.set(1, new HotelCell(CellType.HOTEL_S));
    cells.set(3, new HotelCell(CellType.HOTEL_S));
    cells.set(6, new HotelCell(CellType.HOTEL_S));
    cells.set(8, new HotelCell(CellType.HOTEL_S));
  }

  private void addHotelG(List<Cell> cells) {
    // cells.set(6, new HotelCell(CellType.HOTEL_G));
  }

  private void addHotelP(List<Cell> cells) {
    // cells.set(6, new HotelCell(CellType.HOTEL_P));
  }
}
