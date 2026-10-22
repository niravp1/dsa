/*
n = 17
sentence = "the frog was blue"

copy_sentence = "th"

for char in sentence:
    copy_sentence += char

temp = copy_sentence + char
copy_sentence = temp


1 + 0 = 1
1 + 1 = 2
2 + 1 = 3
...
n - 1 + 1 = n

sum of integers from 1 - n = ((n + 1) / 2) * n = O(n^2)
1 - 100
1 2 3 ... 97 98 99 100
100 + 1 , 2 + 99, 3 + 98, 4 + 97  = n + 1 * n / 2
^
| 
50 pairs of this -> n / 2


instead of making temp variable to copy an entire string, store all chars 
of sentence in an array O(n) and do .join (O(n))
O(n) + O(n) = 2O(n) = O(n)

handle copying multiple words 

SB = dynamic array
for word in sentence:
    SB.append(word)

only copy back into a string once at the end 

SB.toString
*/


public class StringBuilder extends ArrayList{
    public void ToString(){
        String res = "";
        for (int i = 0; i < store.length; i++){
            if (store[i] == null)
                return;
            res += " " + store[i];
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        String[] words = {"john", "likes", "apples"};
        StringBuilder sentence = new StringBuilder();
        for (String w: words)
            sentence.append(w);

        sentence.ToString();
    }
}
