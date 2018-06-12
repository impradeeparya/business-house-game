package in.co.businesshouse;

import java.util.Arrays;
import java.util.List;

public class BusinessHouseRunner {

  static BoardGenerator boardGenerator = new BusinessBoard();

  public static void main(String[] args) {

    Board board = boardGenerator.build();
    Player player1 = new Player(1000, "player1", 0);
    Player player2 = new Player(1000, "player2", 0);
    Player player3 = new Player(1000, "player3", 0);
    User bank = new Bank(5000, "bank");

    List<Player> playres = Arrays.asList(player1, player2, player3);
    UserStore.saveUsers(playres);
    startGame(playres, bank, board);
  }


  private static void startGame(List<Player> players, User bank, Board board) {

    int[] diceOutput = {2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1};

    int maxPlayer = players.size() - 1;
    int playerTurn = 0;
    for (int index = 0; index < diceOutput.length; index++) {

      Player player = players.get(playerTurn);
      int newPosition = player.getPosition() + diceOutput[index];
      Cell cell = board.getCell(newPosition);

      if (!CellType.EMPTY.equals(cell.getCellType())) {
        boolean processed = cell.process(player, bank);
      }

      playerTurn++;
      if (playerTurn > maxPlayer) {
        playerTurn = 0;
      }

    }

    System.out.println("Game Result################################");
    System.out.println(players);
    System.out.println(bank);

  }
}
