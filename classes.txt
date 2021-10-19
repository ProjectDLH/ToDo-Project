public class MyClass {
    public static void main(String args[]) {
      Todos firstTodo = new Todos("this is first todo","Lana");
      System.out.println(firstTodo.displayNoteDetails());
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      Todos secondTodo = new Todos("this is second todo","Huda");
      System.out.println("Before update:");
      System.out.println(secondTodo.displayNoteDetails());
      System.out.println("~~~~~~~~~~~");
      secondTodo.updateDescription("Todo Updated");
      System.out.println("After update:");
      System.out.println(secondTodo.displayNoteDetails());
      
      
    }
}


class Todos implements Todo{
    public String description;
    public String createdBy;
    public double noteId;
    private static int min = 1;  
    private  static int max = 100000;
    
    Todos(){
        description="";
        createdBy="";
        noteId=0.0;
    }
    
    Todos(String description,String createdBy){
        this.description = description;
        this.createdBy = createdBy;
        this.noteId =Math.round(Math.random()*(max-min+1)+min);
    }
    
    public String getNoteDescription(){
        return this.description;
    }
    public String getNoteCreatedBy(){
        return this.createdBy;
    }
    public double getNoteId(){
        return this.noteId;
    }
    public String displayNoteDetails(){
        return "Note ID: "+this.noteId+"\n"+"Note Description: "+this.description+"\n"+"Created By: "+this.createdBy;
    }
    public void updateDescription(String description){
        this.description = description;
    }
}

interface Todo {
    public String getNoteDescription();
    public String getNoteCreatedBy();
    public double getNoteId();
    public String displayNoteDetails();
    public void updateDescription(String description);
}
