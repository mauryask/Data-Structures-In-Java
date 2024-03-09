/*
* T(n) : O(n)
* S(n) : O(n)
* Link: https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
*/

import static java.lang.System.*;
import java.util.*;

class Node  
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
	
	@Override 
	public String toString()
	{
		return String.valueOf(data);
	}
}

public class BurnTheTreeInOn.java
{
 
  //O(n): time complexity
  //O(n) : space complexity  
  static void buildMap(Node root, Map<Integer,  List<Node>> map)
  {
	   Queue<Node> q = new ArrayDeque<>();
	   q.add(root);	   
	   
	   while(!q.isEmpty())
	   {
		   root = q.poll();
		   List<Node> listParent = map.getOrDefault(root.data, new ArrayList<>());
		   
		   if(root.left != null)
		   {
			   List<Node> listChild = map.getOrDefault(root.left.data, new ArrayList<>());
			   listChild.add(root);
			   map.put(root.left.data, listChild);
			   
			   listParent.add(root.left);
			   map.put(root.data, listParent);
			   
			   q.add(root.left);
		   }
		   
		   if(root.right != null)
		   {
			   List<Node> listChild = map.getOrDefault(root.right.data, new ArrayList<>());
			   listChild.add(root);
			   map.put(root.right.data, listChild);
			   
			   listParent.add(root.right);
			   map.put(root.data, listParent);
			   
			   q.add(root.right);
		   }		   
	   }
  }
  
  static class TimeNode 
  {
	  int time;
      Node node;

      TimeNode(int time, Node node)
	  {
		  this.time = time;
		  this.node = node;
	  }	  
  }
  
  //O(n)
  //O(n)
  static int getMaxTime(Node root, Map<Integer, List<Node>> map)
  {
	  Queue<TimeNode> q = new ArrayDeque<>();
	  Set<Node> set = new HashSet<>();
	  int maxTime = 0;
	  q.add(new TimeNode(0, root));
	  set.add(root);
	  
	  while(!q.isEmpty())
	  {
		  TimeNode timeNode = q.poll();
		  
		  maxTime = Math.max(maxTime, timeNode.time);
		  
		  for(Node node  : map.get(timeNode.node.data))
		  {
			  if(!set.contains(node))
			  {
				  set.add(node);
				  q.add(new TimeNode(timeNode.time + 1, node));
			  }
		  }
	  }
	  
	  return maxTime;
  }
  
  static void burnTree(Node root, Node target)
  {
	  Map<Integer, List<Node>> map = new HashMap<>();
	  buildMap(root, map);	  
	  int maxTime = getMaxTime(target, map);
	  out.println(maxTime);
  }
    
  public static void main(String [] args)
  {
	 Node root = new Node(44);
     Node r1 = new Node(28);
     Node r2 = new Node(26);
	 Node r3 = new Node(25);
	 Node r4 = new Node(45);
	 Node r5 = new Node(16);
	 Node r6 = new Node(48);
	 Node r7 = new Node(180);
	 Node r8 = new Node(70);
	 Node r9 = new Node(39);
	 
	 root.left = r1;
	 root.right = r2;
	 r1.left = r3;
	 r1.right = r4;
	 r2.left = r5;
	 r2.right = r6;
	 r5.left = r7;
	 r6.left = r8;
	 r6.right = r9;
	 		
	 burnTree(root, r6);
  }
}