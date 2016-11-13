package com.ismael.uedcontrol.interfaces;

public interface ILogin {

        int PASSWORD_DIGIT = 1;
        int PASSWORD_CASE = 2;
        int PASSWORD_LENGTH = 3;
        int DATA_EMPTY = 4;

        interface View{
            public void setMessageError(String error, int idview);
        }

        interface Presenter{
            public boolean validateCredentials(String user, String passw);
        }

}
