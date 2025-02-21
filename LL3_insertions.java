class Node {
    int data;
    Node next;

    Node(int data1) {
        this.data = data1;
    }

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }
}

public class LL3_insertions {

    public static Node array2LL(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node marker = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            marker.next = temp;
            marker = marker.next;
        }
        return head;
    }

    public static void printll(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node addhead(Node head, int el) {
        Node temp = new Node(el);
        temp.next = head;
        return temp;
    }

    public static Node addtail(Node head, int el) {
        Node newtail = new Node(el);
        if (head == null) return newtail;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newtail;
        return head;
    }

    public static Node add_kth_element(Node head, int k, int el) {
        if (k < 1) return head;

        Node newel = new Node(el);
        if (k == 1) {
            newel.next = head;
            return newel;
        }

        Node temp = head;
        int c = 1;

        while (temp != null && c < k - 1) {
            temp = temp.next;
            c++;
        }

        if (temp == null) return head;

        newel.next = temp.next;
        temp.next = newel;

        return head;
    }

    public static void main(String[] args) {
        int[] ar = {10, 20, 30, 40, 50};

        Node head = array2LL(ar);
        System.out.println("Head of the LL is : " + head.data);

        System.out.print("The linked list is : ");
        printll(head);

        head = addhead(head, 0);
        System.out.print("The New linked list after adding new head is : ");
        printll(head);

        head = addtail(head, 60);
        System.out.print("The New linked list after adding new tail is : ");
        printll(head);

        head = add_kth_element(head, 5, 35);
        System.out.print("The New linked list after adding new element at given position  is : ");
        printll(head);
    }
}
