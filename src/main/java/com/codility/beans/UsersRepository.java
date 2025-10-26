package com.codility.beans;

public class UsersRepository {
    private boolean initialized = false;

    public UsersRepository(){
        System.out.println("[UsersRepository] Constructor.");
    }

    public void initialize(){
        this.initialized = true;
        System.out.println("[UsersRepository] initialize() called successfully. Status: "+initialized);
    }
    public boolean isInitialized(){
        return initialized;
    }
}
