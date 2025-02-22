class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

public class LL4_doublyLL {

    public static Node array2DLL(int[] ar) {
        Node head = new Node(ar[0]);
        Node marker = head;

        for (int i = 1; i < ar.length; i++) {
            Node temp = new Node(ar[i]);
            temp.back = marker;
            marker.next = temp;
            marker = marker.next;
        }
        return head;
    }

    public static Node delhead(Node head) {
        if (head == null) return null;
        head = head.next;
        if (head != null) head.back = null; 
        return head;
    }

    public static Node delTail(Node head){

        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next != null){            
            temp = temp.next;
        }
        Node newTail = temp.back;
        newTail.next = null;
        temp.back = null;
        return head;
    }

    public static void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println(" <-> NULL");
    }

    public static void main(String[] args) {
        int[] ar = {10, 20, 30, 40, 50, 60};
        Node head = array2DLL(ar);
        System.out.println("Original Head: " + head.data);
        printDLL(head);
        head = delhead(head);
        System.out.println("\nUpdated Head: " + head.data);
        printDLL(head);
        head = delTail(head);
        System.out.println("\nUpdated tail: ");
        printDLL(head);

    }
}
