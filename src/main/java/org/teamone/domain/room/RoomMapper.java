package org.teamone.domain.room;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoomMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet rs, int i) throws SQLException {
        Room room = new Room();
        room.setRoomCode(rs.getString("room_code"));
        room.setTableCount(rs.getInt("tablecount"));
        room.setPictureLink(rs.getString("picturelink"));
        room.setDescription(rs.getString("description"));
        return room;
    }
}