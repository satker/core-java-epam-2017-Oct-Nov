package com.epam.courses.jf.se5;

import java.rmi.AccessException;
import java.rmi.RemoteException;

public class ThrowsList {

    public static void remoteMethod() throws RemoteException, AccessException {
        try {
            if (true) {
                throw new RemoteException("this is RemoteException");
            } else {
                throw new AccessException("this is RemoteException");
            }
        } catch(Exception e){
            throw e;
        }
    }
}
