import java.io.Serializable;

public class Todo implements Serializable {
    public int todoId;
    public String description;
    public String createdBy;
    public int ownerId;
    public TodoStatus todoStatus;

    private static int min = 1;
    private  static int max = 100000;

    Todo(){
        description="";
        createdBy="";
        todoId=0;
        ownerId=0;
        todoStatus = TodoStatus.PENDING;
    }

    Todo(String description, String createdBy , int ownerId){
        this.description = description;
        this.createdBy = createdBy;
        this.ownerId=ownerId;

        this.todoId = (int) Math.round(Math.random()*(max-min+1)+min);
        this.todoStatus = TodoStatus.PENDING;

    }

    public String getNoteDescription(){
        return this.description;
    }

    public String getNoteCreatedBy(){
        return this.createdBy;
    }

    public double getNoteId(){
        return this.todoId;
    }

    public String displayNoteDetails(){
        return "Note ID: "+this.todoId+"\n"+"Note Description: "+this.description+"\n"+"Note Status: "+this.todoStatus+"\n"+"Created By: "+this.createdBy+"\n"+"Owner ID: "+this.ownerId;
    }

    public void updateDescription(String description){
        this.description = description;
    }

    public void updateTodoStatus(TodoStatus status){
        this.todoStatus=status;
    }

}

