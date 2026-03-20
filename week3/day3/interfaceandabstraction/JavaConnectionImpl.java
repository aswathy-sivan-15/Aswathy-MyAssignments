package week3.day3.interfaceandabstraction;

public class JavaConnectionImpl extends MySqlConnection {

    @Override
    public void connect() {
       System.out.println("Connected to MySql DB");
    }

    @Override
    public void disconnect() {
         System.out.println("Disconnected from DB");
    }

    @Override
    public void executeUpdate() {
          System.out.println("Update executed successfully");
    }

    @Override
    public void executeQuery() {
         System.out.println("Query executed successfully");
    }
public static void main(String[] args) {
     JavaConnectionImpl jCI = new JavaConnectionImpl();
     jCI.connect();
     jCI.disconnect();
     jCI.executeUpdate();
     jCI.executeQuery();
}

}
