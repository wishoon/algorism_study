package v2.Programmers;

import java.util.HashMap;
import java.util.Map;

public class 가사_검색 {
    /**
     * 1. Trie 구조를 만든다.
     * 2. 정방향, 역뱡향 구조로 2개를 만든다
     * 3. queries가 ?가 먼저 오는지 아닌지를 체크한다.
     * 4. ?가 몇개인지와
     * */
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie[] trie = new Trie[10001];

        for (String word : words) {
            int len = word.length();
            if(trie[len] == null)
                trie[len] = new Trie();
            trie[len].insert(word);
        }

        for (int i = 0; i < queries.length; i++) {
            int queryLen = queries[i].length();

            if(trie[queryLen] == null) {
                answer[i] = 0;
                continue;
            }
            answer[i] = trie[queryLen].getCount(queries[i]);
        }
        return answer;
    }

    static class Trie {
        TrieNode forward;
        TrieNode backword;

        public Trie() {
            forward = new TrieNode();
            backword = new TrieNode();
        }

        public void insert(String word) {
            insertForword(word);
            insertBackword(word);
        }

        public void insertForword(String word) {
            TrieNode node = forward;
            for (int i = 0; i < word.length(); i++) {
                node.count++;
                if(!node.childsNodes.containsKey(word.charAt(i)))
                    node.childsNodes.put(word.charAt(i), new TrieNode());

                node = node.childsNodes.get(word.charAt(i));
            }
        }

        public void insertBackword(String word) {
            TrieNode node = backword;
            for (int i = word.length() - 1; i >= 0; i--) {
                node.count++;
                if(!node.childsNodes.containsKey(word.charAt(i)))
                    node.childsNodes.put(word.charAt(i), new TrieNode());

                node = node.childsNodes.get(word.charAt(i));
            }
        }

        public int getCount(String query) {
            if(query.charAt(0) == '?') {
                return getCountBack(query);
            }
            return getCountFoward(query);
        }

        private int getCountBack(String query) {
            TrieNode node = backword;

            for (int i = query.length() - 1; i >= 0 ; i--) {
                if(query.charAt(i) == '?')
                    return node.count;

                if(!node.childsNodes.containsKey(query.charAt(i)))
                    return 0;

                node = node.childsNodes.get(query.charAt(i));
            }

            return node.count;
        }

        private int getCountFoward(String query) {
            TrieNode node = forward;

            for (int i = 0; i < query.length(); i++) {
                if(query.charAt(i) == '?')
                    return node.count;

                if(!node.childsNodes.containsKey(query.charAt(i)))
                    return 0;

                node = node.childsNodes.get(query.charAt(i));
            }

            return node.count;
        }
    }

    static class TrieNode {
        int count;
        Map<Character, TrieNode> childsNodes;

        public TrieNode() {
            count = 0;
            childsNodes = new HashMap<Character, TrieNode>();
        }
    }
}
