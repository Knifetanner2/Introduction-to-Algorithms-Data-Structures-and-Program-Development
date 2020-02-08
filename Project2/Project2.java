//  SORT. Sort a linear singly-linked list of INTs.

class Main//Sort
{

//  NODE. A node in a linear singly linked list of INTs.

  private static class Node
  {
    private int  number;  //  The INT in the node, duh.
    private Node next;    //  The NODE that follows this one, or NULL.

//  Constructor. Initialize a new NODE with NUMBER and NEXT.

    private Node(int number, Node next)
    {
      this.number = number;
      this.next = next;
    }
  }

//  MAKE NODES. Return a list of NODEs that contains INTs from NUMBERS in order
//  of their appearance.

  private static Node makeNodes(int ... numbers)
  {
    if (numbers.length > 0)
    {
      Node first = new Node(numbers[0], null);
      Node last  = first;
      for (int index = 1; index < numbers.length; index += 1)
      {
        last.next = new Node(numbers[index], null);
        last = last.next;
      }
      return first;
    }
    else
    {
      return null;
    }
  }

//  WRITE NODES. Write the INTs from a list of NODEs in paired square brackets,
//  separated by commas, with a newline at the end.

  private static void writeNodes(Node nodes)
  {
    System.out.print('[');
    if (nodes != null)
    {
      System.out.print(nodes.number);
      nodes = nodes.next;
      while (nodes != null)
      {
        System.out.print(", ");
        System.out.print(nodes.number);
        nodes = nodes.next;
      }
    }
    System.out.println(']');
  }

//  SORT NODES. Sort UNSORTED, a list of NODEs, into nondecreasing order of its
//  NUMBER slots, without making new NODEs.

  private static Node sortNodes(Node unsorted)
  {
    //Testing Phase
    if(unsorted == null || unsorted.next == null) //Testing phase, if unsorted is length 1 or 0 just return
    {
      return unsorted;
    }
    //Halving Phase
    Node left = null;//Breaks up unsorted into left and right until it is broken up into single nodes in a binary tree
    Node right = null;
    Node temp = unsorted;
    int count = 1;

    while(unsorted != null)
    {
      if(count % 2 == 0)
      {
        count++;
        temp = right;
        right = unsorted;
        unsorted = unsorted.next;
        right.next = temp;
        //temp = unsorted;
      }
      else
      {
        count++;
        temp = left;
        left = unsorted;
        unsorted = unsorted.next;
        left.next = temp;
        //temp = unsorted;
      }
    }
    //Sorting Phase
    left = sortNodes(left);//Reruns sort until it is only one node(testing), then works back up
    right = sortNodes(right);

    //Combining Phase
    Node sorted = null;//Sorted Node
    Boolean first = true;//First case
    Node endpointer = null;//Pointer to point to last Node in sorted
    while(left != null && right != null)
    {
      if(first)//For first runthrough sets sorted to left or right, whichever is less
      {
        if(left.number < right.number)
        {
          sorted = left;
          endpointer = left;
          left = left.next;
        }
        else
        {
          sorted = right;
          endpointer = right;
          right = right.next;
        }
        first = false;//Only first case
      }
      else if(left.number < right.number)//If left is less than right
      {
        endpointer.next = left;
        endpointer = endpointer.next;
        left = left.next;
      }
      else//Right less than or equal to left
      {
        endpointer.next = right;
        endpointer = endpointer.next;
        right = right.next;
      }
    }//Ends when left or right is null
    if(left == null)//If left null, appends right to end
    {
      endpointer.next = right;
      endpointer = endpointer.next;
    }
    else//If right null, append left to end
    {
      endpointer.next = left;
      endpointer = endpointer.next;
    }
    return sorted;
  }

//  MAIN. Run some examples. The comments show what must be printed.

  public static void main(String [] args)
  {
    writeNodes(sortNodes(makeNodes()));      //  []                  //Empty List
    writeNodes(sortNodes(makeNodes(1)));     //  [1]
    writeNodes(sortNodes(makeNodes(1, 2)));  //  [1, 2]
    writeNodes(sortNodes(makeNodes(2, 1)));  //  [1, 2]

    writeNodes(sortNodes(makeNodes(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    //  [1, 2, 3, 4, 5, 6, 7, 8, 9]

    writeNodes(sortNodes(makeNodes(9, 8, 7, 6, 5, 4, 3, 2, 1)));
    //  [1, 2, 3, 4, 5, 6, 7, 8, 9]

    writeNodes(sortNodes(makeNodes(3, 1, 4, 5, 9, 2, 6, 8, 7)));
    //  [1, 2, 3, 4, 5, 6, 7, 8, 9]
    writeNodes(sortNodes(makeNodes(3, 4, 4, 5, 9, 6, 6, 8, 7))); //Duplicate Example
    //  [3, 4, 4, 5, 6, 6, 7, 8, 9]
  }
}
