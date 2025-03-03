class Node{
    int data;
    Node next;
    Node prev;

    Node(int data1 , Node next1 , Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }
    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
}
public class LL4_doublyLL_insertions {
    public static Node array2dll(int[]ar){
        Node head = new Node(ar[0]);
        Node marker = head;
        for(int i = 1 ; i < ar.length ; i++){
            Node temp = new Node(ar[i]);
            marker.next = temp;
            temp.prev = marker;
            marker = marker.next;
        }
        return head;
    }

    public static void printdll(Node head){
        Node temp = head;
        while(temp != null ){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node AddNewHead(Node head , int val){

        if(head == null){
            return new Node(val);
        }

        Node temp = new Node(val);
        Node oldhead = head;
        oldhead.prev = temp;
        temp.next = oldhead;
        return temp;

    }

    public static Node AddNewTail(int val , Node head){
        Node temp = head;
        Node NewTail = new Node(val);
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = NewTail;
        NewTail.prev = temp;

        return head;
    }

    public static Node Add_Element_At_K(Node head, int k, int val) {
    
        if (head == null) return new Node(val);
    
        if (k == 1) { 
            Node temp = head;
            Node newhead = new Node(val);
            newhead.next = temp;
            temp.prev = newhead;
            return newhead;
        }
    
        Node temp = head;
        Node newel = new Node(val);
        int c = 1;
    
        while (temp != null) {
            c++;
            
            if (c == k) { 
                newel.next = temp.next;
                
                if (temp.next != null) { 
                    temp.next.prev = newel;
                }
                
                temp.next = newel;
                newel.prev = temp;
                return head;
            }
    
            temp = temp.next;
        }
    
        return head;
    }
    

    public static void main(String[]args){
        int [] ar = {10,20,30,40,50};
        Node head = array2dll(ar);
        System.out.print("DLL is : ");
        printdll(head);

        System.out.println(" ");

        head = AddNewHead(head , 0);
        System.out.print("New DLL is (New Head) : ");
        printdll(head);

        System.out.println(" ");

        head = AddNewTail(60 , head);
        System.out.print("New DLL is (New Tail) : ");
        printdll(head);

        System.out.println(" ");

        head = Add_Element_At_K(head , 5 , 35);
        System.out.print("New DLL is (New Element) : ");
        printdll(head);
    }
}
