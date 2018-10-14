public interface BareBonesArrayList <E>{
    void add(E a); //Used to add to the end of the list
    void add(E a, int index); //Overloaded method to add at specified index
    E remove(int index); //Removes the data at specified index
    E get(int index); //Return the data at index
    void set(E a, int index); //Updates the value of the specified index
    int getSize(); //Returns number of elements
    int indexOf(E a); //Returns the index of the given data
}