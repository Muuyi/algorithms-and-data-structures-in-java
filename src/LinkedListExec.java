public class LinkedListExec {
    public LinkedListExec(){
        /////////LINKED LIST/////////////////
        LinkedList myLinkedList = new LinkedList(1);
        //APPEND
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(2);
//        myLinkedList.append(6);
//        myLinkedList.append(7);
        ///////////////PARTITION LIST
        LinkedList partitionList = new LinkedList(3);
        partitionList.append(8);
        partitionList.append(5);
        partitionList.append(10);
        partitionList.append(2);
        partitionList.append(1);
        System.out.println("=========PARTITION LIST=========");
        partitionList.partitionList(partitionList,5).printList();
        System.out.println("=========PARTITION LIST=========");
        ///////////////BINARY TO DECIMAL LIST
        LinkedList binaryList = new LinkedList(1);
        binaryList.append(1);
        binaryList.append(1);
        binaryList.append(1);
        System.out.println("==BINARY TO DECIMAL==");
        System.out.println(binaryList.binaryToDecimal(binaryList));
        System.out.println("==BINARY TO DECIMAL==");

        //REMOVE DUPLICATES
        System.out.println("==REMOVE DUPLICATES==");
        myLinkedList.printList();
//           myLinkedList.removeDuplicatesUsingSet(myLinkedList);
        myLinkedList.removeDuplicates(myLinkedList);
        System.out.println("== DUPLICATES REMOVED==");
           myLinkedList.printList();
//        System.out.println(myLinkedList.findKthFromEnd(2).value);
        System.out.println("==REMOVE DUPLICATES==");
        //FIND THE Kth NODE FROM THE END

        System.out.println("==FIND KTH NODE==");
//        System.out.println(myLinkedList.findKthFromEnd(0).value);
//        System.out.println(myLinkedList.findKthFromEnd(2).value);
        System.out.println("==FIND KTH NODE==");

        // CHECK IF LINKED LIST HAS A LOOP
        System.out.println("==HAS LOOP==");
        System.out.println(myLinkedList.hasLoop(myLinkedList));
        System.out.println("==HAS LOOP==");
        //FIND MIDDLE NODE
        System.out.println("==MIDDLE NODE==");
        myLinkedList.getTail();
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
