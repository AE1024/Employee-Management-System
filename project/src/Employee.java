import java.util.ArrayList;
import java.util.List;


public class Employee {
    private String name;
    private String surname;
    private String email;
    private String job;
    private List<String> skills = new ArrayList<>();

    public Employee(String name, String surname, String email, String job,List<String> skills) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.job = job;
        this.skills = skills;
    }

    // Getters & Setters
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getEmail() { return email; }
    public String getJob() { return job; }
    public List<String> getSkills() { return skills; }

}
