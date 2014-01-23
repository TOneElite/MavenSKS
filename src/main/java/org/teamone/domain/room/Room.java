/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.teamone.domain.room;

/**
 *
 * @author Ida
 */
public class Room {
    private String roomCode;
    private int tableCount;
    private String pictureLink;
    private String description;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public int getTableCount() {
        return tableCount;
    }

    public void setTableCount(int tableCount) {
        this.tableCount = tableCount;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "roomcode: " + roomCode + ", tablecount: " + tableCount +  ", picturelink: " + pictureLink + ", dscription: " + description;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Room)) return false;
		
		Room other = (Room) obj;
		if (!other.getDescription().equals(this.getDescription())) return false;
		if (!other.getPictureLink().equals(this.getPictureLink())) return false;
		if (!other.getRoomCode().equals(this.getRoomCode())) return false;
		if (other.getTableCount() != this.getTableCount()) return false;
		return true;
	}
}
