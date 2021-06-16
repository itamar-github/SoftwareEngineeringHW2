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
        return super.getName() + "." +this.ext;
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
                + "Mb Created: "+this.getCreationDate());
        System.out.println(this.content);
    }
}
