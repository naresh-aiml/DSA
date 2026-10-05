class Solution {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        Node() { for(int i=0; i<26; i++) children[i]=null; }
    }
    static Node root = new Node();
    static String ans = "";

    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null) curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static void dfs(Node curr, StringBuilder temp) {
        for(int i=0; i<26; i++) {
            if(curr.children[i]!=null && curr.children[i].eow==true) {
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                dfs(curr.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public String longestWord(String[] words) {
        root = new Node();
        ans = "";
        for(String w: words) insert(w);
        Node curr = root;
        dfs(curr, new StringBuilder(""));
        return ans;
    }
}