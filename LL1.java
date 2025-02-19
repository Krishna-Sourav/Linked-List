class Node{

    int data;
    Node next;

    Node(int data){
        this.data = data; 
    }
}

public class LL1{

    public static Node arr2ll(int[] arr){
        Node head = new Node (arr[0]);
        Node mover = head;
        
        for(int i = 1 ; i < arr.length ; i++){
            Node temp = new Node (arr[i]);
            mover.next = temp;
            mover = mover.next;
            
        }
        return head;
    }

    public static void printll(Node head){
        Node temp =  head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        } 
    }

    public static int LenofLL(Node head){
        int c = 0;
        Node temp =  head;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        return c;
    }

    public static int checkifpresent(Node head , int var){
        Node temp = head;
        while(temp != null){
            if(var == temp.data) return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String [] args){
        int [] arr = {1,2,3,4,5};
        Node x = new Node(arr[1]);
        System.out.println(x.data);
        System.out.println();


        Node head = arr2ll(arr);
        System.out.println(head.data);
        System.out.println();

        printll(head);

        System.out.println();
        System.out.println();


        System.out.println(LenofLL(head));
        System.out.println();
        System.out.println(checkifpresent(head , 33));
    }
}