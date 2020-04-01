/*
    Client information
 */
class Client {

    private int numberInQueue;

    private PurposeOfVisit purposeOfVisit;

    private int timeInQueue;

    private int estimatedQueueTime;

    private Client(int numberInQueue, PurposeOfVisit purposeOfVisit,
                  int timeInQueue, int estimatedQueueTime) {}

    public int getEstimatedQueueTime() { return 0; }

    public int getNumberInQueue() { return 0; }

    public int getTimeInQueue() { return 0; }

    public PurposeOfVisit getPurposeOfVisit() { return null; }

    public static Client newClient(int numberInQueue, PurposeOfVisit purposeOfVisit,
                                   int timeInQueue, int estimatedQueueTime) { return null; }
}
