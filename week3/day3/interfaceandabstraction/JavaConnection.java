package week3.day3.interfaceandabstraction;

public class JavaConnection implements DatabaseConnection {

    @Override
    public void connect() {
        System.out.println("Successful java connection");
    }

    @Override
    public void disconnect() {
       System.out.println("Connection got disconnected");
    }

    @Override
    public void executeUpdate() {
      System.out.println("Update got executed");
    }
    public void printValue()
    {
        //Checking interface variables are static final
        //value += 5;
        System.out.println("printing value: " + value);
    }
   public static void main(String[] args)
    {
    DatabaseConnection dbC = new JavaConnection();
    JavaConnection jc = new JavaConnection();
    dbC.connect();
    dbC.disconnect();
    dbC.executeUpdate();
    jc.printValue();
   }
}
