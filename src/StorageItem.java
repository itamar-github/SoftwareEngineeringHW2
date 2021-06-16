public abstract class StorageItem {
    private String name;
    private final int creationDate;
    protected int size;

    public StorageItem(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
