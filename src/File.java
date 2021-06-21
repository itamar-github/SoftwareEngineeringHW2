import java.sql.Timestamp;

public class File extends StorageItem {
    private String ext;
    private String content;

    /**
     * constructor for the File class
     * @param name the name of the file
     * @param ext the file extension
     */
    public File(String name, String ext){
        super(name);
        this.ext = ext;
        this.content = "";
    }

    /**
     * @return returns a String with file name and extension
     */
    @Override
    public String getName(){
        return super.getName() + "." + this.ext;
    }

    /**
     * @return returns the size of the file
     */
    @Override
    public int getSize(){
        return content.length();
    }

    /**
     * prints a description of the file and its content
     */
    public void printContent(){
        Timestamp date = new Timestamp(this.getDate());
        System.out.println(this.getName() + " Size: " + this.getSize()
                + "MB Created: " + date);
        System.out.println(this.content);
    }

    /**
     * add content to file
     * @param s String object to add to the file
     */
    public void addContent(String s) {
        this.content += s;
    }

    /**
     * check if the file has name 'name'
     * @param item StorageItem object
     * @return boolean which the truth value of the comparison.
     */
    @Override
    protected boolean contains(StorageItem item) {
        return this.nameEquals(item);
    }

    /**
     * @param path String object
     * @return if the file's name matches the path given, return this File.
     *         otherwise return null.
     */
    @Override
    public File findFile(String path) {
        if(this.nameEquals(path)) {
            return this;
        }

        return null;
    }

    /**
     * print the system tree stating from the current item.
     * @param field enum SortingField object to specify sort key.
     */
    @Override
    public void printTree(SortingField field) {
        this.printTree(field, 0);
    }

    /**
     * inner function for printTree to control indent
     * @param field enum SortingField to sort by
     * @param indent int which is the number of indents to print (depth of
     *               item in the system from wrapper function call).
     */
    @Override
    protected void printTree(SortingField field, int indent) {
        for(int i = 0; i < indent; i++) {
            System.out.print(INDENT);
        }
        System.out.println(this.getName());
    }
}
