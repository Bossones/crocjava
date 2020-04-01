import java.util.LinkedList;

/*
    Queue information
 */
class QueueInfo {

    private int estimatedQueueTime;

    private QueueDisplay queueDisplay;

    private LinkedList<Client> clients;

    public QueueInfo(QueueDisplay queueDisplay) {}

    public Client findClientWithMaxTimeInQueue(Window window) { return null; }

    private void showWindowNumber() {}

    public void noteNewClient(Client client) {}

    public void remove(Client client) {}

    public boolean haveClients() { return true; }

}
