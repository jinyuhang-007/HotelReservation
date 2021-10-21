package model;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, RoomType enumeration, boolean free) {
        super(roomNumber, 0.0, enumeration, free);

    }

    @Override
    public String toString() {
        return "Free Room! "+super.toString();
    }
}



