package TheFitnessApp;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private String email;
    private List<PR> prs;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.prs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<PR> getPrs() {
        return prs;
    }

    public void GetPrs(PR pr) {
        prs.add(pr);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", prs=" + prs +
                '}';
    }
}// End of User class  