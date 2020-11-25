package com.dh.project02.returnJson;

/**
 * @Auther:D-hao
 * @Date:2020/11/12-11-12-16:39
 * @Description:com.dh.project02.returnJson
 */
public class Permission {
    private String permissionId;

    public Permission() {
    }

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                '}';
    }
}
