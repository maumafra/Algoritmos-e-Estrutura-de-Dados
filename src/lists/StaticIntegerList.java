package lists;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class StaticIntegerList {
    
    private int[] info;
    private int length;

    public StaticIntegerList() {
        info = new int[10];
    }

    public StaticIntegerList(int size) {
        info = new int[size];
    }

    public void add (int value) {
        if(info.length == this.getLength()){
            this.resize();
        }
        info[length] = value;
        this.length++;
    }

    public void resize() {
        int newBound = info.length + ((int)(info.length/2) == 0? 1 : (int)(info.length/2));
        int[] newArray = new int[newBound];
        for(int i = 0; i < info.length; i++){
            newArray[i] = info[i];
        }
        info = newArray;
    }

    public void clear() {
        info = new int[10];
        this.length = 0;
    }

    public int getLength(){
        return this.length;
    }

    public void show(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String text = "{";
        for(int i = 0; i < this.getLength(); i++){
            if(i == this.getLength()-1){
                return text += info[i]+"}";
            }
            text += info[i]+", ";
        }
        return "";
    }

    public int hasValue(int value){
        for(int i = 0; i < info.length; i++){
            if(info[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void remove(int value){
        int index = this.hasValue(value);
        if(index == -1){
            return;
        }
        this.length--;
        for(int i = index; i < info.length; i++){
            if(i == info.length-1){
                info[i] = 0;
                return;
            }
            info[i] = info[i+1];
        }
    }

    public int getValue(int index){
        if(index >= this.getLength()){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return info[index];
    }

    public boolean isEmpty(){
        return this.getLength() == 0;
    }
}
