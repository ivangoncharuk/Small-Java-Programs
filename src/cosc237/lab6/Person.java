package cosc237.lab6;

public class Person {
    protected String firstName;
    protected String lastName;

    public Person() {
        firstName = "";
        lastName = "";
    }

    public Person(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public void setName(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void print() {
        System.out.printf("%s %s", firstName, lastName);
    }

    public void printLastFirst() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return String.format("%s, %s", lastName, firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return firstName.equals(p.getFirstName()) && lastName.equals(p.getLastName());
    }

    public void copy(Person person) {
        if (person != null) {
            firstName = person.firstName;
            lastName = person.lastName;
        }
    }

    public Person getCopy() {
        return new Person(firstName, lastName);
    }
}
