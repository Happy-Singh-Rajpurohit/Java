import java.util.*;

public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }    

    public static Node Head;
    public static Node Tail;
    public static int size;

    public void addFirst(int data){
        //Step 1 - Create new node
        Node newNode = new Node(data);
        size++;
        if(Head == null){
            Head = Tail = newNode;
            return;
        }

        //Step 2 - newNode next = head
        newNode.next = Head;

        //Step 3 - head = newNode
        Head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(Head == null){
            Head = Tail = newNode;
            return;
        }

        Tail.next = newNode;
        Tail = newNode;
    }

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }   
        Node newNode = new Node(data);
        size++;
        Node temp = Head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void print(){
        Node temp = Head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }

        int val = Head.data;
        Head = Head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }

        Node temp = Head;
        for(int i=0; i<size-2; i++){
            temp = temp.next;
        }
        int val = temp.next.data; // tail data
        temp.next = null;
        Tail = temp;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = Head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx + 1;
    }


    public int reverse(){
        Node prev = null;
        Node curr = Tail = Head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Head = prev;
        return 0;
    }


    public void deleteNthFromEnd(int n){
        // calculate size
        int sz = 0;
        Node temp = Head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            Head = Head.next; // remove first
            return;
        }

        int i = 1;
        int itf = sz - n; // index to find
        Node prev = Head;
        while(i < itf){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next; // remove nth node
    }

    //Slow and Fast Pointer approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is my mid node
    }

    public boolean isPalindrome(){
        if(Head == null || Head.next == null){
            return true;
        }

        //Step 1 - find mid
        Node midNode = findMid(Head);

        //Step 2 - reverse 2nd half
        Node prev = null;
        Node curr = Tail = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //Step 3 - check left half and right half
        Node rightHead = prev; // right half head
        Node leftHead = Head;

        while(rightHead != null){
            if(leftHead.data != rightHead.data){
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 3);
        ll.print();
        System.out.println("Size: " + ll.size);
    }
}
