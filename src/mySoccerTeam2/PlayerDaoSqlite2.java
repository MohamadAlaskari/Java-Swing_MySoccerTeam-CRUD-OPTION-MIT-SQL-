
package mySoccerTeam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDaoSqlite2 {
	private final String CLASSNAME = "org.sqlite.JDBC";
	private final String CONNECTIONSTRING = "jdbc:sqlite:mySoccerTeam2.db";

	public PlayerDaoSqlite2() throws ClassNotFoundException {
		Class.forName(CLASSNAME);
	}

	protected Player readPlayer_First() throws DaoException2 {
		Player player = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = " Select * from Player2 Where rowid =(select min(rowid) from Player2)";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				player = creat_Opject(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2("es könnte die daten nicht gefunden werden");
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	protected Player readPlayer_last() throws DaoException2 {
		Player player = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = " Select * from Player2 Where rowid =(select max(rowid) from Player2)";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				player = creat_Opject(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2("es könnte die daten nicht gefunden werden");
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	protected Player player_vor(Player player) throws DaoException2 {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Player vor_player = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = "Select * from Player2 where id < ?  order by id desc LIMIT 1";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, player.getId());
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				vor_player = creat_Opject(resultSet);

			} else {
				throw new DaoException2("Es gibt keine vorherige Player");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2("Es könnte keine Daten gefunden werden ");

		} finally {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vor_player;

	}

	protected Player player_nach(Player plF) throws DaoException2 {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Player player = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = "Select * from Player2 where id > ? order by id  LIMIT 1";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, plF.getId());
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				player = creat_Opject(resultSet);

			} else {
				throw new DaoException2("Es gibt keine Nächste Player");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2("Es könnte keine Daten gefunden werden ");

		} finally {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return player;

	}

	protected void insert_Player(Player player) throws DaoException2 {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String Sql = "Insert Into Player2 (name , vorname, marktwert, teamId) Values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(Sql);
			preparedStatement.setString(1, player.getName());
			preparedStatement.setString(2, player.getVorname());
			preparedStatement.setDouble(3, player.getMarktwert());
			preparedStatement.setInt(4, player.getTeamId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2(
					"Es könnte den " + player.getName() + "," + player.getVorname() + " nicht hinzufügt werden");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected Player suchen_Player(int id) throws DaoException2, SQLException {
		Player player = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = "Select * From Player2 Where id= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = creat_Opject(resultSet);
			} else {
				throw new DaoException2("Es könnte keinen Player für dieses " + id + " gefunfen werden");
			}

		} catch (DaoException2 e) {
			e.printStackTrace();
			throw new DaoException2("Es wurder ein fehler getaucht wärend den Player suchen");
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	protected void update_Player(Player player) throws DaoException2 {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = "Update Player2 set name =? , vorname = ? , marktwert= ? , teamId = ? where id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, player.getName());
			preparedStatement.setString(2, player.getVorname());
			preparedStatement.setDouble(3, player.getMarktwert());
			preparedStatement.setInt(4, player.getTeamId());
			preparedStatement.setInt(5, player.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2("Es könte den gegebenen Player nicht geändert werden");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void loeschen_Player(Player player) throws DaoException2 {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = "Delete from Player2 Where id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, player.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2("Es könte den gegebenen Player nicht gelöscht werden");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	private Player creat_Opject(ResultSet resultSet) throws SQLException {
		Player player = new Player();
		player.setId(resultSet.getInt(1));
		player.setName(resultSet.getString(2));
		player.setVorname(resultSet.getString(3));
		player.setMarktwert(resultSet.getDouble(4));
		player.setTeamId(resultSet.getInt(5));
		return player;

	}
}
