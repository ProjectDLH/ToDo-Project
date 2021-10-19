public class User {
    public String name;
    public int age;
    public int userId;

    private static int min = 1;
    private  static int max = 100000;


    User(){
        this.name = "";
        this.userId = 1;
        this.age = 18;
    }

    User(String name, int age){
        this.name = name;
        this.age = age;
        this.userId = (int) (Math.random()*(max-min+1)+min);
    }


    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "User ID: "+this.userId+"   ---   User Name: "+this.name;
    }

}
