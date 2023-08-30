class Solution {
    public int trap(int[] height) {
         int n=height.length;
        // Calculate left max boundary  --Array
        // int leftMax[] = new int[n];
        // leftMax[0]=height[0];

        // for(int i=1; i<n; i++){
        //     leftMax[i]=Math.max(height[i], leftMax[i-1]);
        // }

        // // calculate RightMax  boundary  ---Array
        // int rightMax[]=new int[n];
        // rightMax[n-1]=height[n-2];

        // for(int i=n-2; i>=0; i--){
        //     rightMax[i]=Math.max(height[i], rightMax[i+1]);
        // }

        // int trappedWater=0;

        // //loop
        // for(int i=0; i<n; i++){
        //     // WaterLevel = min(leftMax bound , rightMax bound)

        //     int waterLevel=Math.min(leftMax[i], rightMax[i]);

        //     //trappedWater = waterLevel - height[i]
        //     trappedWater=waterLevel-height[i];
                
        // }
        // return trappedWater;
          int l=0;
       int r=n-1;
       int lmax=0; int rmax=0;int ans=0;
       while(l<=r)
       {
           if(height[l]<=height[r])
           {
               if(height[l]<=lmax)
               ans+=lmax-height[l];
               else
               lmax=height[l];
               l++;
           }
           else
           {
               if(height[r]<=rmax)
               ans+=rmax-height[r];
               else
               rmax=height[r];
               r--;
           }
       }
       return ans;
        
    }
}