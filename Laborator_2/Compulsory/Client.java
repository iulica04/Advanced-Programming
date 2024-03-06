package Compulsory;

public class Client {
    private String clientName;
    private TimeInterval timeInterval;
    private ClientType clientType;

    Client(){

    }
    Client(String clientName, TimeInterval timeInterval, ClientType clientType) {

        this.clientName = clientName;
        this.timeInterval = timeInterval;
        this.clientType = clientType;
    }

    public String getClientName() {
        return clientName;
    }
    public TimeInterval getTimeInterval() {

        return timeInterval;
    }
    public ClientType getClientType() {

        return clientType;
    }
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
    public void setTimeInterval(TimeInterval timeInterval) {

        this.timeInterval = timeInterval;
    }
    public void setClientType(ClientType clientType) {

        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", timeInterval=" + timeInterval +
                ", clientType=" + clientType +
                '}';
    }
}

