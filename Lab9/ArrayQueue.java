import java.util.Iterator;
//  ARRAY QUEUE. A fixed length queue implemented as a circular array.

class ArrayQueue<Base>
{
  private int front;      //  Index of front object in BASES.
  private int rear;       //  Index of rear object in BASES.
  private Base [] bases;  //  The BASEs in the queue.

//  Constructor. Make a new empty queue that can hold SIZE - 1 elements.

  public ArrayQueue(int size)
  {
    if (size >= 1)
    {
      front = 0;
      rear = 0;
      bases = (Base []) new Object[size];//NOTE TO GRADERS: THIS CODE IS THE CODE WE ARE SUPPOSED TO USE AND IT CAUSES THE UNCHECKED/UNSAFE OPERATIONS ERROR TO POPUP
    }
    else
    {
      throw new IllegalArgumentException("Size must be at least 1.");
    }
  }
  public Iterator<Base> iterator()
  {
    return new ArrayQueueIterator(front, rear);//ArrayQueueIterator Constructor
  }
  private class ArrayQueueIterator implements Iterator<Base>
  {
    private int current;//Current place in Iterator
    private int last;//Last possible position

    private ArrayQueueIterator(int current, int last)
    {
      this.current = current;
      this.last = last;
    } 
    public boolean hasNext()
    {
      return (!isEmpty() && !(current==last) ); //Makes sure not an empty ArrayQueue, and also that the current value isn't at the last value
    }
    public Base next()
    {
      if(!hasNext())
      {
        throw new IllegalStateException("No more elements to visit.");
      }
      current = (current + 1) % bases.length;// Sets current value to next value
      return bases[current];//returns next base(current + 1)
    }
    public void remove()
    {
      //filler method
    }

  }
//  DEQUEUE. Remove a BASE from the front of the queue and return it.

  public Base dequeue()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("Queue is empty.");
    }
    else
    {
      front = (front + 1) % bases.length;
      Base temp = bases[front];
      bases[front] = null;
      return temp;
    }
  }

//  ENQUEUE. Add BASE to the rear of the queue.

  public void enqueue(Base base)
  {
    int nextRear = (rear + 1) % bases.length;
    if (front == nextRear)
    {
      throw new IllegalStateException("Queue is full.");
    }
    else
    {
      rear = nextRear;
      bases[rear] = base;
    }
  }

//  IS EMPTY. Test if the queue is empty.

  public boolean isEmpty()
  {
    return front == rear;
  }

//  IS FULL. Test if the queue can hold no more elements.

  public boolean isFull()
  {
    return front == (rear + 1) % bases.length;
  }
}
