import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {

        setTitle("Player Statistics");
        setSize(350,300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6,1));

        add(new JLabel("Username : " + player.getUsername()));
        add(new JLabel("Wins : " + player.getWins()));
        add(new JLabel("Losses : " + player.getLosses()));
        add(new JLabel("Draws : " + player.getDraws()));
        add(new JLabel("Score : " + player.getScore()));

        JButton btnClose = new JButton("Close");

        btnClose.addActionListener(e -> dispose());

        add(btnClose);

        setVisible(true);

    }

}