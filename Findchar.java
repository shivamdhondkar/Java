class Findchar {
    static char extraChar(String s1, String s2) {
        int result = 0;

        for (int i = 0; i < s1.length(); i++) {
            result ^= s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            result ^= s2.charAt(i);
        }

        return (char) result;
    }

    public static void main(String args[]) {
        String s1 = "aty";
        String s2 = "faty";
        System.out.println(extraChar(s1, s2)); // Output: f
    }
}
