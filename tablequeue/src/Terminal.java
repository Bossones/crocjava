/*
    Terminal
 */
public class Terminal {

    private int queueNumber;

    private PurposeOfVisit[] purposeOfVisits;

    private QueueInfo queueInfo;

    private class Talon {

        private int numberInQueue;

        public Talon(int numberInQueue) {}

    }

    public Terminal(QueueInfo queueInfo, PurposeOfVisit[] purposeOfVisits) {}

    public Talon issueTalon(PurposeOfVisit purposeOfVisit) { return null; }

    public void choosePurpose() {}

    /*
        Send to QueueInfo
     */
    private void sendClientInfo(Client client) {}
}
