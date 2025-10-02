public class LinkedListExec {
    public LinkedListExec(){
        /////////LINKED LIST/////////////////
        LinkedList myLinkedList = new LinkedList(1);
        //APPEND
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
//        myLinkedList.append(6);
//        myLinkedList.append(7);
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
        System.out.println("==MIDDLE NODE==");
        System.out.println(myLinkedList.findMiddleNode(myLinkedList).value);
        System.out.println("==MIDDLE NODE==");
        //REMOVE LAST
        myLinkedList.removeLast();
        //Prepend
        myLinkedList.prepend(5);
        //REMOVE FIRST
        myLinkedList.removeFirst();
        //GET INDEX
        myLinkedList.get(1);
        //SET INDEX
        myLinkedList.set(0,5);
        //INSERT LINKED LISK
        myLinkedList.insert(1,100);
        //REMOVE LINKED LIST
        myLinkedList.remove(1);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        myLinkedList.printList();
    }
}
