package org.teamone.domain.room;

import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author Kim
 */
public class RoomJDBCTemplateTest {

    private EmbeddedDatabase db;
    private DataSource dataSource;
    private RoomJDBCTemplate jdbc = new RoomJDBCTemplate();

    @Before
    public void setUp() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        db = builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("data.sql").build();
        dataSource = db;
        jdbc.setDataSource(dataSource);
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

    /**
     * Test of getRoom method, of class RoomJDBCTemplate.
     */
    @Test
    public void testGetRoom() {
        String id = "KA-BR233";
        Room room = jdbc.getRoom(id);

        assertEquals(room.getRoomCode(), "KA-BR233");
        assertEquals(room.getTableCount(), 9);
        assertEquals(room.getPictureLink(), "/res/labb1.bmp");
        assertEquals(room.getDescription(), "Labben i 2.Etasje?");
    }

    /**
     * Test of listRoom method, of class RoomJDBCTemplate.
     */
    @Test
    public void testListRoom() {
        List<Room> rooms = jdbc.listRoom();

        assertTrue(rooms.size() == 2);

        assertEquals(rooms.get(0).getRoomCode(), "KA-BR233");
        assertEquals(rooms.get(0).getTableCount(), 9);
        assertEquals(rooms.get(0).getPictureLink(), "/res/labb1.bmp");
        assertEquals(rooms.get(0).getDescription(), "Labben i 2.Etasje?");

        assertEquals(rooms.get(1).getRoomCode(), "KA-KE101");
        assertEquals(rooms.get(1).getTableCount(), 5);
        assertEquals(rooms.get(1).getPictureLink(), "/res/kake.jpg");
        assertEquals(rooms.get(1).getDescription(), "Grupperom");
    }
}