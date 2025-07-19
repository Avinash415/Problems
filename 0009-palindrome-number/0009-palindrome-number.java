class Solution {
    public boolean isPalindrome(int x) {
    int newNum=x;
    int res=0;

    while(x > 0){
        int lD=x%10;
        res=res*10 + lD;
        x=x/10;
    }

       return (newNum==res ? true : false);
    }
}