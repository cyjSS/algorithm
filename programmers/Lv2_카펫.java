class Lv2_카펫 {
    public int[] solution(int brown, int yellow) {
        int multi = brown + yellow;
        int plus = (brown + 4)/2;
        int[] answer = new int[2];
        answer[0] = (plus+(int)Math.sqrt(Math.pow(plus,2)-(4*multi)))/2;
        answer[1] = (plus-(int)Math.sqrt(Math.pow(plus,2)-(4*multi)))/2;
        return answer;
    }
}