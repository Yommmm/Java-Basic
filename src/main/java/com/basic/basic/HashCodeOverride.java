package com.basic.basic;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class HashCodeOverride {

    private String name;

    private String addr;

    private String password;

    private Integer field1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getField1() {
        return field1;
    }

    public void setField1(Integer field1) {
        this.field1 = field1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCodeOverride that = (HashCodeOverride) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return field1 != null ? field1.equals(that.field1) : that.field1 == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (field1 != null ? field1.hashCode() : 0);
        return result;
    }
}
