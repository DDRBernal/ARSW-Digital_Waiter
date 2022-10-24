package edu.eci.arsw.digital_waiter.model;

public class Admin implements User {

    private String id;
    private String name;
    private String phonenumber;
    private String email;
    private String age;
    private String pswd;

    public Admin(String id, String name, String phonenumber, String email, String age, String pswd) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.age = age;
        this.pswd = pswd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhonenumber() {
        return phonenumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public String getPswd() {
        return pswd;
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public void setPhonenumber(String newPhone) {
        this.phonenumber = newPhone;
    }

    @Override
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    @Override
    public void setAge(String newAge) {
        this.age = newAge;
    }

    @Override
    public void setPswd(String newPswd) {
        this.pswd = newPswd;
    }

    @Override
    public void rol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String newId) {
        this.id = newId;
    }
}
