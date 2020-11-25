package com.dh.project02.returnJson;

import java.util.List;

/**
 * @Auther:D-hao
 * @Date:2020/11/12-11-12-16:40
 * @Description:com.dh.project02.returnJson
 */
public class Permissions {
    private List<Permission> permissions;

    public Permissions() {
    }

    public Permissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissions=" + permissions +
                '}';
    }
}
