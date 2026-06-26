import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private Player player;

    public MainMenuFrame(Player player) {

        this.player = player;

        setTitle("Student Swing Game");
        setSize(450,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "TIC TAC TOE",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel welcome = new JLabel(
                "Selamat Datang, " + player.getUsername(),
                SwingConstants.CENTER
        );

        welcome.setFont(new Font("Arial", Font.PLAIN, 16));

        JPanel topPanel = new JPanel(new GridLayout(2,1));

        topPanel.add(title);
        topPanel.add(welcome);

        add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4,1,10,10));

        JButton btnPlay = new JButton("Play Game");

        JButton btnStatistics = new JButton("Statistics");

        JButton btnTop5 = new JButton("Top 5 Players");

        JButton btnLogout = new JButton("Logout");

        buttonPanel.add(btnPlay);
        buttonPanel.add(btnStatistics);
        buttonPanel.add(btnTop5);
        buttonPanel.add(btnLogout);

        add(buttonPanel, BorderLayout.CENTER);

        btnPlay.addActionListener(e -> {

            new GameFrame(player);

            dispose();

        });

        btnStatistics.addActionListener(e -> {

            new StatisticsFrame(player);

        });

        btnTop5.addActionListener(e -> {

            new TopScorersFrame();

        });

        btnLogout.addActionListener(e -> {

            int pilihan = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah Anda yakin ingin logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if(pilihan == JOptionPane.YES_OPTION){

                new LoginFrame();

                dispose();

            }

        });

        setVisible(true);

    }

}