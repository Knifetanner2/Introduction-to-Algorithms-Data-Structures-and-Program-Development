class RunnyStack<Base>
{
  private class Run
  {
    private Base object;
    private Run next;
    private int length;
    
    private Run(Base object, Run next, int length)
    {
      this.object = object;
      this.next = next;
      this.length = length;
    }
  }
  private Run head;
  private int count;
  private int runs;

  public RunnyStack()
  {
    count = 0;
    runs = 0;
    head = null;
  }
  public int depth()
  {
    return count;
  }
  public boolean isEmpty()
  {
    return head == null;
  }
  public Base peek()
  {
    if(isEmpty())
    {
      throw new IllegalStateException("Empty Stack");
    }
    return head.object;
  }
  public void pop()
  {
    if(isEmpty())
      {
        throw new IllegalStateException("Empty Stack");
      }
    head.length--;
    count--;
    if(head.length==0)
      {
        head = head.next;
        runs--;
      }


  }
  private boolean isEqual(Base base, Base base2)
  {
    if(base == null || base2 == null)
    {
      return base == base2;
    }
    else
    {
      return base.equals(base2);
    }
  }
  public void push(Base base)
  {
    if(isEmpty())
    {
      head = new Run(base, null, 1);
      runs++;
      count++;
    }
    else
    {
      if(isEqual(base,peek()))
      {
        count++;
        head.length++;
      }
      else
      {
        head = new Run(base, head, 1);
        runs++;
        count++;
      }
    }
  }
  public int runs()
  {
    return runs;
  }
}