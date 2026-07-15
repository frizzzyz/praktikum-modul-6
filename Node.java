package modul6;

public class Node {
    Object data;
    Node next;

public Node(Object data) {
        this.data = data;
        this.next = null;
    }
    public static void main(String[] args) {

        Node node = new Node(null);
        node.data = "A";

        System.out.println("node    : " + node);
        System.out.println("data    : " + node.data);
        System.out.println("pointer : " + node.next);
        SingleLinkedList list = new SingleLinkedList();
        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);
        list.addFirst(new Node("A"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);
        list.addFirst(new Node("B"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);
        list.addLast(new Node("C"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);
    }
    
//maulana ilham al amin
//255150407111099        
}

