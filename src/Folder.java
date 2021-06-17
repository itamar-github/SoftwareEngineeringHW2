import java.util.ArrayList;
import java.util.Comparator;

public class Folder extends StorageItem {
    private int size;
    private final ArrayList<StorageItem> items;

    public Folder(String name) {
        super(name);
        this.items = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * check if the folder has an item with same name and ext.
     * if there is, return false. otherwise add item to the folder and
     * return true.
     * @param item StorageItem object
     * @return boolean
     */
    public boolean addItem(StorageItem item) {
        if(this.contains(item)) {
            return false;
        }
        this.items.add(item);
        this.size += item.getSize();
        return true;
    }

    /**
     * return the file with the given path.
     * if not found return null.
     * @param path String object
     * @return File object
     */
    /*
    @Override
    public File findFile(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }
        //String[] pathParts = splitHeadPath(path);
        String[] pathParts = path.split("/", 2);
        if (pathParts.length == 1) {
            return (File) this.findInFolder(pathParts[0]);
        }



        File toReturn = this.findFile(pathParts[0]);
        return toReturn.findFile(pathParts[1]);
    }
*/
    /**
     * internal method for recursive implementation of findFile
     * @param path String object
     * @return StorageItem object
     */
    /*
    private StorageItem internalFindFile(String path) throws NoSuchMethodError {
        if (path == null || path.isEmpty()) {
            return null;
        }

        String[] pathParts = path.split("/", 2);
        StorageItem nextStep;
        try {
            nextStep = this.findInFolder(pathParts[0]);
        }
        catch (NoSuchMethodError error) {
            if(pathParts.length == 1) {
                return this;
            }
        }

    }
*/
    /**
     * print the system tree stating from the current item.
     * @param field enum SortingField object
     */
    @Override
    public void printTree(SortingField field) {
        this.printTree(field, 0);
    }

    /**
     * inner function for printTree to control indent
     * @param field enum SortingField to sort by
     * @param indent int to capture the number of indents to print (depth of
     *               item in the system from wrapper function call.
     */
    @Override
    protected void printTree(SortingField field, int indent) {
        this.sortItems(field);
        for(int i = 0; i < indent; i++) {
            System.out.print(INDENT);
        }
        System.out.println(this.getName());

        for(StorageItem item : this.items) {
            item.printTree(field, indent + 1);
        }
    }

    /**
     * check if the folder contains an item with name 'name'
     * @param item String object
     * @return boolean
     */
    @Override
    protected boolean contains(StorageItem item) {
        for(StorageItem currItem : this.items) {
            if(currItem.contains(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * find an item in the current folder by name.
     * @param name String object
     * @return StorageItem if found, null if failed.
     */
    private StorageItem findInFolder(String name) {
        for(StorageItem item : this.items) {
            if(item.nameEquals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * sort the items list by the given field
     * @param field SortingField to sort by
     */
    private void sortItems(SortingField field) {
        switch (field) {
            // primary sort by creation date, secondary sort by name
            case DATE:
                this.items.sort(Comparator.comparing(StorageItem::getDate)
                        .thenComparing(StorageItem::getName));
                break;
            // sort by name
            case NAME:
                this.items.sort(Comparator.comparing(StorageItem::getName));
                break;
            // primary sort by size, secondary sort by name
            case SIZE:
                this.items.sort(Comparator.comparing(StorageItem::getSize)
                        .thenComparing(StorageItem::getName));
                break;
        }
    }
}
