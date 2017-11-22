package com.ascland.mapping;

import java.util.List;

/**
 * Created by Asus on 2017/11/16.
 */
public interface RoleMapper {

    /**
     * 自动映射
     *
     * @param roleId
     * @return
     */
    Role getRole(long roleId);

    /**
     * 主键回填
     *
     * @param role
     * @return
     */
    int insertRole(Role role);

    int getRoleCount(String role_name);

    int insertRoleSelectKey(Role role);

    void deleteRole(long id);

    List<Role> getAllRoles();

}
