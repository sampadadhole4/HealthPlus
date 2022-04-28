package Business.Employee;

/**
 *
 * @author Ching-Fong Chen
 */
public class Employee {
    private String name;
    private int id;
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
