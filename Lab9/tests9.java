//  QUEUETERATOR. Test ARRAY QUEUE's iterator. It's worth 20 points.

class Queueterator
{

//  MAIN. Start execution here.

  public static void main(String [] args)
  {

//  Make an ARRAY QUEUE and enqueue some STRINGs. It can hold at most three.

    ArrayQueue<String> queue = new ArrayQueue<String>(4);

    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

//  Make a FIRST iterator for QUEUE and use it to visit QUEUE's elements.

    Iterator<String> first = queue.iterator();
    while (first.hasNext())
    {
      System.out.println(first.next());  //  A B C one per line      5 pts.
    }

//  Make sure FIRST hasn't changed QUEUE.

    System.out.println(queue.isEmpty());   //  false                 1 pt.
    System.out.println(queue.dequeue());   //  A                     1 pt.
    System.out.println(queue.dequeue());   //  B                     1 pt.
    System.out.println(queue.dequeue());   //  C                     1 pt.
    System.out.println(queue.isEmpty());   //  true                  1 pt.

//  Let's enqueue more three more things to QUEUE.

    queue.enqueue("X");
    queue.enqueue("Y");
    queue.enqueue("Z");

//  Now make a SECOND iterator for QUEUE. The FIRST one does not work any more,
//  because QUEUE has changed. Use SECOND to visit QUEUE's new elements.

    Iterator<String> second = queue.iterator();
    while (second.hasNext())
    {
      System.out.println(second.next());   //  X Y Z one per line    5 pts.
    }

//  The new iterator hasn't changed QUEUE either.

    System.out.println(queue.isEmpty());   //  false                 1 pt.
    System.out.println(queue.dequeue());   //  X                     1 pt.
    System.out.println(queue.dequeue());   //  Y                     1 pt.
    System.out.println(queue.dequeue());   //  Z                     1 pt.
    System.out.println(queue.isEmpty());   //  true                  1 pt.
  }
}
