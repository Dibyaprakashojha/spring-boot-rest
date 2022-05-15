package com.cameraapp.service;

import com.cameraapp.model.AppUser;

public interface IAppUserService {

    void addAppUser(AppUser user);
    void updateAppUser(AppUser user);
    void deleteAppUser(int userId);

}
