import org.junit.Test;

public class OffByN implements CharacterComparator{
    int N;
    public  OffByN(int N)
    {
        this.N=N%128;//the biggest num of char is 128
    }

    @Override
    public boolean equalChars(char x,char y)
    {
        int diff=Math.abs(x-y);
        return diff==N;
    }

}
