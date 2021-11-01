import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class main {
    public static void main(String args[]) {

        User user = new User("Lana", 20);

        ArrayList<Todo> todos = new ArrayList<>();

        try {
            File file = new File("todos_storage.txt");
            if (file.exists()) {
                //! reading
                FileInputStream fileInput = new FileInputStream(new File("todos_storage.txt"));
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                todos = (ArrayList<Todo>) objectInput.readObject();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (todos.size() > 0) {
            logTodos(todos);

        }


        boolean isQuit = false;
        while (!isQuit) {
            System.out.println(logsMenus());
            int choose = 0;
            while (true){
                try{
                    Scanner sc = new Scanner(System.in);
                    choose = sc.nextInt();
                    System.out.println();
                    break;
                } catch (Exception exception) {
                    System.out.println("Please just enter numbers!");
                }
            }
            switch (choose) {
                case 1:
                    addTodo(todos, user);
                    break;
                case 2:
                    updateNoteStatus(todos, TodoStatus.INPROGRESS);
                    break;
                case 3:
                    updateNoteStatus(todos, TodoStatus.DONE);
                    break;
                case 4:
                    deteleTodo(todos);
                    break;
                case 5:
                    logTodos(todos);
                    break;
                case 0:
                    System.out.println("Good bye :)");
                    isQuit = true;
                    break;
                default:
                    break;
            }
        }

        try {

            //! writing
            FileOutputStream fileOutPut = new FileOutputStream(new File("todos_storage.txt"));
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutPut);

            objectOutput.writeObject(todos);
            objectOutput.close();
            fileOutPut.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }

    private static void addTodo(ArrayList<Todo> todos, User user) {
        System.out.print("Enter Description: ");
        Scanner sc1 = new Scanner(System.in);
        String description = sc1.nextLine();
        todos.add(new Todo(description, user.name, user.userId));
        System.out.println("Todo Added :)\n---------------------------------\n");
    }

    private static void deteleTodo(ArrayList<Todo> todos) {
        if (todos.size() > 0) {
            logTodos(todos);
            int todoId = 0;
            while (true){
                try{
                    System.out.print("Enter Todo Id: ");
                    Scanner sc1 = new Scanner(System.in);
                     todoId = sc1.nextInt();
                    break;
                } catch (Exception exception) {
                    System.out.println("Please just enter numbers!");
                }
            }
            for (int i = 0; i < todos.size(); i++) {
                if (todos.get(i).getNoteId() == todoId) {
                    todos.remove(i);
                    System.out.println("Todo Deleted :)\n---------------------------------\n");
                    break;
                }
            }
        } else {
            System.out.println("No Todo to delete :(\n---------------------------------\n");
        }
    }

    private static void logTodos(ArrayList<Todo> todos) {
        if (todos.size() > 0) {
            System.out.println("\n------------- YOUR TODOS -------------------\n");
            for (int i = 0; i < todos.size(); i++) {
                System.out.println((i + 1) + "- Todo: ");
                System.out.println(todos.get(i).displayNoteDetails());
                System.out.println("----------");
            }
            System.out.println("---------------------------------\n");
        } else {
            System.out.println("No Todo to display :(\n---------------------------------\n");
        }
    }

    private static void updateNoteStatus(ArrayList<Todo> todos, TodoStatus status) {
        if (todos.size() > 0) {
            logTodos(todos);
            int todoId = 0;
            while (true){
                try{
                    System.out.print("Enter Todo Id: ");
                    Scanner sc1 = new Scanner(System.in);
                    todoId = sc1.nextInt();
                    break;
                } catch (Exception exception) {
                    System.out.println("Please just enter numbers!");
                }
            }
            for (int i = 0; i < todos.size(); i++) {
                if (todos.get(i).getNoteId() == todoId) {
                    todos.get(i).updateTodoStatus(status);
                    todos.set(i, todos.get(i));
                    System.out.println("Todo Updated :)\n---------------------------------\n");
                    break;
                }
            }
        } else {
            System.out.println("No Todo to update :(\n---------------------------------\n");
        }
    }

    private static String logsMenus() {
        return "Choose one option:\n1-Add Todo\n2-In progress a todo\n3-Complete a todo\n4-Delete a note\n5-Show Todos\n0-Quit";
    }
}
