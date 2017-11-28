/**
 * Created by Shiha on 11/28/2017.
 */
public class Node {
    private int index;
    private String classname;
    //Node next;

    public Node () {
        index= 0;
        classname = "";
        //next = null;
    }

    public Node (int index, String classname){//Node next) {
        this.index = index;
        this.classname = classname;
        //this.next = next;
    }

    public int getIndex() { return this.index; }
    public String getClassname(){ return this.classname; }
    public void setIndex( int index){ this.index=index;}
    public void setClassname( String classname){ this.classname=classname;}

    public String toString () {
        return classname;
    }
}
