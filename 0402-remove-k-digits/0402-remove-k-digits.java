class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>st=new Stack<>();
        for(char c:num.toCharArray())
        {
            while(!st.isEmpty() && st.peek()>c && k>0)
            {
                st.pop();
                k--;

            }
            st.push(c);
        }

        while(!st.isEmpty() && k>0 )
        {
            st.pop();
            k--;


        }
StringBuilder res=new StringBuilder ();
while(!st.isEmpty())
{
    res.append(st.pop());
}
res.reverse();
int id=0;
while(id<res.length() && res.charAt(id)=='0')
{
    id++;

}
StringBuilder ans=new StringBuilder(res.substring(id));
return ans.length()==0?"0":ans.toString();

        
    }
}