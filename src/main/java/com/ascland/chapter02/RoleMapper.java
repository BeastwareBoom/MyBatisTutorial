package com.ascland.chapter02;

/**
 * Created by Asus on 2017/11/16.
 */
public interface RoleMapper {

    Role getRole(long id);

    void insertRole(Role role);

    void deleteRole(long id);

}
