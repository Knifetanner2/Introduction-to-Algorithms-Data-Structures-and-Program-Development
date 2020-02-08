class AssociationList<Key, Value>
{
  private class Node
  {
    private Key key;
    private Value value;
    private Node next;

    private Node(Key key, Value value, Node next)
    {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private Node head;

  public AssociationList()
  {
    head = new Node(null, null, head);
  } 
  public void delete(Key key)
  {
    Node left = head;
    Node right = head.next;

    while (right != null)
    {
      if(isEqual(right.key, key))
      {
        left.next = right.next;
        break;
      }
      else
      {
        left = right;
        right = right.next;
      }
    }
  }
  public Value get(Key key)
  {
    Node temp = head.next;
    while (temp != null)
    {
      if(isEqual(temp.key, key))
      {
        return temp.value;
      }
      else
      {
        temp = temp.next;
      }
    }
    throw new IllegalArgumentException("No key.");
  }
  public boolean isEqual(Key leftKey, Key rightKey)
  {
    if(leftKey == null || rightKey == null)
    {
      return leftKey == rightKey;
    }
    else
    {
      return leftKey.equals(rightKey);
    }
  }
  public boolean isIn(Key key)
  {
    Node temp = head.next;
    if (temp == null)
    {
      return false;
    }
    while (temp != null)
    {
      if(isEqual(temp.key, key))
      {
        return true;
      }
      else
      {
      temp = temp.next;
      }
    }
    return false;
  }
  public void put(Key key, Value value)
  {
    Node temp = head.next;

    while(temp != null)
    {
      if(isEqual(key, temp.key))
      {
        temp.value = value;
        break;
      }
      else
      {
        temp = temp.next;
      }
    }
    Node newNode = new Node(key,value,head.next);
    head.next = newNode;
  }
}