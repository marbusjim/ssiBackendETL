package com.ssid.api.apissidETL.services;

/**
 * @author Borisytu
 */
import com.ssid.api.apissidETL.domain.UserSystem;

import java.util.List;

public interface UserSystemService {
    List<UserSystem> getAllUsers();

    void saveUser(UserSystem user);

    UserSystem findByUserName(String userName);
}
