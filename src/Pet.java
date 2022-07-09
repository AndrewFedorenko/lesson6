public class Pet extends Object{
    public String name;
    public Owner Owner;
    public String age;

    public Pet(String name,String age){
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (!(object instanceof Pet)){
            return false;
        }
        Pet other = (Pet) object;
        return this.name != null && this.name.equals(other.name) &&
                this.Owner != null && this.Owner.equals(other.Owner) &&
                this.age != null && this.age.equals(other.age);
    }
}
