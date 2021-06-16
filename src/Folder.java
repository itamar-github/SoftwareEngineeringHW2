import java.util.ArrayList;
import java.lang.StringBuilder;

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

    /**
     * internal method for recursive implementation of findFile
     * @param path String object
     * @return StorageItem object
     */
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
                this.findFile(pathParts[0]);
            }
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
     * sort the items in the folder by the given sorting field
     * @param field SortingField enum type
     */
    private void sortItems(SortingField field) {

    }
}
