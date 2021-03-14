package dev.debride.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private int id;

    @Column(name="first_name")
    private String fname;

    @Column(name="last_name")
    private String lname;

    @Column(name="user_name")
    private String uname;

    @Column(name="pass_hash")
    private String phash;

    @Column(name="manager_flag")
    private boolean manflag;


    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private Set<Expense> expenses = new HashSet<Expense>();

    public Employee(){}

    public Employee(int id, String fname, String lname, String uname, String phash, boolean manflag) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.phash = phash;
        this.manflag = manflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhash() {
        return phash;
    }

    public void setPhash(String phash) {
        this.phash = phash;
    }

    public boolean isManflag() {
        return manflag;
    }

    public void setManflag(boolean manflag) {
        this.manflag = manflag;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", phash='" + phash + '\'' +
                ", manflag=" + manflag +
                '}';
    }
}
