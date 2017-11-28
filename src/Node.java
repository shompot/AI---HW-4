/**
 * Created by Shiha on 11/28/2017.
 */
public class Node {
    private int index;
    private String data;

    public Node () {
        index= 0;
        data = "";
    }

    public Node (int index, String data){
        this.index = index;
        this.data = data;
    }

    public int getIndex() { return this.index; }
    public String getData(){ return this.data; }
    public void setIndex( int index){ this.index=index;}
    public void setData( String data){ this.data=data;}

    public String toString () {
        return data;
    }
}
