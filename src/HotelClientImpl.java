import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;

public class HotelClientImpl {

    private IHotelServer server;

    public HotelClientImpl() throws RemoteException {
    }

    public void startClient(String address) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(address, 1099);
        server = (IHotelServer) registry.lookup("Server");
    }

    public int revenue() {
        int result;
        try {
            result = server.revenue();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
        return result;
    }

    public boolean book(String name, Type type) {
        boolean result;
        try {
            result = server.book(name, type);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
        return result;
    }

    public ArrayList<String> guests() {
        ArrayList<String> result;
        try {
            result = server.guests();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
        return result;
    }

    public HashMap<Type, Integer> list() {
        HashMap<Type, Integer> result;
        try {
            result = server.list();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
        return result;
    }
}
