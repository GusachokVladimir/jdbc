public class Staff {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String post;
    private String specialty;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }

    public Staff(){

    }

    public Staff(int id, String name, String surname, int age, String post, String specialty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.post = post;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
