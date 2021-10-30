package model;

import java.util.Objects;

public class Room implements IRoom{
    private final String roomNumber;
    private final Double price;
    private final RoomType enumeration;
    private final boolean free;

    public Room(String roomNumber, Double price, RoomType enumeration, boolean isfree){
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
        this.free = isfree;
    }

    public Room(Room room){
        this.roomNumber = room.roomNumber;
        this.price = room.price;
        this.enumeration = room.enumeration;
        this.free = room.free;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return free == room.free && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(price, room.price) && enumeration == room.enumeration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, price, enumeration, free);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumeration=" + enumeration +
                '}';
    }
}
