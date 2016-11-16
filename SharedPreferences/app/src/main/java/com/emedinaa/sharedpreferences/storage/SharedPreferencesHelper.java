package com.emedinaa.sharedpreferences.storage;

import com.emedinaa.sharedpreferences.entity.User;

/**
 * Created by eduardomedina on 15/11/16.
 */
public interface SharedPreferencesHelper {

    void saveEmail (String email);
    String email();

    void saveUser(User user);
    User user();

    void clear();
}
