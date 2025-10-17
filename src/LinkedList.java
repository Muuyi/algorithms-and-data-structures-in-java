import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    //PARTITION LIST
    /*
    You have a singly linked list that DOES NOT HAVE A TAIL POINTER  (which will make this method simpler to implement).

Given a value x you need to rearrange the linked list such that all nodes with a value less than x come before all nodes with a value greater than or equal to x.

Additionally, the relative order of nodes in both partitions should remain unchanged.


Constraints:

The solution should traverse the linked list at most once.

The solution should not create a new linked list.


Input:

A singly linked list and an integer x.


Output:

The same linked list but rearranged as per the above criteria.


Function signature:

public void partitionList(int x);


Details:

The function partitionList takes an integer x as a parameter and modifies the current linked list in place according to the specified criteria. If the linked list is empty (i.e., head is null), the function should return immediately without making any changes.



Example 1:

Input:

Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5

Process:

Values less than 5: 3, 2, 1

Values greater than or equal to 5: 8, 5, 10

Output:

Linked List: 3 -> 2 -> 1 -> 8 -> 5 -> 10





Example 2:
Input:

Linked List: 1 -> 4 -> 3 -> 2 -> 5 -> 2 x: 3

Process:

Values less than 3: 1, 2, 2

Values greater than or equal to 3: 4, 3, 5

Output:

Linked List: 1 -> 2 -> 2 -> 4 -> 3 -> 5





Tips:

While traversing the linked list, maintain two separate chains: one for values less than x and one for values greater than or equal to x.

Use dummy nodes to simplify the handling of the heads of these chains.

After processing the entire list, connect the two chains to get the desired arrangement.



Note:

The solution must maintain the relative order of nodes. For instance, in the first example, even though 8 appears before 5 in the original list, the partitioned list must still have 8 before 5 as their relative order remains unchanged.

Note:

You must solve the problem WITHOUT MODIFYING THE VALUES in the list's nodes (i.e., only the nodes' next pointers may be changed.)
    * */
    public LinkedList partitionList(LinkedList linkedList,int x){
        // Step 1: Check for an empty list.
        // If the list is empty, there is nothing
        // to partition, so we exit the method.
        if (linkedList.head == null) return null;

        // Step 2: Create two dummy nodes.
        // These dummy nodes act as placeholders
        // to simplify list manipulation.
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Step 3: Initialize pointers for new lists.
        // 'prev1' and 'prev2' will track the end nodes of
        // the two lists that are being created.
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Step 4: Start with the head of the original list.
        Node current = linkedList.head;

        // Step 5: Iterate through the original list.
        while (current != null) {

            // Step 6: Compare current node value with 'x'.
            // Nodes are partitioned based on their value
            // being less than or greater than/equal to 'x'.

            // Step 6.1: If value is less than 'x',
            // add node to the first list.
            if (current.value < x) {
                prev1.next = current;  // Link node to the end of the first list.
                prev1 = current;       // Update the end pointer of the first list.
            } else {
                // Step 6.2: If value is greater or equal,
                // add node to the second list.
                prev2.next = current;  // Link node to the end of the second list.
                prev2 = current;       // Update the end pointer of the second list.
            }

            // Move to the next node in the original list.
            current = current.next;
        }

        // Step 7: Terminate the second list.
        // This prevents cycles in the list.
        prev2.next = null;

        // Step 8: Connect the two lists.
        // The first list is followed by the second list.
        prev1.next = dummy2.next;

        // Step 9: Update the head of the original list.
        // The head now points to the start of the first list.
        linkedList.head = dummy1.next;
        return linkedList;
//        Node currentNode = linkedList.head;
//        if(currentNode == null) return null;
//        Node lowerChain = new Node(0);
//        Node lowerChainPointer = lowerChain;
//        Node greaterChain = new Node(0);
//        Node greaterChainPointer = greaterChain;
//        while(currentNode != null){
//            if(currentNode.value < x){
//                lowerChainPointer.next = currentNode;
//            }else{
//                greaterChainPointer.next = currentNode;
//            }
//            if(lowerChain.next == null){
//                lowerChain.next = lowerChainPointer;
//            }
//            if(greaterChain.next == null){
//                greaterChain.next = greaterChainPointer;
//            }
//            currentNode = currentNode.next;
//        }
//        lowerChainPointer.next = greaterChain.next;
//        linkedList.head = lowerChain.next;
//        return linkedList;
    }
    //BINARY TO DECIMAL
    /*
    Objective:

You have a linked list where each node represents a binary digit (0 or 1). The goal of the binaryToDecimal function is to convert this binary number, represented by the linked list, into its decimal equivalent.
    * */
    public long binaryToDecimal(LinkedList linkedList){
        int num = 0;
        Node current = head;
        while(current != null){
            num = num*2 + current.value;
            current = current.next;
        }
        return num;
//        long num = 0;
//        Node currentNode = linkedList.head;
//        List<Long> multiples = new ArrayList<>();
//        while (currentNode != null){
//            long lastValue = 0;
//            multiples.replaceAll(n -> n*2);
//            if(currentNode.value == 0){
//                lastValue = 0;
//            }else{
//                lastValue = 1;
//            }
//            multiples.add(lastValue);
//
//            currentNode = currentNode.next;
//        }
//        long sum = multiples.stream().mapToLong(Long::longValue).sum();
//        return sum;
    }
    //REMOVE DUPLICATES WITHOUT USING A HASHSET
        /*
        You are given a singly linked list that contains integer values, where some of these values may be duplicated.



Note: this linked list class does NOT have a tail which will make this method easier to implement.



Your task is to implement a method called removeDuplicates() within the LinkedList class that removes all duplicate values from the list.

Your method should not create a new list, but rather modify the existing list in-place, preserving the relative order of the nodes.

You can implement the removeDuplicates() method in two different ways:



Using a Set (HashSet) - This approach will have a time complexity of O(n), where n is the number of nodes in the linked list. You are allowed to use the provided Set data structure in your implementation.

Without using a Set - This approach will have a time complexity of O(n^2), where n is the number of nodes in the linked list. You are not allowed to use any additional data structures for this implementation.



Here is the method signature you need to implement:

public void removeDuplicates() {
    // Your implementation goes here
         */
    public void removeDuplicatesUsingSet(LinkedList linkedList){
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while(current != null){
            if(values.contains(current.value)){
                previous.next = current.next;
                length -= 1;
            }else{
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }
    public void removeDuplicates(LinkedList linkedList){
        Node current = linkedList.head;
        while(current != null){
            Node runner = current;
            while (runner.next != null){
                if(runner.next.value == current.value){
                    runner.next = runner.next.next;
                    length -= 1;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
//        Node currentNode = linkedList.head;
//        while(currentNode.next != null){
//            Node loopNode = currentNode;
//            while(loopNode.next != null){
//                if(loopNode.next.value == currentNode.value){
//                    if(loopNode.next.next != null){
//                        loopNode.next = loopNode.next.next;
//                        loopNode.next.next = null;
//                        currentNode = currentNode.next;
//                    }else{
//                        currentNode = currentNode.next;
//                    }
//                }else{
//                    if(loopNode.next == null){
//                        currentNode = currentNode.next;
//                    }
//
//                }
//            }
//        }
    }
    //APPEND AN ITEM TO A LINKED LIST
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;

        }
        length++;
    }
    public Node removeLast(){
        if(length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length --;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head= newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }
    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for(int i=0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }
    public boolean set(int index,int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
    public boolean insert(int index,int value){
        if(index < 0 || index > length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index -1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    //REMOVE AN ITEM FROM AN INDEX IN A LINKED LIST
    public Node remove(int index){
        if(index < 0 || index > length) return null;
        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();
        Node prev = get(index -1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    //REVERSE A LINKED LIST
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i=0; i< length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    //PRINT LINKED LIST
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+", ");
            temp = temp.next;
        }
    }
    //FIND MIDDLE NODE
       /*"""
                Implement a method called findMiddleNode that returns the middle node of the linked list.

                If the list has an even number of nodes, the method should return the second middle node.
                Note: this LinkedList implementation does not have a length member variable.
                When the linked list has an odd number of nodes, like 1 -> 2 -> 3 -> 4 -> 5, the function will find the exact middle node. In this case, it will return the node containing the value 3.

                When the linked list has an even number of nodes, there will be two middle nodes. The findMiddleNode function will return the second of these two middle nodes.

                For example, if the linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, the two middle nodes are 3 and 4. The function will return the node containing the value 4.
                Note:

                In this problem, you should use the slow and fast pointer technique (also known as Floyd's Tortoise and Hare algorithm) to find the middle element of the linked list efficiently.

                The key idea is to have two pointers, one that moves twice as fast as the other. By the time the fast pointer reaches the end of the linked list, the slow pointer will be at the middle.

                """*/
    public Node findMiddleNode(LinkedList linkedList){
        if(linkedList.head == null) return null;
//        int position = 1;
        Node slowNode = linkedList.head;
        Node fastNode = linkedList.head;
        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
//        while(fastNode.next != null){
//            fastNode = fastNode.next;
//            position++;
//            if(position % 2 == 0){
//                slowNode = slowNode.next;
//            }
//        }
        return slowNode;
    }
    //CHECK IF THE LINKED LIST HAS A LOOP
       /*
        * Write a method called hasLoop that is part of the linked list class.

The method should be able to detect if there is a cycle or loop present in the linked list.

You are required to use Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.

This algorithm uses two pointers: a slow pointer and a fast pointer. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a loop in the linked list, the two pointers will eventually meet at some point. If there is no loop, the fast pointer will reach the end of the list.

The method should follow these guidelines:



Create two pointers, slow and fast, both initially pointing to the head of the linked list.

Traverse the list with the slow pointer moving one step at a time, while the fast pointer moves two steps at a time.

If there is a loop in the list, the fast pointer will eventually meet the slow pointer. If this occurs, the method should return true.

If the fast pointer reaches the end of the list or encounters a null value, it means there is no loop in the list. In this case, the method should return false.



Output:

Return true if the linked list has a loop.

Return false if the linked list does not have a loop.



Constraints:

You are not allowed to use any additional data structures (such as arrays) or modify the existing data structure.

You can only traverse the linked list once.


Method signature:

public boolean hasLoop()


If your Linked List contains a loop, it indicates a flaw in its implementation. This situation can manifest in several ways:
        *
        *
        * */
    public boolean hasLoop(LinkedList linkedList){
        if(linkedList.head == null) return false;
        Node slowPointer = linkedList.head;
        Node fastPointer = linkedList.head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
    public void getHead(){
        System.out.println("Head: "+head.value);
    }
    public void getTail(){
        System.out.println("Tail: "+tail.value);
    }
    public void getLength(){
        System.out.println("Length: "+length);
    }
    //FIND KTH NODE
       /*
        Implement a method called findKthFromEnd that returns the k-th node from the end of a singly linked list.

The linked list does not store its length, so you must determine the correct node without using a size property.

The value of k is 1-based:

k = 1 returns the last node (tail).

k = 2 returns the second-to-last node.

k = list length returns the head node.

k <= 0 or k > list length returns null.

You must solve this problem using the two-pointer technique, ensuring the solution runs in a single traversal of the list (O(n) time, O(1) space).





Method Signature

public Node findKthFromEnd(int k)




Example

LinkedList myList = new LinkedList(1);
myList.append(2);
myList.append(3);
myList.append(4);
myList.append(5);

// The list is: 1 -> 2 -> 3 -> 4 -> 5

Node result = myList.findKthFromEnd(2);
// Returns the node with value 4 (2nd from the end)

result = myList.findKthFromEnd(5);
// Returns the node with value 1 (head, 5th from the end)

result = myList.findKthFromEnd(6);
// Returns null (list has only 5 nodes)

result = myList.findKthFromEnd(0);
// Returns null (k must be greater than 0)




📘 What This Exercise Is Designed to Teach

How to use the two-pointer (fast and slow) technique to solve linked list problems efficiently.

How to handle edge cases in linked list traversal, such as:

Empty lists

k being 0 or negative

k being larger than the list’s length

How to traverse a linked list in one pass without calculating its length in advance.

Reinforcing understanding of pointer movement and node referencing in singly linked lists.
        * */
    public Node findKthFromEnd(int k){
        if(k < 0) return null;
        Node slow = head;
        Node fast = head;
        for(int i=0; i < k; i++){
            if(fast == null) return null;
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
//        try {
//            if (indexFromEnd <= 0) return null;
//            if (head == null) return null;
//            if (head.next == null && indexFromEnd == 1) return head;
//            Node slowPointer = head;
//            Node fastPointer = head;
//            int fastTracker = 1;
//            while (fastPointer.next != null) {
//                if (fastTracker == 1 && indexFromEnd != 1) {
//                    FAST_POINTER_CHECK:
//                    while (fastTracker <= indexFromEnd) {
//                        fastPointer = fastPointer.next;
//                        fastTracker += 1;
//                    }
//                } else {
//                    fastPointer = fastPointer.next;
//                }
//                if (fastPointer.next != null) {
//                    slowPointer = slowPointer.next;
//                }
//            }
//            return slowPointer;
//        }catch(Exception e){
//            return null;
//        }
//        SLOW_POINTER_CHECK: do{
//            int fastTracker = 1;
//            if(slowPointer == head) {
//                FAST_POINTER_CHECK:
//                while (fastTracker < indexFromEnd) {
//                    fastPointer = fastPointer.next;
//                    fastTracker += 1;
//                }
//            }else{
//                fastPointer = fastPointer.next;
//            }
//            slowPointer = slowPointer.next;
//        }while(fastPointer.next != null);

    }
}
