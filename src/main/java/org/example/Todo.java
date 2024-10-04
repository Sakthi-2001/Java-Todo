package org.example;
import java.util.*;

public class Todo{
    HashMap<Integer,HashMap> hash;
    Todo(){
        hash = new HashMap<>();
    }
    public void addItems(int id,String title,String description, String status){
        HashMap<String,String> temp = new HashMap<>();
        temp.put("title",title);
        temp.put("description",description);
        temp.put("status",status);
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
            v.forEach((heading,val) -> {
                System.out.print(heading);
                System.out.print(" -> ");
                System.out.print(val);
                System.out.print("  ");
            });
            System.out.println(" ");
        });
    }
    public void getItem(Integer id){
        if(!this.isPresent(id)){
            System.out.println("No item found!!");
            System.out.println(" ");
            return;
        }
        hash.get(id).forEach((heading,val) -> {
            System.out.print(heading);
            System.out.print(" -> ");
            System.out.print(val);
            System.out.print("  ");
        });
    }

    public void updateStatus(Integer id, String status){
        HashMap<String,String> temp = hash.get(id);
        temp.put("status",status);
        hash.put(id,temp);
    }

    public void deleteItem(Integer id){
        hash.remove(id);
    }
    public void updateItem(Integer id, String title, String description, String status){
        HashMap<String,String> temp = hash.get(id);
        temp.put("title",title);
        temp.put("description",description);
        temp.put("status",status);
        hash.put(id,temp);
    }
    public void getItemByStatus(String status){
        ArrayList<String> items = new ArrayList<>();
        hash.forEach((k,v) -> {
            if(v.get("status").toString().toLowerCase().equals(status)){
                items.add(v.get("title").toString());
            }
        });
        System.out.println(items);

    }
    public void getItemByTitle(String title){
        final boolean[] flag = {false};
        hash.forEach((k,v) -> {
            if(!flag[0] && v.get("title").toString().toLowerCase().equals(title.toLowerCase())){
                System.out.println(v);
                flag[0]=true;
            }
        });
        if(!flag[0])
            System.out.println("No such item found");
    }

}