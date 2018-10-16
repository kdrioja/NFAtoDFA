public class ArrayList <E> implements BareBonesArrayList<E> {
    private int size; //Number of elements in array
    private int capacity; //Capacity of array
    private E[] myArray; //Stores data
    private static final int INITIAL_CAPACITY = 10;

    public ArrayList(){
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.myArray = (E[]) new Object[this.capacity]; //Creates the array with initial size by downcasting from Object
    }

    public ArrayList(int capacity){ //Creates ArrayList of different capacity
        if (capacity < 1) {
            this.capacity = INITIAL_CAPACITY;
        }
        else {
            this.capacity = capacity;
        }
        this.size = 0;
        this.myArray = (E[]) new Object[this.capacity];
    }

    @Override
    public void add(E a) {
        //Adds element at the end of list
        if (this.size < this.capacity){
            this.myArray[size] = a;
            this.size++;
        }
        else {
            System.out.println("Not enough space to insert.\nCalling reallocate...");
            this.reallocate();
            this.add(a);
        }
    }

    private void reallocate(){
        //This method doubles the size of the array
        this.capacity *= 2; //Double size
        E[] temp = (E[]) new Object[this.capacity]; //Create new array

        for (int i = 0; i < myArray.length; i++){
            temp[i] = myArray[i];
        }

        this.myArray = temp;
    }

    @Override
    public void add(E a, int index) {
        //This method inserts data into a specific index

        if (index < 0 || index > size){
            System.out.println("Invalid index");
            return;
        }
        else if (index == this.size){
            this.add(a);
        }
        else {
            if (this.capacity == this.size) {
                this.reallocate();
                for (int i = size; i > index; i--){
                    this.myArray[i] = this.myArray[i - 1];
                }
            }

            this.myArray[index] = a;
            this.size++;
        }
    }

    @Override
    public E remove(int index) {
        //This method removes the data out of the specified index
        if (index < 0 || index >= size){
            System.out.println("Invalid index");
            return null;
        }

        E removed = this.myArray[index];

        for (int i = index; i < this.size - 1; i++) {
            this.myArray[i] = this.myArray[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size){
            System.out.println("Invalid index");
            return null;
        }

        return this.myArray[index];
    }

    @Override
    public void set(E a, int index) {
        if (index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }

        this.myArray[index] = a;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int indexOf(E a) {
        for (int i = 0; i < this.size; i++) {
            if (this.myArray[i].equals(a)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.myArray.length; i++){
            if (myArray[i] != null) {
                s += myArray[i] + " ";
            }
        }
        return s;
    }
}