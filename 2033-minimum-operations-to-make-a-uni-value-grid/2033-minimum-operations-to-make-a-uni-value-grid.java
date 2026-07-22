class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                g.add(grid[i][j]);

            }

        }
        int m=g.get(0)%x;
        for(int i:g)
        {
            if(i%x!=m)
            {
                return -1;

            }
        }
      Collections.sort(g);
      int mid=g.get(g.size()/2);
      int operations=0;

      for(int i:g)
      {
        operations+=Math.abs(i-mid);


      }
      return operations/x;



    }
}