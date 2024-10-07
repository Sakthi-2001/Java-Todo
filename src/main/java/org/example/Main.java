package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TodoService lst = new TodoService();
        int count=1;
        String title;
        String description;
        String status;
        System.out.println("Todo App");
        boolean condition = true;
        while(condition){
            System.out.println("Select Option: ");
            System.out.println("1.Create TodoItem");
            System.out.println("2.Get All TodoItems");
            System.out.println("3.Get a single TodoItem");
            System.out.println("4.Update a TodoItem");
            System.out.println("5.Delete a TodoItem");
            System.out.println("6.Update status");
            System.out.println("7.Get TodoItems by status");
            System.out.println("8.Search TodoItem by title");
            System.out.println("9.Quit");
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            switch(input){
                case 1 : {
                    scan.nextLine();
                    System.out.print("Enter the title: ");
                    title = scan.nextLine();
                    System.out.print("Enter the description: ");
                    description = scan.nextLine();
                    lst.addItems(count,title,description);
                    count+=1;
                    System.out.println("Item added successfully");
                    break;
                }
                case 2 : {
                    System.out.println(" ");
                    lst.showItems();
                    System.out.println(" ");
                    break;
                }
                case 3 : {
                    System.out.print("Enter the task id: ");
                    int id = scan.nextInt();
                    lst.getItem(id);
                    System.out.println(" ");
                    break;
                }
                case 4 : {
                    System.out.print("Enter task id: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    if(!lst.isPresent(id)){
                        System.out.println("Enter a valid task id to update!!");
                        break;
                    }
                    System.out.print("Enter the updated title: ");
                    String updatedTitle = scan.nextLine();
                    System.out.print("Enter the updated description: ");
                    String updatedDesc = scan.nextLine();
                    System.out.print("Enter the updated status(pending/completed): ");
                    String updatedStatus = scan.nextLine();
                    TodoItem.Status validatedStatus;
                    try{
                        validatedStatus = lst.checkValidStatus(updatedStatus.toUpperCase());
                        lst.updateItem(id,updatedTitle,updatedDesc,validatedStatus);
                    }
                    catch (Exception e){
                        System.out.println("Enter a valid status type");
                    }
                    System.out.println(" ");
                    break;
                }
                case 5 : {
                    System.out.print("Enter the task id to delete : ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    lst.deleteItem(id);
                    break;
                }
                case 6 : {
                    System.out.print("Enter the task id: ");
                    int id = scan.nextInt();
                    if(!lst.isPresent(id)){
                        System.out.println("Enter a valid task id to update!!");
                        break;
                    }
                    scan.nextLine();
                    System.out.print("Enter the updated status: ");
                    String updatedStatus = scan.nextLine();
                    try{
                        TodoItem.Status validStatus = lst.checkValidStatus(updatedStatus.toUpperCase());
                        lst.updateStatus(id,validStatus);
                    }
                    catch (Exception e){
                        System.out.println("Enter a valid status type");
                    }
                    break;
                }

                case 7 : {
                    scan.nextLine();
                    System.out.print("Enter status type to fetch items: ");
                    String statusType = scan.nextLine().toUpperCase();
                    lst.getItemByStatus(statusType);
                    break;
                }

                case 8 : {
                    System.out.print("Enter the title to get item: ");
                    scan.nextLine();
                    String titleToFetch = scan.nextLine().toLowerCase();
                    lst.getItemByTitle(titleToFetch);
                    break;
                }

                case 9 : {
                    condition = false;
                    break;
                }
                default : {
                    System.out.println("Select a valid option");
                    break;
                }

            }
        }
        System.out.println("Loop ended");
    }

}
