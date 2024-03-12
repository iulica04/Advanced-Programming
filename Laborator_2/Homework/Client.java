package Compulsory;

import java.util.Objects;

/**
 * The Client class represents a client entity with attributes such as client name, time interval, and client type.
 */
public class Client {
    /**
     * The name of the client.
     */
    private String clientName;

    /**
     * The time interval during which the client operates.
     */
    private TimeInterval timeInterval;

    /**
     * The type of the client.
     */
    private ClientType clientType;

    /**
     * Constructs a new Client object with default values.
     */
    Client() {

    }

    /**
     * Constructs a new Client object with specified parameters.
     *
     * @param clientName   The name of the client.
     * @param timeInterval The time interval during which the client operates.
     * @param clientType   The type of the client.
     */
    Client(String clientName, TimeInterval timeInterval, ClientType clientType) {
        this.clientName = clientName;
        this.timeInterval = timeInterval;
        this.clientType = clientType;
    }

    /**
     * Gets the name of the client.
     *
     * @return The name of the client.
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Gets the time interval during which the client operates.
     *
     * @return The time interval.
     */
    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    /**
     * Gets the type of the client.
     *
     * @return The client type.
     */
    public ClientType getClientType() {
        return clientType;
    }

    /**
     * Sets the name of the client.
     *
     * @param clientName The name of the client.
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Sets the time interval during which the client operates.
     *
     * @param timeInterval The time interval.
     */
    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    /**
     * Sets the type of the client.
     *
     * @param clientType The client type.
     */
    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    /**
     * Returns a string representation of the Client object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", timeInterval=" + timeInterval +
                ", clientType=" + clientType +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * This method overrides the default equals implementation to compare
     * the current client object with the specified object based on their
     * clientName, timeInterval, and clientType attributes.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this client is the same as the object
     *         argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientName, client.clientName) && Objects.equals(timeInterval, client.timeInterval) && clientType == client.clientType;
    }

}
