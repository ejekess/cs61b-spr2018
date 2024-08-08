public class Palindrome {

    public Deque<Character> wordToDeque(String word)
    {
      LinkedListDeque<Character> wordDeque=new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
      return wordDeque;
    }

    /** use recursion */
    private boolean isPalindromeRecursion(Deque<Character>  d)
    {
         if(d.size()==0||d.size()==1)
             return true;
         return (d.removeFirst()==d.removeLast())&&isPalindromeRecursion(d);

    }
    public boolean isPalindrome(String word)
    {
         return isPalindromeRecursion(wordToDeque(word));
    }

    private boolean isPalindromeRecursion(Deque<Character>  d,CharacterComparator cc)
    {
        if(d.size()==0||d.size()==1)
            return true;
        return (cc.equalChars(d.removeFirst(),d.removeLast())&&isPalindromeRecursion(d,cc));

    }
    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        return isPalindromeRecursion(wordToDeque(word),cc);
    }



}
