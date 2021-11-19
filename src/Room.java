import java.util.ArrayList;

public class Room {
    private ArrayList<String> guests;
    private int total;

    public Room(int total) {
        setTotal(total);
        guests = new ArrayList<String>();
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<String> getGuests() {
        return guests;
    }

    public boolean addGuest(String guest) {
        if (this.guests.size() < total) {
            this.guests.add(guest);
            return true;
        }
        return false;
    }

    public int size() {
        return guests.size();
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
