package tree.binaryTree.array.integer.mindepth;

public class MinDepthOfBinaryTree {

	//consider 0 as non filling
//	static int[] tree = new int[] {10,5,0};
	static int[] tree = new int[] {1,2,3,4,5};
	
	public static void main(String arg[]) {
		int i=0;
		for(; i< tree.length; i++) {
			if(isLeaf(i)) {
				break;
			}
		}
		int count = 0;
		for(; i>0; i=(i-1)/2) {
			count++;
		}
		System.out.println(count+1);
	}

	private static boolean isLeaf(int i) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		return (left >= tree.length || tree[left] == 0) && 
				(right >= tree.length || tree[right] == 0);
	}
}
