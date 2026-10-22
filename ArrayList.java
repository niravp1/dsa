/*
dynamically sized array by factor of 2

if size of array is 50% or more of capacity multiply size by 2
If [1, 2]
then:
[1, 2, X, X ]


[3, 2,]

[1]
constructor():
    capacity_factor = 2
    max_capacity = 2
    create array[max_capacity]
    count = 0
    last_index = -1

add element to array
    add(element value )
    keep track of last index element has been added to
    last_index += 1
    array[last_index] = elem 
    count + 1
    if size of array / max_capacity >= 0.5:
        resize()


copy over elements of curr array to a (max_capacity * capacity_factor) sized array
resize():

    max_capacity *= capacity_factor
    new_array = initalize array of [max_capacity]

    for i in curr_array:
        new_array[i] = curr_array[i]

    array = new_array

pop element from array
pop()
    check if array empty
    res = array[last_index]
    count - 1
    index - 1
    return res 

get elem at index i
check if i within bounds of array
then return array[i]

see all elements of array
iterate through every elem in array
print i position, and value

add element to array
    add(element value )
    keep track of last index element has been added to
    last_index += 1
    array[last_index] = elem 
    count + 1
    if size of array / max_capacity >= 0.5:
*/

public class ArrayList {
    public final int capacity_factor = 2;
    public int max_capacity = 2;
    Object[] store = new Object[max_capacity];
    public int last_index = -1;
    public int count = 0;

    public static void main(String[] args) {
        ArrayList test_array = new ArrayList();
        test_array.append(100);
        test_array.append(1);
        test_array.append("apple");
        test_array.pop();
        test_array.get(0);
        test_array.getAll(); 
        
    }
    public void append(Object element){
        last_index += 1;
        store[last_index] = element;
        count += 1;
        // if the size of array is 50% of max, double size
        if ((double) count / max_capacity >= 0.5){
            resize();
        }
    }
    public void resize(){
        max_capacity *= capacity_factor;
        Object[] new_array = new Object[max_capacity];
        
        for (int i = 0; i < store.length; i++){
            new_array[i] = store[i];
        }
        store = new_array;
    }
    public Object pop(){
        if (count <= 0)
            throw new IllegalStateException("Array is empty");
        Object res = store[last_index];
        count -= 1;
        last_index -= 1;
        return res;
    }
    public Object get(int i){
        if (count <= 0 || (i < 0 || i >= store.length))
            throw new IllegalStateException("Array is empty");
       return  store[i];
        
    }
    public void getAll(){
        for (int i = 0; i < store.length; i++) {
           System.out.format("Index: %d Val: %s %n",i, store[i]);
        }
    }


}