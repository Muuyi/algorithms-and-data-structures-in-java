public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        /////////LINKED LIST/////////////////
        LinkedList myLinkedList = new LinkedList(4);
        //APPEND
        myLinkedList.append(2);
        //REMOVE LAST
        myLinkedList.removeLast();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        myLinkedList.printList();
    }
}