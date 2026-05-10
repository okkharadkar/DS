import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl
        extends UnicastRemoteObject
        implements AddServerIntf {

    public AddServerImpl()
            throws RemoteException {

        super();
    }

    public double add(double num1, double num2)
            throws RemoteException {

        System.out.println(
            "Handled by Thread: "
            + Thread.currentThread().getName()
        );

        return num1 + num2;
    }
}