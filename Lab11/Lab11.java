class Deque<Base>
{
  private class Node //Node Class
  {
    private Base object; //Object of Node
    private Node left;//Node to left of Node (Clockwise)
    private Node right;//Node to right of Node (Counter Clockwise)

    private Node(Base obj, Node leftNode, Node rightNode)//Node constructor class
    {
      this.object = obj;
      this.left = leftNode;
      this.right = rightNode;
    }
  }
  private Node head;//head Node

  public Deque()//Queue constructor
  {
    this.head = new Node(null, null, null); //Empty head node
    this.head.left = this.head; //points left of head to head
    this.head.right = this.head; //points right of head to head
  }
  public void enqueueFront(Base object)//Adds to front of queue
  {
    Node temp = head.right; //Current front node
    head.right = new Node(object,head,temp);//Sets new front to a new node
    temp.left = head.right;//fixes pointer
  }
  public void enqueueRear(Base object)//Adds to back of queue
  {
    Node temp = head.left;//Current Rear
    head.left = new Node(object,temp,head);//Sets new rear to new node
    temp.right = head.left;//fixes pointer
  }
  public Base dequeueFront()//Removes front Node
  {
    if(isEmpty())//If Empty, throws exception
    {
      throw new IllegalStateException("Empty Queue");
    }
    Node temp = head.right;//creates a temp node that is the current front node
    head.right = head.right.right;//sets front node pointer to next node
    head.right.left = head; //sets new front node left pointer to head
    return temp.object;//returns the old front node
  }
  public Base dequeueRear()//Removes rear node
  {
    if(isEmpty())//If Empty, throws exception
    {
      throw new IllegalStateException("Empty Queue");
    }
    Node temp = head.left;//Creates temp node of current rear node
    head.left = head.left.left;//Sets rear node pointer to earlier node
    head.left.right = head;//Sets new rear node right node to head
    return temp.object;//returns old rear node
  }
  public boolean isEmpty()
  {
    return (head.left == head && head.right == head);//If head points to itself
  }
}