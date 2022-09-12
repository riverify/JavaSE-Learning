package lotteryDemo1;

public class Test {
    public static void main(String[] args) {
        int[][] arr1={{1,2,3},{4,5,6}};
        int[][] arr2={{7,8,9},{10,11,12}};
        int[][] arr=new int[0][0];
        arrayUtil.combine2DArrays(arr1,arr2,2,3,2,3);
        System.out.println(arr[2][2]);
    }
}
