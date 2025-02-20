class Node{
   int data;
   Node next;
   
   Node(int data1){
    this.data = data1;
   }

   Node(int data1 , Node next1){
    this.data = data1;
    this.next = next1;

   }
}

public class LL2_deletions {

    public static Node array2LL(int[]arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i = 1 ; i < arr.length ; i++){

                Node temp = new Node(arr[i]);
                mover.next = temp;
                mover=mover.next;
        }
        return head;
    }

    public static void printll(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static Node deletehead(Node head){
        if(head==null) return head;
        head = head.next;

        return head;
    }

    public static Node delete_kth_element(Node head , int k){

        if(k == 1){
            head = head.next;
            return head; 
        }

        int c = 0 ; Node prev = null , temp = head;
        
        while(temp != null){
            c++;
            if(c == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node delete_the_element(Node head , int el){

        if(head.data == el){
            head = head.next;
            return head; 
        }

         Node prev = null , temp = head;
        
        while(temp != null){
            if(temp.data == el ){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node delete_tail(Node head){
        Node temp = head;
        if(head == null || head.next == null) return null;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next=null;       
        return head;
    }


    public static void main(String [] args){
        
        int ar [] = {1,2,3,4,5};

        Node head = (array2LL(ar));
        System.out.println("The head is " + head.data );
        
        System.out.print("The linked list is ");
        printll(head);

        System.out.println();

        head = deletehead(head);
        System.out.print("The linked list after head deletion is ");
        printll(head);

        System.out.println();

        delete_tail(head);
        System.out.print("The linked list after tail deletion is ");
        printll(head);

        System.out.println();

        delete_kth_element(head , 3);
        System.out.print("The linked list after kth element deletion is ");
        printll(head);

        System.out.println();

        delete_the_element(head , 3);
        System.out.print("The linked list after kth element deletion is ");
        printll(head);

    }
    
}
