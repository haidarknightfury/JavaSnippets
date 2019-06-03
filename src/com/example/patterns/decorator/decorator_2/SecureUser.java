package com.example.patterns.decorator.decorator_2;

import org.mindrot.jbcrypt.BCrypt;

public class SecureUser implements IUser {

    private IUser user;

    public SecureUser(IUser iuser) {
        this.user = iuser;
    }

    @Override
    public String getPassword() {
        return BCrypt.hashpw(this.user.getPassword(), BCrypt.gensalt());
    }

    @Override
    public String getUserName() {
        return this.user.getUserName();
    }

    @Override
    public String toString() {
        return "SecureUser [" + "getPassword()=" + this.getPassword() + ", getUserName()=" + this.getUserName() + "]";
    }

}
