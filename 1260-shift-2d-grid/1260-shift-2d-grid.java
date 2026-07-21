class Solution {

    public void reverse(List<Integer> arr, int i, int j) {
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        int n = grid.length;
        int m = grid[0].length;

        // Flatten
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr.add(grid[i][j]);
            }
        }

        int s = arr.size();
        k = k % s;

        // Rotate
        reverse(arr, 0, s - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, s - 1);

        // Build answer
        int idx = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                row.add(arr.get(idx++));
            }

            ans.add(row);
        }

        return ans;
    }
}