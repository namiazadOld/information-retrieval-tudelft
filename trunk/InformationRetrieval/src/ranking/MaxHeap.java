package ranking;


import java.util.Vector;

public class MaxHeap
{
    // an initial tree size of 10 elements, growing at the rate of 5 elements
    // per growth period
    private Vector<Score_DocID_Combination> tree=new Vector<Score_DocID_Combination>(10,5);
   
    /**
     * Default constructor
     */
    public MaxHeap(){}
    
    /**
     * This method will return the element at offset x within the packed array.  Normally this shouldn't be
     * used.  It simply allows us to look inside when we're displaying it using the HeapView class.
     * @param x The element number (0 - n) to lookup.
     */
    public Score_DocID_Combination elementAt(int x) throws ArrayIndexOutOfBoundsException
    {
        return (Score_DocID_Combination)tree.elementAt(x);
    }
    
    /**
     * This returns the number of elements (nodes and leaves) in the tree
     */
    public int size()
    {
        return tree.size();
    }
    
    /**
     * Place an int into the heap.  This will sort appropriately.
     * @param n The number to be enqueued.
     */
    public void enqueue(Score_DocID_Combination newNode)
    {
//        // Create the object wrapper for an int
//        Integer num=new Integer(n);
        // Append to the end of the array
        tree.addElement(newNode);
        // We're going to start out at the last leaf (the one we just appended)
        int curpos=tree.size()-1;
        // While this Integer isn't the root and it is greater than it's parent
        // Note the use of the && operator.  If the first
        // expression evaluates as false, the second is not evaluated.  This
        // avoids an ArrayIndexOutOfBoundsException in the event that
        // tree.elementAt(0)==num
        while(tree.elementAt(0).compareTo(newNode) != 0 && newNode.compareTo( tree.elementAt( (int)((curpos-1)/2)) ) == 1 )
        {
        	Score_DocID_Combination o1;
            // Get num's parent and swap the two.
            o1=tree.elementAt((int)((curpos-1)/2));
            tree.setElementAt(newNode,(int)((curpos-1)/2));
            tree.setElementAt(o1,curpos);
            // Move our current position up in the tree.
            curpos=(int)((curpos-1)/2);
        }
    }
    
    /**
     * Return the root of the heap and reorder it.  In the event that the
     * heap is empty, this will throw an ArrayIndexOutOfBoundsException.
     */
    public Score_DocID_Combination dequeue() throws ArrayIndexOutOfBoundsException
    {
        // Record the value of the current root
    	Score_DocID_Combination root = tree.elementAt(0);
        // This is the current max element and as soon as we remove an element
        // it will be the actual size of the Vector.
        int size=this.size()-1;
        // Last leaf in the heap
        Score_DocID_Combination lastnode=tree.elementAt(size);
        // Put it at the root and remove it from the end
        tree.setElementAt(lastnode,0);
        tree.removeElementAt(size);       
        // We'll start at the root
        int curpos=0;
        // While we're not down in the leaves
        for(curpos=0;curpos<(size/2);)
        {
            // Get the left child
        	Score_DocID_Combination lchild = tree.elementAt(curpos*2+1);
        	Score_DocID_Combination rchild = null;
            // If there is a right child, get that as well
            if((curpos*2+2) < size)
                rchild = tree.elementAt(curpos*2+2);
            // If one or both of lastnode's children is greater than it, we
            // swap it with the greater of it's children.
            if(rchild != null && rchild.compareTo(lchild) == 1)
            {
                if(lastnode.compareTo(rchild) == -1)
                {
                    // Put rchild @ the current position of lastnode
                    tree.setElementAt(rchild,curpos);
                    // Advance curpos to the (previous) position of rchild
                    curpos=curpos*2+2;
                    // And place lastnode there
                    tree.setElementAt(lastnode,curpos);
                }
                else
                    // lastnode is greater than both of it's children,
                    // the heap is sorted.
                    break;
            }
            else
            {
                // Same thing as with rchild (above) only with lchild.
                if(lastnode.compareTo(lchild) == -1)
                {
                    tree.setElementAt(lchild,curpos);
                    curpos=curpos*2+1;
                    tree.setElementAt(lastnode,curpos);
                }
                else
                    break;
            }
        }
        // Finally we return the old value of the root node.
        return root;
    }
}


