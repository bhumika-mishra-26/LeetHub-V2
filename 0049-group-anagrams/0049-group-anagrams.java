class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
    HashMap<String,List<String>>mp=new HashMap<>();
    for(String str:strs)
    {
        char [] ch=str.toCharArray();
        Arrays.sort(ch);
        String new_str=new String(ch);
        if(!mp.containsKey(new_str))
        {
            mp.put(new_str,new ArrayList<>());

        }
        mp.get(new_str).add(str);


    }
    return new ArrayList<>(mp.values());

        

       
        
    }
}