package BinaryTrees;
import java.util.*;
public class test{
public static void main(String[] args) {
    //input
    ArrayList<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(5);
    list.add(6);

    // answer
    long ans = 0;
    int[] ngr = nextGreaterOnRight(list);
    int[] ngl = nextGreaterOnLeft(list);
    for(int i = 0; i < list.size(); i++){
        ans += ngr[i] - ngl[i] - 1;
    }
    System.out.println(ans);
}


public static int[] nextGreaterOnRight(ArrayList<Integer> arr) {
    Stack<Integer> s = new Stack<>();
    int[] ans = new int[arr.size()];

    s.push(0);
    for (int i = 1; i < arr.size(); i++) {

        while (s.size() > 0 && arr.get(i) > arr.get(s.peek())) {
            int pos = s.peek();
            ans[pos] = i;
            s.pop();
        }

        s.push(i);
    }
    while (s.size() > 0) {
        int pos = s.peek();
        ans[pos] = arr.size();
        s.pop();
    }
    return ans;
}


public static int[] nextGreaterOnLeft(ArrayList<Integer> arr) {
    Stack<Integer> s = new Stack<>();
    int[] ans = new int[arr.size()];

    s.push(arr.size()-1);
    for (int i = arr.size()-2; i >= 0; i--) {

        while (s.size() > 0 && arr.get(i) > arr.get(s.peek())) {
            int pos = s.peek();
            ans[pos] = i;
            s.pop();
        }

        s.push(i);
    }
    while (s.size() > 0) {
        int pos = s.peek();
        ans[pos] = -1;
        s.pop();
    }
    return ans;
}
}