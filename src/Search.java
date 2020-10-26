
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class Search {
 
    public static void main(String a[]){
         
        List<users> List = new ArrayList<users>();
        List.add(new users(12,"Name1",50));
        List.add(new users(13,"Name2",20));
        List.add(new users(14,"Name3",40));
        List.add(new users(15,"Name4",44));
        List.add(new users(16,"Name5",10));
         
        users searchKey = new users(12,"Name1",50);
        int index = Collections.binarySearch(List, searchKey, new Comp());
        System.out.println("Index of the searched key: "+index);
    }
}
 
class Comp implements Comparator<users>{
 
    public int compare(users e1, users e2) {
        if(e1.getusersId() == e2.getusersId()){
            return 0;
        } else {
            return -1;
        }
    }
}
 
class users {
     
    private int usersId;
    private String usersName;
    private int usersSal;
     
    public users(int id, String name, int sal){
        this.usersId = id;
        this.usersName = name;
        this.usersSal = sal;
    }
     
    public int getusersId() {
        return usersId;
    }
     
    public void setusersId(int usersId) {
        this.usersId = usersId;
    }
     
    public String getusersName() {
        return usersName;
    }
     
    public void setusersName(String usersName) {
        this.usersName = usersName;
    }
     
    public int getusersSal() {
        return usersSal;
    }
    public void setusersSal(int usersSal) {
        this.usersSal = usersSal;
    }
     
    public String toString(){
        return usersId+" : "+usersName+" : "+usersSal;
    }
}