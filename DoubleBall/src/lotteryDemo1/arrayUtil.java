package lotteryDemo1;


public class arrayUtil {
    /**
     * 合并两个数组，这两个数组的要求：每个数组的第二维的元素数量相同
     * @param arr1 第一个数组
     * @param arr2 第二个数组
     * @param arr1Length 第一个数组第一维的长度
     * @param arr11Length 第一个数组第二维的长度
     * @param arr2Length 第二个数组第一维的长度
     * @param arr22Length 第二个数组第二维的长度
     * @return 返回两个数组合并后的数组
     */
    public static int[][] combine2DArrays(int[][] arr1, int[][] arr2, int arr1Length, int arr11Length, int arr2Length, int arr22Length) {
        // 取数组第二为的最大值为max
        int max=arr11Length>arr22Length?arr11Length:arr22Length;
        int[][] arr = new int[arr1Length+arr2Length][max];
        for (int i = 0; i < arr1Length; i++) {
            for (int j = 0; j < arr11Length; j++) {
                arr[i][j] = arr1[i][j];
            }
        }
        for (int i = arr1Length; i < (arr1Length+arr2Length); i++) {
            for (int j = 0; j < arr22Length; j++) {
                arr[i][j] = arr2[i-arr1Length][j];
            }
        }
        return arr;
    }
}
