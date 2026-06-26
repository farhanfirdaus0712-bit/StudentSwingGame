import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Player player;
    private GameLogic gameLogic;
    private JButton[][] buttons;

    public GameFrame(Player player) {

        this.player = player;
        this.gameLogic = new GameLogic();

        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 40));

                final int row = i;
                final int col = j;

                button.addActionListener(e -> playerMove(row, col));

                buttons[i][j] = button;

                add(button);

            }

        }

        setVisible(true);

    }

    private void playerMove(int row, int col) {

        if (!gameLogic.makeMove(row, col)) {

            return;

        }

        refreshBoard();

        if (gameLogic.checkWinner('X')) {

            JOptionPane.showMessageDialog(this, "Kamu Menang!");

            player.setWins(player.getWins() + 1);
            player.setScore(player.getScore() + 10);

            new PlayerService().updatePlayer(player);

            dispose();
            new MainMenuFrame(player);

            return;

        }

        if (gameLogic.isBoardFull()) {

            JOptionPane.showMessageDialog(this, "Draw!");

            player.setDraws(player.getDraws() + 1);
            player.setScore(player.getScore() + 3);

            new PlayerService().updatePlayer(player);

            dispose();
            new MainMenuFrame(player);

            return;

        }

        gameLogic.computerMove();

        refreshBoard();

        if (gameLogic.checkWinner('O')) {

            JOptionPane.showMessageDialog(this, "Bot Menang!");

            player.setLosses(player.getLosses() + 1);

            new PlayerService().updatePlayer(player);

            dispose();
            new MainMenuFrame(player);

            return;

        }

        if (gameLogic.isBoardFull()) {

            JOptionPane.showMessageDialog(this, "Draw!");

            player.setDraws(player.getDraws() + 1);
            player.setScore(player.getScore() + 3);

            new PlayerService().updatePlayer(player);

            dispose();
            new MainMenuFrame(player);

        }

    }

    private void refreshBoard() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                char c = gameLogic.getCell(i, j);

                if (c == ' ') {

                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(true);

                } else {

                    buttons[i][j].setText(String.valueOf(c));
                    buttons[i][j].setEnabled(false);

                }

            }

        }

    }

}