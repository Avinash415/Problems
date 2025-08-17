class Solution {
public:
    bool isValid(string s) {
        stack <int> st;
        for(char a : s){
            if(a == '(' || a == '[' || a == '{' ){
                st.push(a);
            }
            else{
                if(st.empty()) return false;
                char x = st.top();
                st.pop();
                if(a == ')' && x == '(') continue;
                else if(a == ']' && x == '[') continue;
                else if(a == '}' && x == '{') continue;
                else{
                    return false;
                }
            }
        }
        return st.empty();
    }
};