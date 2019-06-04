package com.xiaofei.ssm.domain;

import java.util.List;

/**
 * <Description> <br>
 * 角色类
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/02<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class Role {
    /**
     * 主键 uuid
     */
    private String id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 一个角色拥有多个资源权限
     */
    private List<Permission> permissions;
    /**
     * 一个角色可以分配给多个用户
     */
    private List<UserInfo> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
