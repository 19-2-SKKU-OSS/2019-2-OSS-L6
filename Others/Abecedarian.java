package Others;

/**
 * An Abecadrian is a word where each letter is in alphabetical order
 * Abecedarian 알고리즘: 문자열이 알파벳 순이면 true, 그것이 아니면 false를 반환하는 알고리즘.
 * @author Oskar Enmalm
 */
class Abecedarian {

    public static boolean isAbecedarian(String s) {
     	    int index = s.length() - 1;

        for (int i = 0; i < index; i++) {

            if (s.charAt(i) <= s.charAt(i + 1)) { //전의 알파벳이 뒤의 알파벳의 아스키 코드보다 작으면 다음 알파벳 검사
            } //Need to check if each letter for the whole word is less than the one before it

            else {
                return false; //그렇지 않으면 바로 false 리턴
            }
        }
        return true; // 모든 알파벳이 알파벳 순이면 true 리턴
    }
}
