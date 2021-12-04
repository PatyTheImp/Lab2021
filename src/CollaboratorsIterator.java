public class CollaboratorsIterator {
    private String[] emails;
    private int size;
    private int nextIndex;

    public CollaboratorsIterator(String[] emails, int size) {
        this.emails = emails;
        this.size = size;
        this.nextIndex = 0;
    }

    public boolean hasNext() {
        return nextIndex < size;
    }

    /** Pre: hasNext() */
    public String next() {
        return emails[nextIndex++];
    }
}
