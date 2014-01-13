package org.teamone.domain;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class RoomJDBCTemplate {

    DataSource dataSource;
    JdbcTemplate jdbcTemplateOjbect;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateOjbect = new JdbcTemplate(dataSource);
    }

    public Room getRoom(String roomCode) {
        String SQL = "SELECT * FROM room WHERE room_code=?";
        Room room = (Room) jdbcTemplateOjbect.queryForObject(SQL, new Object[]{roomCode}, new RoomMapper());
        return room;
    }

    public List<Room> listRoom() {
        String SQL = "SELECT * FROM room";
        List<Room> rooms = jdbcTemplateOjbect.query(SQL, new RoomMapper());
        return rooms;
    }
}