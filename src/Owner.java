public class Owner extends Object{
    public String firstName;
    public String lastName;
    public String age; // may be integer, but string for simplicity
    public String address;
    public String phone;

    public Owner(String firstName,String lastName,String age,String address,String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (!(object instanceof Owner)){
            return false;
        }
        Owner other = (Owner) object;
        return this.firstName != null && this.firstName.equals(other.firstName) &&
                this.lastName != null && this.lastName.equals(other.lastName) &&
                this.age != null && this.age.equals(other.age) &&
                this.address != null && this.address.equals(other.address) &&
                this.phone != null && this.phone.equals(other.phone);
    }

}
