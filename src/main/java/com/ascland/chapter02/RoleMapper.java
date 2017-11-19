package com.ascland.chapter02;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus on 2017/11/16.
 */
public interface RoleMapper {

    Role getRole(long id);

    HashMap getRoleAsMap(long id);

    int getRoleCount(String role_name);

    int insertRole(Role role);

    int insertRoleSelectKey(Role role);

    void deleteRole(long id);

}
