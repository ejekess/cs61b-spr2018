class ArrayDeque<T> implements Deque<T>{
    T[] arrays;
    int maxSize=10;
    int nextFirst;//First =(nextFirst+1)%maxSize;
    int nextLast;//Last=(nextLast+1)%maxSize;
    int size;



    /** use the  form:circular arrays*/

    public ArrayDeque(){
         arrays=(T[])new Object[maxSize];
         nextFirst=maxSize/2-1;
         nextLast=nextFirst+1;
    }
    private void copyArray()
    {
        T[]  temp=(T[])new Object[maxSize*2];
        for(int i=0;i<=nextFirst;i++)
        {
            temp[i]=arrays[i];
        }
        for(int i=nextFirst+1;i<maxSize;i++)
        {
            temp[i+maxSize]=arrays[i];
        }
        nextFirst+=maxSize;
        maxSize*=2;
        arrays=temp;
    }



    @Override
    public void addFirst(T item){
        /** extends the arrays:
         * obvious that if the array is full ,
         * we can conclude:
         * nextLast =(nextFirst+1)%maxSize;
         * Index:nextFirst=Last,nextLast=First
         * */
       if(size==maxSize)
       {
          copyArray();
       }
        arrays[nextFirst]=item;
        nextFirst=(nextFirst-1+maxSize)%maxSize;
        size++;
    }

    @Override
    public void addLast(T item)
    {
        if(size==maxSize)
        {
            copyArray();
        }
        arrays[nextLast]=item;
        nextLast=(nextLast+1)%maxSize;
        size++;
    }


    @Override
    public boolean isEmpty()
    {
      return size==0;
    }

    @Override
    public int size()
    {
      return size;
    }

    @Override
    public void printDeque()
    {
        int Last=(nextLast-1)%maxSize;
        int First=(nextFirst+1)%maxSize;
        int temp=First;
        while(temp!=Last)
        {
            System.out.println(arrays[temp]);
            temp=(temp+1)%maxSize;
        }
    }

    @Override
    public T removeFirst()
    {
        if(size==0) 
            return null;
       
        size--;
        nextFirst=(nextFirst+1)%maxSize;
        return arrays[nextFirst];
    }


    @Override
    public T removeLast()
    {
        if(size==0)
            return null;
        nextLast=(nextLast-1+maxSize)%maxSize;
        return arrays[nextLast];
    }


    @Override
    public T get(int index)
    {
        if(index>=size) return null;
        return arrays[(nextFirst+1+index)%maxSize];
    }
}
