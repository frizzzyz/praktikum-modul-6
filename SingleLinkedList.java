package modul6;

public class SingleLinkedList {
    Node head, tail;
    int size = 0;

    // Method pendukung untuk menambahkan di akhir list
    void addLast(Node newNode) {
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void printList() {
        Node current = head;
        System.out.print("List saat ini: ");
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println(" (size: " + size + ")");
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
        for (int i = 0; i < n; i++) current = current.next;
        return current;
    }

    // c. Menghapus node di posisi ke-n
    void removeAtIndex(int n) {
        if (n < 0 || n >= size) return;
        if (n == 0) {
            head = head.next;
            if (size == 1) tail = null;
            size--;
            return;
        }
        Node prev = findByIndex(n - 1);
        Node toRemove = prev.next;
        prev.next = toRemove.next;
        
        if (toRemove == tail) tail = prev;
        size--;
    }

    // d. Menghapus node dengan nilai data tertentu
    void removeByValue(Object value) {
        if (head == null) return;
        
        // Jika node yang dihapus adalah head
        if (head.data.equals(value)) {
            head = head.next;
            if (size == 1) tail = null;
            size--;
            return;
        }
        
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(value)) {
                prev.next = current.next;
                if (current == tail) tail = prev; // Update tail jika perlu
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // e. Menambah node di posisi (index) ke-n
    void addAtIndex(int n, Node newNode) {
        if (n < 0 || n > size) return; 
        
        // Jika menambah di awal (head)
        if (n == 0) {
            newNode.next = head;
            head = newNode;
            if (size == 0) tail = newNode;
            size++;
            return;
        }
        
        // Jika menambah di akhir (tail)
        if (n == size) {
            addLast(newNode);
            return;
        }
        
        Node prev = findByIndex(n - 1);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    // f. Menambah node setelah node dengan nilai data tertentu
    void addAfter(Object value, Node newNode) {
        Node target = findByValue(value);
        if (target != null) {
            newNode.next = target.next;
            target.next = newNode;
            if (target == tail) tail = newNode; // Update tail jika ditambah di akhir
            size++;
        }
    }

    // g. Menambah node sebelum node dengan nilai data tertentu
    void addBefore(Object value, Node newNode) {
        if (head == null) return;
        
        // Jika node tujuan adalah head
        if (head.data.equals(value)) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(value)) {
                newNode.next = current;
                prev.next = newNode;
                size++;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        System.out.println("Inisialisasi ");
        list.addLast(new Node("B"));
        list.addLast(new Node("A"));
        list.addLast(new Node("C"));
        list.printList();
        System.out.println();

        System.out.println(" findByValue ");
        Node n1 = list.findByValue("A");
        System.out.println("findByValue(\"A\") -> " + (n1 != null ? n1.data + " (ditemukan)" : "null"));
        Node n2 = list.findByValue("Z");
        System.out.println("findByValue(\"Z\") -> " + (n2 != null ? n2.data : "null (tidak ditemukan)"));
        System.out.println();

        System.out.println(" findByIndex ");
        Node i1 = list.findByIndex(1);
        System.out.println("findByIndex(1) -> data: " + (i1 != null ? i1.data : "null"));
        Node i5 = list.findByIndex(5);
        System.out.println("findByIndex(5) -> " + (i5 != null ? i5.data : "null (di luar range)"));
        System.out.println();

        System.out.println(" removeAtIndex ");
        System.out.println("Eksekusi: removeAtIndex(1) | Menghapus index 1 ('A')");
        list.removeAtIndex(1);
        list.printList();
        System.out.println();

        System.out.println(" removeByValue ");
        System.out.println("Eksekusi: removeByValue(\"B\") | Menghapus node 'B'");
        list.removeByValue("B");
        list.printList();
        System.out.println();

        System.out.println(" addAtIndex ");
        System.out.println("Eksekusi: addAtIndex(0, new Node(\"D\")) | Menambah 'D' di index 0");
        list.addAtIndex(0, new Node("D"));
        list.printList();
        System.out.println();

        System.out.println(" addAfter ");
        System.out.println("Eksekusi: addAfter(\"D\", new Node(\"E\")) | Menambah 'E' setelah 'D'");
        list.addAfter("D", new Node("E"));
        list.printList();
        System.out.println();

        System.out.println(" addBefore ");
        System.out.println("Eksekusi: addBefore(\"C\", new Node(\"F\")) | Menambah 'F' sebelum 'C'");
        list.addBefore("C", new Node("F"));
        list.printList();
    }
}
//maulana ilham al amin
//255150407111099        

    
