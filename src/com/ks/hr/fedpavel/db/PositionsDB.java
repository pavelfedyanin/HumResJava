package com.ks.hr.fedpavel.db;

import com.ks.hr.fedpavel.entities.Position;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 23.06.14.
 */
public class PositionsDB {
    private Connection conn = null;

    public PositionsDB(Connection conn) {
        this.conn = conn;
    }

    public List<Position> getAllPositions() throws SQLException {
        List<Position> positions = new ArrayList<>();
        try ( Statement statement = conn.createStatement()) {
            ResultSet resSet = statement.executeQuery("SELECT * FROM positions");
            while (resSet.next()) {
                Position position = new Position(resSet.getInt("id"), resSet.getString("name"),resSet.getBigDecimal("minSalary"),resSet.getBigDecimal("maxSalary"));
                positions.add(position);
            }
        }
        return positions;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */

    public Position getPositionById(Integer id) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM positions WHERE id=?");
        statement.setInt(1, id);
        ResultSet resSet = statement.executeQuery();
        while (resSet.next()) {
            Position position = new Position(resSet.getInt("id"), resSet.getString("name"), resSet.getBigDecimal("minSalary"), resSet.getBigDecimal("maxSalary"));
            //System.out.println(position);
            return position;
        }
        return null;
    }

    /**
     *
     * @param position
     * @throws SQLException
     */
    public void savePosition(Position position) throws SQLException {
        if (position.getId() == null){// save to db
            PreparedStatement st = conn.prepareStatement("INSERT INTO positions (name) VALUES (?)");
            st.setString(1, position.getName());
            st.execute();
        } else { //update record in db
            PreparedStatement st = conn.prepareStatement("UPDATE positions SET  name =  (?) WHERE  positions.id = (?)");
            st.setString(1, position.getName());
            st.setInt(2, position.getId());
            st.execute();
        }
    }
}
