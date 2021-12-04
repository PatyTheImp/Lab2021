public class ProjectIterator {
    private Project[] projects;
    private int size;
    private int nextIndex;

    public ProjectIterator(Project[] projects, int size) {
        this.projects = projects;
        this.size = size;
        this.nextIndex = 0;
    }

    public boolean hasNext() {
        return nextIndex < size;
    }

    /** Pre: hasNext() */
    public Project next() {
        return projects[nextIndex++];
    }
}
