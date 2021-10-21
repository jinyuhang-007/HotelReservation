package model;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    private RoomType enumeration;
    private boolean free;

    public Room(String roomNumber, Double price, RoomType enumeration, boolean free){
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
        this.free = free;
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
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumeration=" + enumeration +
                '}';
    }
}
