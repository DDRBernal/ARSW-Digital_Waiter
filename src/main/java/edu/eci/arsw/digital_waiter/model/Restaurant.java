package edu.eci.arsw.digital_waiter.model;

public class Restaurant implements User{

    private String name;
    private String phonenumber;
    private String email;
    private String age;
    private String pswd;

    public Restaurant(String name, String phonenumber, String email, String age, String pswd) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.age = age;
        this.pswd = pswd;
    }    

    public String getName() {
        return name;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public String getEmail() {
        return email;
    }
    public String getAge() {
        return age;
    }
    public String getPswd() {
        return pswd;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setPhonenumber(String newPhone) {
        this.phonenumber = newPhone;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public void setAge(String newAge) {
        this.age = newAge;
    }
    public void setPswd(String newPswd) {
        this.pswd = newPswd;
    }

    @Override
    public void rol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
