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
     *
     * @return returns a String with file name and extension
     */
    @Override
    public String getName(){
        return super.getName() + "." + this.ext;
    }

    /**
     *
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
        System.out.println(this.getName() + "Size: " + this.getSize()
                + "Mb Created: "+this.getDate());
        System.out.println(this.content);
    }

    /**
     * add content to file
     * @param s String object
     */
    public void addContent(String s) {
        this.content += s;
    }

    /**
     * check if the file has name 'name'
     * @param item StorageItem object
     * @return boolean
     */
    @Override
    protected boolean contains(StorageItem item) {
        return this.nameEquals(item);
    }

    /**
     * @param path String object
     * @return itself
     */
    /*
    @Override
    public File findFile(String path) {
        return this;
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
        for(int i = 0; i < indent; i++) {
            System.out.print(INDENT);
        }
        System.out.println(this.getName());
    }
}
