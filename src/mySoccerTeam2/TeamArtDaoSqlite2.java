package mySoccerTeam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamArtDaoSqlite2 {

	private final String CLASSNAME = "org.sqlite.JDBC";
	private final String CONNECTIONSTRING = "jdbc:sqlite:mySoccerTeam2.db";

	public TeamArtDaoSqlite2() throws ClassNotFoundException {
		Class.forName(CLASSNAME);
	}

	public ArrayList<Team> read_Team() throws DaoException2 {
		ArrayList<Team> team_list = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			String sql = "Select * from Team2";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Team team = new Team();
				team.setId(resultSet.getInt(1));
				team.setName(resultSet.getString(2));
				team_list.add(team);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException2("Es könnte Keine daten gefunden werden");
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return team_list;
	}

}
