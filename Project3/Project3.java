class AnagramTree {
  private class TreeNode
  {
    private byte summary[]; //key
    private WordNode words; //FINISH; Linear singly linked list of WordNodes, value
    private TreeNode left; //Treenode left subtree
    private TreeNode right; //Treenode right subtree

    private TreeNode(byte[] summary, String word)
    {
      this.summary = summary; //key
      words = new WordNode(word);//construct words
      left = null;//Treenode left subtree
      right = null;//Treenode right subtree
    }
  }
  private class WordNode
  {
    private String word; //String representing word
    private WordNode next;

    private WordNode(String word)
    {
      this.word = word;
      this.next = null;
    }
    private WordNode(String word, WordNode next)
    {
      this.word = word;
      this.next= next;
    }
  }

  private TreeNode head;

  public AnagramTree()
  {
    head = new TreeNode(null, null);
  }

  public void add(String word)
  {
    byte [] summ = stringToSummary(word);
	
	if(head.left == null)//If no left, simply create one(We are having the tree be to the left of head, can be to right)
	{
		head.left = new TreeNode(summ,word);
	}
	else
	{	
		TreeNode temp = head.left;
		while(true)//Need to loop until we break when a new node is created for summary or summary is matched
		{
			int compared = compareSummaries(temp.summary, summ);//Comparison, integer value
			
			if(compared > 0)
			{
				if(temp.right == null)
				{
					temp.right = new TreeNode(summ,word);
					break;//End loop, summary added
				}
				else
				{
					temp = temp.right;//Iterates down tree if node already exists and it doesn't match
				}
			}
			else if(compared < 0)
			{
				if(temp.left == null)
				{
					temp.left = new TreeNode(summ,word);
					break;//End loop, summary added
				}
				else
				{
					temp = temp.left;//Iterates down tree if node already exists and it doesn't match
				}
			}
			else//Case when summaries are equal
			{
				//Need to check that not a duplicate
				if(temp.words.word == word)
				{
					return;//Word already exists
				}
				WordNode tempNode = temp.words; //created so that the temp isn't overwritten
				while(tempNode != null)
				{
					if(tempNode.word.equals(word))
					{
						return; // Already exists
					}
					else
					{
						tempNode = tempNode.next;
					}
				}
				//Only gets out of loop if a non duplicate
				temp.words = new WordNode(word,temp.words);
				break;//End loop, word added
			}
		}
	}
  }
 public void helper(TreeNode node)
 {
	if(node == null)//Empty node means no words
	{
		return;
	}
	if(node.words.next != null) //More than 2 words
	{
		String wordList = "";
		while(node.words != null)//If more words left
		{
			wordList = wordList + node.words.word + " ";//Adds each word
			node.words = node.words.next; //Iterates
		}
		System.out.println(wordList);
	}
	helper(node.left);
	helper(node.right);
 }
 
 public void anagrams()//Need at least one helper
  {
	helper(head.left);//Ignore Head node
  }

  private int compareSummaries(byte[] left, byte[] right)
  {
    for(int i=0; i< left.length; i++)
    {
      if(left[i] != right[i])
      {
        return left[i] - right[i];// Returns >0 if right > left, else <0 if left > right
      }
    }
    return 0; //if they are equal
  }
  
  private byte[] stringToSummary(String word)
  {
    byte[] wordSumm = new byte[26];

    for(int i=0; i<word.length(); i++)
    {
      int temp = word.charAt(i) - 'a';
      wordSumm[temp] ++;
    }
    return wordSumm;
  }
}
class Anagrammer
{
  public static void main(String[] args)
  {
    Words list = new Words("warAndPeace.txt"); //Make instance of worcs that reads words from text filed
    AnagramTree aTree = new AnagramTree(); //Make an empty AnagramTree
	
    while(list.hasNext())//REad all words from text file and add to tree
	{
		aTree.add(list.next());
	}
    aTree.anagrams(); //Traverse tree and print anagrams
  }
}
