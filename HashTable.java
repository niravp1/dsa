/*
develop the hash table data structure algorithim using linked list collision solution

key    val
name : age

John : 15
Mike: 28
Sarah: 21

insert (key, val)
get(key)
getAll()

    print all pairs of hash table

array = [F A       ]
index    0 1 2 3 

F = John: 15 -> Sarah: 21
A = Mike: 28
----
constructor:

array of size of 5
have it be of the node type


insert(key, val):
    check if key valid  i.e (can't be a array  etc)
    index = hash(key) % len(arr)
    if pair already exists at array[index] ,
    traverse linked list to end and apend at the end of linked list 

    *the node that is appened should be identifiable by the key (important for get method)

    hash(key):
        return key * 3.14 

get(key):
    check if key exists 

    get index
    if pair exists at index traverse linked list until you find node with key's value

    if no node found return -1

Node: 
   String node.key 
   Long node.val

be able to store anything as a key val

getAll():
    printing the key and the value should visualize linked list structure as well 

    for loop through array length
        check if array[i] has more than one node:
        print entire linked list O(N)
        otherwise print node

LATER
if we insert a key that already exists update val of that key

*/

public class HashTable {
    public int size = 5;
    Node[] array = new Node[5];

    public static void main(String[] args) {
    }

    public void insert(String key, int value) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Insert failed, key is not a string");
        }
        int index = get_index(key);
        Node pair = array[index];
        while (pair.next != null) {
            pair = pair.next;
        }
        pair.next = new Node(key, value);

    }

    public int get_index(String key) {
        return key.hashCode() % size;
    }

    public int get(String key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Get failed, key is not a string");
        }

        Node pair = array[get_index(key)];
        if (pair == null)
            return -1;

        while (!(pair.key.equals(key))) {
            pair = pair.next;
            if (pair == null) {
                return -1;
            }
        }
        if (pair.key.equals(key))
            return pair.val;
        return -1;
    };

    public void getAll() {
        for (int i = 0; i < size; i++) {
            Node pair = array[i];
            if (pair == null) {
                return;
            }
            while (pair.next != null) {
                System.out
                        .println(String.format("Entry :%d Key: %s Val: %n Next: %s", i, pair.key, pair.val, pair.next));
                pair = pair.next;
            }

            System.out.println(String.format("Entry :%d Key: %s Val: %n ", i, pair.key, pair.val));

            // two types of print
            // Entry i: Key: Joe Val: 3 <- only one node present
            // Entry i: Key: Joe Val: 3 Next: obj name

        }
    }
}