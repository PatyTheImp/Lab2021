public class Project {
    private int id;
    private String description;
    private String bidderEmail;
    private int maxCollaborators;
    private String[] collabsEmails;
    private int collabsSize;

    public Project(int id, String description, String bidder, int neededCollabs) {
        this.id = id;
        this.description = description;
        this.bidderEmail = bidder;
        this.maxCollaborators = neededCollabs;
        this.collabsEmails = new String[neededCollabs];
        this.collabsSize = 0;
    }

    public int getId() { return id; }
    public String getBidderEmail() { return bidderEmail; }

    public CollaboratorsIterator iterator() {
        sort();
        return new CollaboratorsIterator(collabsEmails, collabsSize);
    }

    /** Pre: collabsSize < numberOfNeededCollabs */
    public void addCollaborator(String email) {
        collabsEmails[collabsSize++] = email;
    }

    private void sort() {
        for (int i = 1; i < collabsSize; i++) {
            for (int j = collabsSize - 1; j >= i; j--) {
                if (collabsEmails[j].compareTo(collabsEmails[j - 1]) < 0) {
                    String aux = collabsEmails[j];
                    collabsEmails[j] = collabsEmails[j - 1];
                    collabsEmails[j - 1] = aux;
                }
            }
        }
    }
}
