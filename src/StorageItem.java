import java.util.Date;
import java.sql.Timestamp;

public abstract class StorageItem {
    private String name;
    private final Timestamp creationDate;
    private int size;

    public StorageItem(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
}
