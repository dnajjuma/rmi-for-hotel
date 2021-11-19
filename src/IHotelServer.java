import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IHotelServer extends Remote {

    // books a room of the specified type (if available), and registers the name of
    // the guest.
    boolean book(String name, Type type) throws RemoteException;

    // list the names of all the registered guests
    ArrayList<String> guests() throws RemoteException;

    // prints the revenue breakdown based on the booked rooms and their types.
    int revenue() throws RemoteException;

    HashMap<Type, Integer> list() throws RemoteException;
}
