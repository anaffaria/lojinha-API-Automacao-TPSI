package dataFactory;

import pojo.UserPojo;

public class UserDataFactory {
    public static UserPojo createAdminUser(){

        UserPojo user = new UserPojo();
        user.setUsuarioLogin("admin");
        user.setUsuarioSenha("admin");
        return user;
    }
}
