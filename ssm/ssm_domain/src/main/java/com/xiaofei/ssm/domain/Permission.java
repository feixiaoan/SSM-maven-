package com.xiaofei.ssm.domain;

import java.util.List;

/**
 * <Description> <br>
 * 资源权限
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/02<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class Permission {
    /**
     * 主键 uuid
     */
    private String id;
    /**
     * 权限名
     */
    private String permissionName;
    /**
     * 资源路径
     */
    private String url;
    /**
     * 一个权限分配给多个角色
     */
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
