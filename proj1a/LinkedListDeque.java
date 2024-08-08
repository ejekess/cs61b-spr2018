public class LinkedListDeque<Type>
{
    /**Double Linked List:use circular sentinel*/
    private class TypeNode{
        Type item;
        TypeNode prev;
        TypeNode next;
        public TypeNode()
        {
            item=(Type)new Object();
            next=this;
            prev=this;
        }
        public TypeNode(Type n)
        {
            this.item=n;
        }

        public  Type getRecursive(int index)
        {
            if(index==0)
                return item;
            return next.getRecursive(index-1);
        }
    }

    private TypeNode head;
    int size;

    public LinkedListDeque()
    {
        head=new TypeNode();
        size=0;
    }

    private Type getRecursive(TypeNode p,int index)
    {
        if(index>=size) return null;
        if(index==0) return p.next.item;
        return getRecursive(p.next,index-1);
    }
    public Type getRecursive(int index)
    {
      return getRecursive(head,index);
    }

    public void addFirst(Type item){
        size++;
        TypeNode p=new TypeNode(item);
        p.next=head.next;
        head.next.prev=p;
        head.next=p;
        p.prev=head;

    }
    public void addLast(Type item)
    {
        size++;
          TypeNode p=new TypeNode(item);
          p.next=head;
          p.prev=head.prev;
          head.prev.next=p;
          head.prev=p;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public void printDeque()
    {
        TypeNode p=head.next;
        while(p!=head)
        {
            System.out.println(p.item);
            p=p.next;
        }
    }
    public Type removeFirst()
    {
        if(size==0)
            return null;
        size--;
        /** the first node*/
        TypeNode p=head.next;
        head.next=p.next;
        p.next.prev=head;
        p.next=null;
        p.prev=null;
        return p.item;
    }
    public Type removeLast()
    {
         if(size==0)
             return null;

         size--;

         /** the  last node*/
         TypeNode p=head.prev;
         p.prev.next=head;
         head.prev=p.prev;
         p.prev=null;
         p.next=null;
         return p.item;
    }

    public Type get(int index)
    {
        if(index>=size)
            return null;
        TypeNode p=head.next;
        while(index>0)
        {
            p=p.next;
            index--;
        }
        return p.item;

    }

}