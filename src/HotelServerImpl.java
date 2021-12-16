import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;



public class HotelServerImpl implements IHotelServer {
    HashMap<String, Room> rooms = new HashMap<>();

    public HotelServerImpl() throws RemoteException {
        rooms.put("type0", new Room(10));
        rooms.put("type1", new Room(20));
        rooms.put("type2", new Room(5));
        rooms.put("type3", new Room(3));
        rooms.put("type4", new Room(2));
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public ArrayList<String> guests() throws RemoteException {
        ArrayList<String> guestsList = new ArrayList<>();
        for (String key : rooms.keySet()) {
            guestsList.addAll(this.rooms.get(key).getGuests());
        }
        return guestsList;
    }

    @Override
    public int revenue() throws RemoteException {
        int total = 0;
        for (String key : rooms.keySet()) { 
            if (key == "type0") {
                total += 55000 * this.rooms.get(key).size();
            }
            if (key == "type1") {
                total += 75000 * this.rooms.get(key).size();
            }
            if (key == "type2") {
                total += 80000 * this.rooms.get(key).size();
            }
            if (key == "type3") {
                total += 150000 * this.rooms.get(key).size();
            }
            if (key == "type4") {
                total += 230000 * this.rooms.get(key).size();
            }
        }
        return total;
    }

    @Override
    public boolean book(String name, Type type) throws RemoteException {
        switch (type) {
        case TYPE0:
            return rooms.get("type0").addGuest(name);
        case TYPE1:
            return rooms.get("type1").addGuest(name);
        case TYPE2:
            return rooms.get("type2").addGuest(name);
        case TYPE3:
            return rooms.get("type3").addGuest(name);
        case TYPE4:
            return rooms.get("type4").addGuest(name);
        default:
            return false;
        }
    }

    @Override
    public HashMap<Type, Integer> list() throws RemoteException {
        HashMap<Type, Integer> lists = new HashMap<>();
        for (String key : rooms.keySet()) {
            if (key.equals("type0")) {
                lists.put(Type.TYPE0, (this.rooms.get(key).getTotal() - this.rooms.get(key).size()));
            }
            if (key.equals("type1")) {
                lists.put(Type.TYPE1, (this.rooms.get(key).getTotal() - this.rooms.get(key).size()));
            }
            if (key.equals("type2")) {
                lists.put(Type.TYPE2, (this.rooms.get(key).getTotal() - this.rooms.get(key).size()));
            }
            if (key.equals("type3")) {
                lists.put(Type.TYPE3, (this.rooms.get(key).getTotal() - this.rooms.get(key).size()));
            }
            if (key.equals("type4")) {
                lists.put(Type.TYPE4, (this.rooms.get(key).getTotal() - this.rooms.get(key).size()));
            }
        }
        return lists;
    }
}
