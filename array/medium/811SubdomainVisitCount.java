class Solution {
    public List<String> subdomainVisits(String[] arr) {

        int n = arr.length;
        HashMap<String,Integer> hp = new HashMap<>();

        for(int k=0; k<n; k++) {
            String num[] = arr[k].split(" ");

            StringBuilder s = new StringBuilder(num[1]);

            while (s.length() != 0) {
                int a = s.indexOf(".");
                hp.put(s.toString(), hp.getOrDefault(s.toString(), 0) + Integer.valueOf(num[0]));
                if(a==-1) break;
                s.delete(0,a+1);
            }
        }

        List<String> ans = new ArrayList<>();

        for(String a : hp.keySet()){
            StringBuilder x = new StringBuilder("");
            x.append(String.valueOf(hp.get(a))+" ");
            x.append(a);
            ans.add(x.toString());
        }   

        return ans;
    }
}