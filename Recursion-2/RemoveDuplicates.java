public class RemoveDuplicates {
    public static void removeDuplicate(String str, int idx, StringBuilder newstr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newstr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            removeDuplicate(str, idx + 1, newstr, map);
        } else {
            map[currChar - 'a'] = true;
            newstr.append(currChar);
            removeDuplicate(str, idx + 1, newstr, map);
        }
    }

    public static void main(String[] args) {
        String str = "appnnacollege";
        boolean map[] = new boolean[26];
        removeDuplicate(str, 0, new StringBuilder(""), map);
    }
}
