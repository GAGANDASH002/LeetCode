class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> consonants = new HashMap<>();

        for(String word: wordlist){
            exact.add(word);
            caseInsensitive.putIfAbsent(word.toLowerCase(), word);
            consonants.putIfAbsent(deVowel(word.toLowerCase()), word);
        }

        String[] result = new String[queries.length];
        int i = 0;
        for(String query: queries){
            if(exact.contains(query)){
                result[i] = query;
            }
            else if(caseInsensitive.containsKey(query.toLowerCase())){
                result[i] = caseInsensitive.get(query.toLowerCase());
            }
            else if(consonants.containsKey(deVowel(query.toLowerCase()))){
                result[i] = consonants.get(deVowel(query.toLowerCase()));
            }
            else{
                result[i] ="";
            }
            i++;
        }
        return result;
    }

    public String deVowel(String word){
        StringBuilder sb = new StringBuilder();

        for(char c: word.toCharArray()){
            sb.append(isVowel(c) ? "*" : c);
        }

        return sb.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}