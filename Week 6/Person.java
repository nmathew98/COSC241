package week06;

public class Person {

    private static int count = 0;
    private int id;
    private String name = "";
    private int age = -1;
    private boolean children;
    private WordList sports = new WordList();

    public Person() {
        this.id = Person.count;
        Person.count++;
    }

    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public boolean getChildren() {
        return this.children;
    }
    public WordList getSports() {
        return this.sports;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setChildren(boolean children) {
        this.children = children;
    }

    public void addSport(String sport) {
        sports = sports.add(sport);
    }

    public String toString() {
        return "Person{id=" + id + ", name=" + name + ", age=" + age + ", sports=" + sports + ", children=" + children + "}";
    }
}
