import java.sql.*;
import java.util.ArrayList;

public class PlayerService {

    public Player login(String username, String password) {

        try {

            Connection conn = DatabaseManager.getConnection();

            String sql = "SELECT * FROM players WHERE username=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Player player = new Player();

                player.setId(rs.getInt("id"));
                player.setUsername(rs.getString("username"));
                player.setPassword(rs.getString("password"));
                player.setWins(rs.getInt("wins"));
                player.setLosses(rs.getInt("losses"));
                player.setDraws(rs.getInt("draws"));
                player.setScore(rs.getInt("score"));

                conn.close();
                return player;
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void register(String username, String password) {

        try {

            Connection conn = DatabaseManager.getConnection();

            String sql = "INSERT INTO players(username,password) VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ps.executeUpdate();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlayer(Player player) {

        try {

            Connection conn = DatabaseManager.getConnection();

            String sql = "UPDATE players SET wins=?, losses=?, draws=?, score=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, player.getWins());
            ps.setInt(2, player.getLosses());
            ps.setInt(3, player.getDraws());
            ps.setInt(4, player.getScore());
            ps.setInt(5, player.getId());

            ps.executeUpdate();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Player> getTopPlayers() {

        ArrayList<Player> list = new ArrayList<>();

        try {

            Connection conn = DatabaseManager.getConnection();

            String sql = "SELECT * FROM players ORDER BY score DESC LIMIT 5";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Player p = new Player();

                p.setId(rs.getInt("id"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setWins(rs.getInt("wins"));
                p.setLosses(rs.getInt("losses"));
                p.setDraws(rs.getInt("draws"));
                p.setScore(rs.getInt("score"));

                list.add(p);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}