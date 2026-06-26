import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame() {

        setTitle("Top 5 Players");
        setSize(550,300);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "TOP 5 PLAYERS",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 20));

        add(title, BorderLayout.NORTH);

        String[] column = {
                "Rank",
                "Username",
                "Wins",
                "Losses",
                "Draws",
                "Score"
        };

        DefaultTableModel model =
                new DefaultTableModel(column,0);

        JTable table = new JTable(model);

        PlayerService service =
                new PlayerService();

        ArrayList<Player> players =
                service.getTopPlayers();

        int rank = 1;

        for(Player p : players){

            Object[] row = {

                    rank,
                    p.getUsername(),
                    p.getWins(),
                    p.getLosses(),
                    p.getDraws(),
                    p.getScore()

            };

            model.addRow(row);

            rank++;

        }

        JScrollPane scroll =
                new JScrollPane(table);

        add(scroll,BorderLayout.CENTER);

        JButton btnClose =
                new JButton("Close");

        btnClose.addActionListener(e->dispose());

        add(btnClose,BorderLayout.SOUTH);

        setVisible(true);

    }

}