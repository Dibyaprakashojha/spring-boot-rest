package com.productapp.service;

import com.productapp.model.AppUser;

public interface IAppUserService {

    void addAppUser(AppUser user);
    void updateAppUser(AppUser user);
    void deleteAppUser(int userId);

}
