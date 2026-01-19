import java.util.*;
import java.util.ArrayList;

class Task
{
    private int id;
    private String title;
    private boolean status;

        public Task(int id,String title){
            this.id=id;
            this.title=title;
            this.status=false;
        }
        public int getId(){return id;}
        public String getTitle(){return title;}
        public boolean getStatus(){return status;}

        public void viewTask(){
            System.out.println("Id  :   "+id);
            System.out.println("Title : "+title);
            if(status){
                System.out.println("Completed");
            }
            else{
                System.out.println("Pending");
            }
            
        }
        public void MarkTask(){
           this.status=true;
        }


}
public class TaskManagement
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task>tasks=new ArrayList<>();

        while(true){
            System.out.println("Enter 1 to add Task");
            System.out.println("Enter 2 to view Tasks");
            System.out.println("Enter 3 to Mark Task");
            System.out.println("Enter 4 to Remove Task");
            System.out.println("Enter 5 to view All Completed Tasks");
            System.out.println("Enter 6 to view All Pending Tasks");
            System.out.println("Enter 7 to Exit");
            try{
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                        System.out.println("Enter Task Id");
                        int id=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Task Title");
                        String title=sc.nextLine();
                        

                        tasks.add(new Task(id, title));
                        System.out.println("Task Added");
                        

                    break;
                case 2:
                        if(tasks.isEmpty()){
                            System.out.println("No Task");
                        }
                        else{
                            for(Task t:tasks){
                                t.viewTask();
                            }
                        }
                        break;
                case 3:
                        if(tasks.isEmpty()){
                            System.out.println("No Task");
                        }
                        else{
                        System.out.println("Enter Task Id to Mark Complete");
                        int taskId=sc.nextInt();
                        boolean found=false;
                        for(Task t:tasks){
                            if(taskId==t.getId()){
                                t.MarkTask();
                                System.out.println("Task Completed");
                                found =true;
                                break;

                            }
                        }
                         if(!found){
                            System.out.println("Task Not found");
                        }
                    }
                       
                        break;
                case 4:
                        if(tasks.isEmpty()){
                            System.out.println("No Task");
                        }
                        else{
                        System.out.println("Enter Task Id to remove Task");
                        int taskId=sc.nextInt();
                        boolean found=false;
                        for(int i=0;i<tasks.size();i++){
                            if(taskId==tasks.get(i).getId()){
                                tasks.remove(i);
                                System.out.println("Task Removed");
                                found=true;
                            }
                        }
                        if(!found){
                            System.out.println("Task Not Found");
                        }
                    }
                        break;
                case 5:
                        if(tasks.isEmpty()){
                            System.out.println("No Task");
                        }
                        else{
                        for(Task t:tasks){
                            if(t.getStatus()){
                                System.out.println("Cpmleted Tasks");
                                t.viewTask();
                            }
                            else{
                                System.out.println("No Completed Tasks");
                                break;
                            }
                        }
                    }
                        
                        break;
                case 6:
                        if(tasks.isEmpty()){
                            System.out.println("No Tasks");
                        }
                        else{
                        for(Task t:tasks){
                            if(!t.getStatus()){
                                System.out.println("Pending Tasks");
                                t.viewTask();
                            }
                            else{
                                System.out.println("No Pending Tasks");
                                break;
                            }
                            }
                        }
                        
                        break;
                case 7:
                        System.out.println("Exited") ;
                        return;
                       
            
                default:
                        System.out.println("Invalid Input");
                    break;
            }
             } catch(InputMismatchException e){
                System.out.println("Invalid Input");
                sc.nextLine();
             }
            }
        
    }
}