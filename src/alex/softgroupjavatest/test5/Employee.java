package alex.softgroupjavatest.test5;

import java.io.Serializable;

public abstract class Employee implements Serializable{
    private int id;
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String email;

    public Employee (int id,
                    String name,
                    String surname,
                    int age,
                    String  phoneNumber,
                    String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public abstract double calculatePayment();

    @Override
    public String toString() {
        return "\nid: " + getId() +
                "\nName: " + getName() +
                "\nSurname: " + getSurname() +
                "\nAge: " + getAge() +
                "\nPhone: " + getPhoneNumber() +
                "\nEmail: " + getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getId() == employee.getId() &&
                getAge() == employee.getAge() &&
                getName().equals(employee.getName()) &&
                getSurname().equals(employee.getSurname()) &&
                getPhoneNumber().equals(employee.getPhoneNumber()) &&
                getEmail().equals(employee.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getPhoneNumber().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }
}
