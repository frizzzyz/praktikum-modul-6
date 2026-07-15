package modul6.doub;
public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void addLast(Node data) {
        if (size == 0) {
            head = tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("(size: " + size + ")");
    }

    // a. Mencari node dengan nilai tertentu
    Node findByValue(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) return current;
            current = current.next;
        }
        return null;
    }

    // b. Mencari node di posisi ke-n
    Node findByIndex(int n) {
        if (n < 0 || n >= size) return null;
        Node current = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        return current;
    }

    // Fungsi internal tambahan untuk mempermudah penghapusan node
    private void removeNode(Node target) {
        if (target == head && target == tail) {
            head = tail = null;
        } else if (target == head) {
            head = head.next;
            head.prev = null;
        } else if (target == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    // c. Menghapus node di posisi (index) ke-n
    void removeAtIndex(int n) {
        Node target = findByIndex(n);
        if (target != null) {
            removeNode(target);
        }
    }

    // d. Menghapus node dengan nilai data tertentu
    void removeByValue(Object value) {
        Node target = findByValue(value);
        if (target != null) {
            removeNode(target);
        }
    }

    // e. Menambah node di posisi (index) ke-n
    void addAtIndex(int n, Node newNode) {
        if (n < 0 || n > size) return;
        if (n == size) {
            addLast(newNode);
            return;
        }
        Node target = findByIndex(n);
        if (target == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        } else {
            newNode.prev = target.prev;
            newNode.next = target;
            target.prev.next = newNode;
            target.prev = newNode;
            size++;
        }
    }

    // f. Menambah node setelah node dengan nilai data tertentu
    void addAfter(Object value, Node newNode) {
        Node target = findByValue(value);
        if (target == null) return;
        if (target == tail) {
            addLast(newNode);
            return;
        }
        newNode.prev = target;
        newNode.next = target.next;
        target.next.prev = newNode;
        target.next = newNode;
        size++;
    }

    // g. Menambah node sebelum node yang memiliki nilai data tertentu
    void addBefore(Object value, Node newNode) {
        Node target = findByValue(value);
        if (target == null) return;
        if (target == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }
        newNode.prev = target.prev;
        newNode.next = target;
        target.prev.next = newNode;
        target.prev = newNode;
        size++;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addLast(new Node("B"));
        list.addLast(new Node("A"));
        list.addLast(new Node("C"));

        System.out.println("Kondisi Awal:");
        list.print();
        System.out.println();

        System.out.println("findByValue(\"A\")");
        Node nA = list.findByValue("A");
        System.out.println("Hasil: " + (nA != null ? nA.data : "null"));

        System.out.println("\nfindByIndex(2)");
        Node nIdx = list.findByIndex(2);
        System.out.println("Hasil: " + (nIdx != null ? nIdx.data : "null"));

        System.out.println("\nremoveAtIndex(1) // Menghapus index 1 (A)");
        list.removeAtIndex(1);
        list.print();

        System.out.println("\nremoveByValue(\"B\") // Menghapus nilai B");
        list.removeByValue("B");
        list.print();

        System.out.println("\naddAtIndex(0, new Node(\"D\")) // Menambah D di index 0");
        list.addAtIndex(0, new Node("D"));
        list.print();

        System.out.println("\naddAfter(\"D\", new Node(\"E\")) // Menambah E setelah D");
        list.addAfter("D", new Node("E"));
        list.print();

        System.out.println("\naddBefore(\"C\", new Node(\"F\")) // Menambah F sebelum C");
        list.addBefore("C", new Node("F"));
        list.print();
    }
}