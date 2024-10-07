package org.example;
import java.util.*;

public class TodoService {
    private HashMap<Integer,TodoItem> hash;
    TodoService(){
        hash = new HashMap<>();
    }
    public void addItems(int id,String title,String description){
        TodoItem temp = new TodoItem(id,title,description, TodoItem.Status.PENDING);
        hash.put(id,temp);

    }
    public boolean isPresent(int id){
        return hash.containsKey(id);
    }

    public void showItems(){
        if(hash.size()==0){
            System.out.println("No items present!!");
            return;
        }
        hash.forEach((k,v) -> {
            System.out.print(k + " - ");
            System.out.print("  Title -> ");
            System.out.print(v.getTitle());
            System.out.print("  Description -> ");
            System.out.print(v.getDescription());
            System.out.print("  status -> ");
            System.out.print(v.getStatus());
            System.out.println(" ");
        });
    }
    
    public void getItem(Integer id){
        try{
            TodoItem item = hash.get(id);
            item.getTitle();
            System.out.print(id + " - ");
            System.out.print("  Title -> ");
            System.out.print(item.getTitle());
            System.out.print("  Description -> ");
            System.out.print(item.getDescription());
            System.out.print("  status -> ");
            System.out.print(item.getStatus());
            System.out.println(" ");
        }
        catch (Exception e){
            System.out.println("No item found");
        }

    }

    public void updateStatus(Integer id, TodoItem.Status status){
        TodoItem item = hash.get(id);
        item.setStatus(status);
    }

    public void deleteItem(Integer id){
        if(!isPresent(id)){
            System.out.println("Enter a valid item to delete");
            return;
        }
        hash.remove(id);
        /*try{
            if(!this.isPresent(id)){
                throw new java.lang.RuntimeException(" ");
            }
            hash.remove(id);
        }
        catch (Exception e){
            System.out.println("Enter a valid item to delete");
        }*/

    }
    public void updateItem(Integer id, String title, String description, TodoItem.Status status){
        TodoItem item = hash.get(id);
        item.setTitle(title);
        item.setDescription(description);
        item.setStatus(status);
    }

    public void getItemByStatus(String status){
        try{
            if(!status.equals("PENDING") && !status.equals("COMPLETED")){
                System.out.println("Enter a valid status type ( PENDING/COMPLETED)");
                throw new java.lang.RuntimeException(" ");
            }
            ArrayList<String> items = new ArrayList<>();
            hash.forEach((k,v) -> {
                if(v.getStatus().toString().equals(status)){
                    items.add(v.getTitle().toString());
                }
            });
            System.out.println(items);
        }
        catch (Exception e){
            System.out.println("Enter a valid status type!!");
        }


    }
    public void getItemByTitle(String title){
        try{
            final boolean[] flag = {false};
            hash.forEach((k,item) -> {
                if(!flag[0] && item.getTitle().toString().toLowerCase().equals(title.toLowerCase())){
                    System.out.print(k + " - ");
                    System.out.print("  Title -> ");
                    System.out.print(item.getTitle());
                    System.out.print("  Description -> ");
                    System.out.print(item.getDescription());
                    System.out.print("  status -> ");
                    System.out.print(item.getStatus());
                    System.out.println(" ");
                    flag[0]=true;
                }
            });
            if(!flag[0]){
                throw new java.lang.RuntimeException(" ");
            }
        }
        catch (Exception e){
            System.out.println(String.format("Item with title \"%s\" not found",title));
        }
    }

    public TodoItem.Status checkValidStatus (String status){
        try{
            return TodoItem.Status.valueOf(status.toUpperCase());
        } catch(Exception e){
            System.out.println("Status type invalid");
        }
        return TodoItem.Status.valueOf(status);
    }

}