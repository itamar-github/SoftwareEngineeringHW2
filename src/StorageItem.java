import java.sql.Timestamp;

public abstract class StorageItem {
    private String name;
    private final long creationDate;

    public static final String INDENT = "|    ";

    // Timestamp objects to hold margins for file creation dates.
    public static final Timestamp EARLIEST_DATE =
            Timestamp.valueOf("2017-01-01 00:00:00");
    public static final Timestamp LATEST_DATE =
            Timestamp.valueOf("2021-12-31 23:59:59");

    /**
     * Constructor for StorageItem abstract class
     * @param name String object which will be the name of the new item
     */
    public StorageItem(String name) {
        this.name = name;
        long rand = Main.rnd.nextLong();
        rand = rand >= 0 ? rand : (-1) * rand;

        this.creationDate = EARLIEST_DATE.getTime() +
                (rand % (LATEST_DATE.getTime() - EARLIEST_DATE.getTime()));
    }

    /**
     * @return String object which is the name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * @return int which is the size of the item.
     */
    public abstract int getSize();

    /**
     * @return long variable which is the creation date of the item.
     */
    public long getDate() {
        return creationDate;
    }

    /**
     * print the system tree stating from the current item.
     * @param field enum SortingField object
     */
    public abstract void printTree(SortingField field);

    /**
     * inner function for printTree to control indent
     * @param field enum SortingField to sort by
     * @param indent int to capture the number of indents to print (depth of
     *               item in the system from wrapper function call.
     */
    protected abstract void printTree(SortingField field, int indent);

    /**
     * @return item in a given path if found, null if not.
     */
    public abstract StorageItem findFile(String path);

    /**
     * check if the storage item contains an item with name 'name'.
     * @param item StorageItem object
     * @return boolean
     */
    protected abstract boolean contains(StorageItem item);

    /**
     * check if item has the same name as 'name'
     * (can be added to the same folder as item)
     * @param name String object to compare
     * @return boolean - true if equals, false otherwise
     */
    protected boolean nameEquals(String name) {
        return this.getName().equals(name);
    }

    /**
     * check if item has the same name as item
     * (can be added to the same folder as item)
     * @param item StorageItem object to compare
     * @return boolean - true if equals, false otherwise
     */
    protected boolean nameEquals(StorageItem item) {
        return this.nameEquals(item.getName());
    }
}
