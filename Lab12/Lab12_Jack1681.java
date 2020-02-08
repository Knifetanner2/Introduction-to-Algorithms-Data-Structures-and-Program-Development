class PriorityQueue<Base>
{
  private class Node
  {
    private Base object;
    private int  rank;
    private Node left;
    private Node right;

    private Node(Base object, int rank)
    {
      this.object = object;
      this.rank = rank;
      left = null;
      right = null;
    }
  }


  private Node root;  //  Root node of the BST.

  public PriorityQueue()
  {
    root = new Node(null, 10);//Head rank of 10 so it is higher than the last rank, going to have BST to left
  }

  public Base dequeue()    //remove highest ranked object with lowest rank number and return object
  {
    if(isEmpty())
    {
      throw new IllegalStateException("Empty queue");
    }
    else
    {
    Node above = null; //No node above starting node
    Node below = root; // Starts at current node
    Node temp = below;//Current node to return after deletion

    while(below.left != null)//While Still nodes that are less than or equal to
    {
      above = below;//Iterates down
      below = below.left;//Iterates Left
      temp = below;//Current Node
    }
    if(below.right != null)//Left Node is Null and right isn't null, sets aboves pointer to the right pointer
    {
      above.left = below.right;
    }
    else if(below.right == null)//If both left and right is null, above's left pointer will be null
    {
      above.left = null;
    }
    return temp.object; // Returns Deleted Object
    }
  }
  public void enqueue(Base object,int rank)//Adding a node
  {
    if (rank < 0)
    {
      throw new IllegalArgumentException("Negative rank.");
    }
    else
    {
      Node subtree = root;//Comparison Node
      while(true)//Infinite loop, uses breaks
      {
        if(rank <= subtree.rank)//If rank is less than or equal to comparison
        {
          if(subtree.left == null)//With no left node, add node to left
          {
            subtree.left = new Node(object, rank);
            break;
          }
          else//Otherwise iterates down tree
          {
            subtree = subtree.left;
          }
        }
        else if (rank > subtree.rank)
        {
          if(subtree.right == null)
          {
            subtree.right = new Node(object,rank);
            break;
          }
          else
          {
            subtree = subtree.right;
          }
        }
      }
    }
  }
  public boolean isEmpty()
  {
    return root.left == null && root.right == null;
  }
}