class Solution {
    public String minWindow(String s, String t) {
        // base case..
        if(s.length() < t.length()){
            return "";
        }

        String res="";

        Map<Character, Integer> map=new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char str=t.charAt(i);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int mct=0;   // match count..
        int dmct=t.length();  // dmct -> desired match count..
        Map<Character, Integer> map1=new HashMap<>();
        int i=-1;
        int j=-1;

        while(true){
            boolean f1=false;
            boolean f2=false;
            // Aquire
            while(i < s.length()-1 && mct < dmct){
                i++;
                char ch=s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                if(map1.getOrDefault(ch, 0) <= map.getOrDefault(ch, 0)){
                    mct++;
                }
                f1=true;
            }

            // collect res and release..
            while( j < i && mct==dmct){
                String pres=s.substring(j+1, i+1);  // pres -> potantial result..
                if(res.length()==0 || pres.length() < res.length()){
                    res=pres;
                }

                j++;
                char ch=s.charAt(j);
                if(map1.get(ch)==1){
                    map1.remove(ch);
                }else{
                    map1.put(ch, map1.get(ch)-1);
                }

                if(map1.getOrDefault(ch, 0) < map.getOrDefault(ch, 0)){
                    mct--;
                }
                f2=true;
            }

            if(f1==false && f2==false){
                break;
            }
        }


        return res;
    }
}