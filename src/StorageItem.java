import java.sql.Timestamp;

public abstract class StorageItem {
    private String name;
    private final long creationDate;

    public static final String INDENT = "|    ";

    // Timestamp objects to hold margins for new file creation dates.
    public static final Timestamp EARLIEST_DATE = new Timestamp(117, 0, 1 ,
            0, 0,0, 0);
    public static final Timestamp LATEST_DATE = new Timestamp(121, 11, 31,
            23, 59, 59, 0);

    /**
     * Constructor for StorageItem abstract class
     * @param name String object.
     */
    public StorageItem(String name) {
        this.name = name;
        long rand = Main.rnd.nextLong();
        if(name.equals("aa")) {
            System.out.println(rand);
        }
        //rand = rand >= 0 ? rand : (-1) * rand;
        if(name.equals("aa")) {
            System.out.println(rand);
            System.out.println(EARLIEST_DATE.getTime());
            System.out.println(LATEST_DATE.getTime() - EARLIEST_DATE.getTime());
        }
        // set the creation date to a random date between EARLIEST_DATE and
        // LATEST_DATE.
        this.creationDate = EARLIEST_DATE.getTime() +
                (rand % (LATEST_DATE.getTime() - EARLIEST_DATE.getTime()));
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
     * @return item in a given path.
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
