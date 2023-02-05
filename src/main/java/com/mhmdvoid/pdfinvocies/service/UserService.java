package com.mhmdvoid.pdfinvoices.service;

import java.util.UUID;

import com.mhmdvoid.pdfinvoices.model.User;

public class UserService {

    public User lookupById(String id) {
        String randomName = UUID.randomUUID().toString();
        // This is a very simple project, Hence, lookup: invoking storage system and find record with matching id.
        // If not found, create one, otherwise return existing.
        return new User(id, randomName);
    }
}
