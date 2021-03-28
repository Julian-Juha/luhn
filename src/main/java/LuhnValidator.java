import java.util.ArrayList;
import java.util.List;

class LuhnValidator {

    boolean isValid(String candidate) {

        candidate = "0" + candidate;
        candidate = candidate.replaceAll("\\s+", "");
        List<Integer> list = new ArrayList<>();

        for (char c : candidate.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        if ((candidate.length() <= 2)) {
            return false;
        }

        // to int list
        for (int i = 0; i < candidate.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(candidate.charAt(i))));
        }

        // double every 2nd
        int neu = 0;
        for (int i = list.size() - 2; i > 0; i = i - 2) {
            neu = list.get(i) * 2;
            if (neu > 9) {
                neu -= 9;
            }
            list.set(i, neu);
        }

        // check sum
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return (sum % 10) == 0;
    }

}
