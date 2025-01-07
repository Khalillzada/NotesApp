import java.util.ArrayList;
import java.util.Scanner;

public class NotesManager {
    private final ArrayList<Note> notes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nNotes App Menu:");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Edit Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer
            switch (choice) {
                case 1 -> addNote();
                case 2 -> viewNotes();
                case 3 -> editNote();
                case 4 -> deleteNote();
                case 5 -> {
                    System.out.println("Exiting Notes App.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNote() {
        System.out.print("Enter note title: ");
        String title = scanner.nextLine();
        System.out.print("Enter note content: ");
        String content = scanner.nextLine();
        notes.add(new Note(title, content));
        System.out.println("Note added successfully.");
    }

    private void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    private void editNote() {
        viewNotes();
        if (!notes.isEmpty()) {
            System.out.print("Enter note number to edit: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();  // Clear the buffer
            if (index >= 0 && index < notes.size()) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                System.out.print("Enter new content: ");
                String newContent = scanner.nextLine();
                notes.get(index).setTitle(newTitle);
                notes.get(index).setContent(newContent);
                System.out.println("Note updated successfully.");
            } else {
                System.out.println("Invalid note number.");
            }
        }
    }

    private void deleteNote() {
        viewNotes();
        if (!notes.isEmpty()) {
            System.out.print("Enter note number to delete: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < notes.size()) {
                notes.remove(index);
                System.out.println("Note deleted successfully.");
            } else {
                System.out.println("Invalid note number.");
            }
        }
    }
}
