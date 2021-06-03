package Main;

public class Employee extends Person implements Comparable {
    private int scalary = 0;
    Employee(int scalary){
        super();
        this.scalary=scalary;
    };

    public void setScalary(int scalary) {
        this.scalary = scalary;
    }

    public int getScalary() {
        return scalary;
    }

    @Override
    public int compareTo(Object o) {
        Employee other = (Employee) o;
        if (scalary < other.getScalary())
            return -1;
        else if (scalary > other.getScalary())
            return 1;
        return 0;
    }
}
