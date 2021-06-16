import java.sql.Timestamp;
import java.util.Comparator;

public abstract class StorageItem {
    private String name;
    private final long creationDate;

    // Timestamp objects to hold margins for new file creation dates.
    private static final Timestamp EARLIEST_DATE = new Timestamp(2017, 1, 1 ,
            0, 0,0, 0);
    private static final Timestamp LATEST_DATE = new Timestamp(2021, 12, 31,
            23, 59, 59, 0);

    /**
     * Constructor for StorageItem abstract class
     * @param name String object.
     */
    public StorageItem(String name) {
        this.name = name;
        // set the creation date to a random date between EARLIEST_DATE and
        // LATEST_DATE.
        creationDate = EARLIEST_DATE.getTime() +
                (Main.rnd.nextLong() %
                        (LATEST_DATE.getTime() - EARLIEST_DATE.getTime()));
    }

    /**
     * @param name String object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String object
     */
    public String getName() {
        return name;
    }

    public abstract int getSize();

    /**
     * @return long variable
     */
    public long getCreationDate() {
        return creationDate;
    }

    /**
     * print the system tree stating from the current item.
     * @param field enum SortingField object
     */
    public void printTree(SortingField field) {

    }

    /**
     * @return item in a given path.
     */
    public abstract StorageItem findFile(String path);

    static class itemsSortByName implements Comparator<StorageItem> {
        /**
         * used to sort storage items by name in ascending order.
         * @param firstItem StorageItem object
         * @param secondItem StorageItem object
         * @return int
         */
        @Override
        public int compare(StorageItem firstItem, StorageItem secondItem) {
            return firstItem.name.compareTo(secondItem.name);
        }
    }

    static class itemsSortByDate implements Comparator<StorageItem> {
        /**
         * used to sort storage items by name in ascending order.
         * @param firstItem StorageItem object
         * @param secondItem StorageItem object
         * @return int
         */
        @Override
        public int compare(StorageItem firstItem, StorageItem secondItem) {

            if(firstItem.creationDate > secondItem.creationDate) {
                return 1;
            }
            else if(firstItem.creationDate < secondItem.creationDate) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    /**
     * check if the storage item contains an item with name 'name'.
     * @param item StorageItem object
     * @return boolean
     */
    protected abstract boolean contains(StorageItem item);

    /**
     * check if item has the same name as item
     * (can be added to the same folder as item)
     * @param item StorageItem object to compare
     * @return boolean - true if equals, false otherwise
     */
    protected boolean nameEquals(StorageItem item) {
        return this.getName().equals(item.getName());
    }

    /**
     * check if item has the same name as 'name'
     * (can be added to the same folder as item)
     * @param name String object to compare
     * @return boolean - true if equals, false otherwise
     */
    protected boolean nameEquals(String name) {
        return this.getName().equals(name);
    }
}
