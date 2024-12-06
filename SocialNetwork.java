import java.util.*;

public class SocialNetwork {

    static List<String> people = new ArrayList<>();
    static List<List<Integer>> connections = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add people and connections
        addPerson("Alice");
        addPerson("Bob");
        addPerson("Charlie");
        addPerson("David");
        addConnection("Alice", "Bob");
        addConnection("Alice", "Charlie");
        addConnection("Bob", "David");

        System.out.println("Social Network Operations:");
        System.out.println("1. Add Person");
        System.out.println("2. Add Connection");
        System.out.println("3. Print Network");
        System.out.println("4. Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter person's name: ");
                    String name = scanner.nextLine();
                    addPerson(name);
                    System.out.println("Person added.");
                    break;
                case 2:
                    System.out.print("Enter person 1: ");
                    String person1 = scanner.nextLine();
                    System.out.print("Enter person 2: ");
                    String person2 = scanner.nextLine();
                    addConnection(person1, person2);
                    System.out.println("Connection added.");
                    break;
                case 3:
                    printNetwork();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addPerson(String name) {
        people.add(name);
        connections.add(new ArrayList<>()); // Add an empty adjacency list for the new person
    }

    static void addConnection(String person1, String person2) {
        int index1 = people.indexOf(person1);
        int index2 = people.indexOf(person2);

        if (index1 != -1 && index2 != -1) {
            connections.get(index1).add(index2);
            connections.get(index2).add(index1); // For an undirected graph
        } else {
            System.out.println("Invalid person name.");
        }
    }

    static void printNetwork() {
        for (int i = 0; i < people.size(); i++) {
            System.out.print(people.get(i) + ": ");
            for (int j : connections.get(i)) {
                System.out.print(people.get(j) + " ");
            }
            System.out.println();
        }
    }
}
