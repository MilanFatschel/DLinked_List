class Node {
    public int val;
    public Node next;
    public Node prev;
    
    public Node(int v) {
        this.val = v;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {
    
    private Node[] array;
    private int size;
    private Node head;
    private Node tail;
    
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > this.size - 1 || this.size == 0)
            return -1;
        else {
            Node scanner = head;
            for(int i = 0; i < index; i++) {
                scanner = scanner.next;
            }
            
            return scanner.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(size == 0) {
            this.head = new Node(val);
            this.tail = head;
        }
        else {
          head.prev = new Node(val);
          head.prev.next = head;
          head = head.prev;
        }
        
        this.size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) { 
         if(size == 0) {
            this.head = new Node(val);
            this.tail = head;
        }
        else {
            this.tail.next = new Node(val);
            this.tail.next.prev = tail;
            this.tail = this.tail.next;
        }
        
        this.size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.size || index < 0) return;
        if(size == 0) {
            this.head = new Node(val);
            this.tail = head;     
        }
        
        Node scanner = head;
        for(int i = 0; i < index; i++) {
            scanner = scanner.next;
        }
        
        if(scanner == head) {
            this.head.prev = new Node(val);
            this.head.prev.next = head;
            this.head = this.head.prev;
        }
        else if(scanner == null) {
            this.tail.next = new Node(val);
            this.tail.next.prev = tail;
            this.tail = tail.next;
        }
        else {
            Node temp = scanner.prev;
            scanner.prev = new Node(val);
            scanner.prev.next = scanner;
            temp.next = scanner.prev;
            scanner.prev.prev = temp;
        }
        
        this.size++;
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(this.size == 0 || index >= this.size || index < 0) return;
        if(this.size == 1) {
            this.head = null;
            this.tail = null;
            size--;
            return;
        }
        
        Node scanner = head;
        for(int i = 0; i < index; i++) {
            scanner = scanner.next;
        }
        
        if(scanner == this.head) {
            this.head = head.next;
            this.head.prev = null;
        }
        else if(scanner == this.tail) {
            this.tail = tail.prev;
            this.tail.next = null;
        }
        else {
            scanner.prev.next = scanner.next;
            scanner.next.prev = scanner.prev;
        }
        
        this.size--;        
    }
}
