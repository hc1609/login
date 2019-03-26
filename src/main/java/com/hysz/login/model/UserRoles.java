package com.hysz.login.model;

import java.io.Serializable;
import java.util.List;

public class UserRoles implements Serializable {
    private Integer userid;

    private String account;

    private String password;

    /**
     * 角色名称
     *
     * @mbg.generated
     */
    private List<String> rolenames;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRolenames() {
		return rolenames;
	}

	public void setRolenames(List<String> rolenames) {
		this.rolenames = rolenames;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", rolename=").append(rolenames);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}