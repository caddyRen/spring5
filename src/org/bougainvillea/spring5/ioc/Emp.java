package org.bougainvillea.spring5.ioc;

/**
 * 一个员工属于一个部门
 */
public class Emp {
    private String name;
    private Dept dept;

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void show(){
        System.out.println(dept.getName()+"::"+name);
    }
}
