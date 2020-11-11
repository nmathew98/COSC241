package week06;

import java.util.*;
/**
 * The application class for the first 241 practical test.
 * @author Naveen Mathew
 */
public class Prac1 {

    /** A list of people to be operated on. */
    private List<Person> people = new ArrayList<>();

    /**
     * Creates an instance of Prac1 and sends lines of input read from
     * stdin to its processLine() method.  Each line of input is
     * separated into the first word and the remainder of the line.
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        Prac1 app = new Prac1();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] line = input.nextLine().trim().split(" ", 2);
            String command = line[0];
            String remainder = line.length > 1 ? line[1] : "";
            app.processLine(command, remainder);
        }
    }

    public void processLine(String command, String line) {
        // If the command is "add" then create a new person p and update their
        //    details using updatePerson(p, line). Add the person to the people
        //    list and print "Added: " + person
        // If the command is "find" followed by an integer that matches the id
        //    of a person in the list of people, print "Found: " + person
        // If the command is "remove" followed by an integer that matches the id
        //    of a person in the list of people, print "Removed: " + person and
        //    remove that person from the list of people
        // If the command is "children" followed by a string, take the string
        //    to be the name of a sport and print out the id and name of every
        //    person in the list who has children and has the given sport in
        //    their list of sports
        // If the command is "older" followed by an integer, print out the name
        //    and age of every person with an age greater than the given integer
        if (command.equals("add")) {
                Person p = new Person();
                updatePerson(p, line);
                people.add(p);
                System.out.println("Added: " + p.toString());
        }
        if (command.equals("find")) {
                for (Person p : people) {
                    if (p.getID() == Integer.valueOf(line)) {
                        System.out.println("Found: " + p.toString());
                    }
                }
        }
        if (command.equals("remove")) {
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getID() == Integer.valueOf(line)) {
                        System.out.println("Removed: " + people.get(i).toString());
                        people.remove(i);
                    }
                }
        }
        if (command.equals("children")) {
            if (line.equals("") != true) {
                System.out.println("Parents who participate in " + line);
                for (Person p : people) {
                    if (p.getChildren() == true) {
                        if (p.getSports().contains(line) == true) {
                            System.out.println(p.getID() + ": " + p.getName());
                        }
                    }
                }
            }
        }
        if (command.equals("older")) {
            if (line.equals("") != true) {
                for (Person p : people) {
                    if (p.getAge() > Integer.valueOf(line)) {
                        System.out.println(p.getName() + " Age:" + p.getAge());
                    }
                }
            }
        }
        if (command.equals("print")) {
                System.out.println("Printing all");
                for (Person p : people) {
                    System.out.println(p);
                }
        }
    }

    private void updatePerson(Person p, String details) {
        String[] attributes = details.trim().split(",");
        for (String item : attributes) {
            Scanner s = new Scanner(item);
            if (s.hasNext()) {
                String selector = s.next().toLowerCase();
                // switch based on selector as follows:
                // if selector is "name" and if the scanner has another item, set
                //   the name of person to that item
                // if selector is "age" and the next item in the scanner is an
                //   integer, set the age of person to that integer
                // if selector is "children" and the next item in the scanner is a
                //   boolean, set the children attribute of person to that boolean
                // if selector is "sports" add all following items to the person's
                //   list of sports
                // Otherwise print out "Unknown attribute: " + selector
                switch (selector) {
                    case "name":
                        if (s.hasNext()) {
                            p.setName(s.next());
                        }
                        break;
                    case "age":
                        if (s.hasNextInt()) {
                            p.setAge(s.nextInt());
                        }
                        break;
                    case "children":
                        if (s.hasNextBoolean()) {
                            p.setChildren(s.nextBoolean());
                        }
                        break;
                    case "sports":
                        while (s.hasNext()) {
                            p.addSport(s.next());
                        }
                        break;
                    default:
                        System.out.println("Unknown attribute: " + selector);
                        break;
                }
            }
        }
    }
}
