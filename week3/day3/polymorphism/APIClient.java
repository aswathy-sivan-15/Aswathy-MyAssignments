package week3.day3.polymorphism;

public class APIClient {
    public void sendRequest(String endPoint)
    {
        System.out.println("Sending request to endpoint: " + endPoint);
    }
    public void sendRequest(String endpoint, String requestBody, boolean requestStatus)
    {
        System.out.println("Sending request to endpoint: " + endpoint + "\nRequest Body: " + requestBody);

        if(requestStatus)
        {
            System.out.println("Request Status: SUCCESS");
        }
        else
        {
            System.out.println("Request Status: FAILED");
        }
    }
    public static void main(String[] args) {
        APIClient client = new APIClient();

        // Call method with single parameter
        client.sendRequest("/getUsers");
        System.out.println("---------------------------------------");
        //// Call method with 3 parameters
        client.sendRequest("/createUser", "{name: ''John}", true);
    }

}
