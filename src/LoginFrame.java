import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private PlayerService playerService;

    public LoginFrame() {

        playerService = new PlayerService();

        setTitle("Student Swing Game - Login");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,2,10,10));

        add(new JLabel("Username"));

        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password"));

        txtPassword = new JPasswordField();
        add(txtPassword);

        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Register");

        add(btnLogin);
        add(btnRegister);

        btnLogin.addActionListener(e -> login());

        btnRegister.addActionListener(e -> register());

        setVisible(true);

    }

    private void login(){

        String username = txtUsername.getText();

        String password =
                new String(txtPassword.getPassword());

        Player player =
                playerService.login(username,password);

        if(player!=null){

            JOptionPane.showMessageDialog(
                    this,
                    "Login Berhasil!"
            );

            new MainMenuFrame(player);

            dispose();

        }

        else{

            JOptionPane.showMessageDialog(
                    this,
                    "Username atau Password salah!"
            );

        }

    }

    private void register(){

        String username =
                txtUsername.getText();

        String password =
                new String(txtPassword.getPassword());

        playerService.register(
                username,
                password
        );

        JOptionPane.showMessageDialog(
                this,
                "Akun berhasil dibuat!"
        );

    }

}