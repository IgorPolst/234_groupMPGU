
public class Laba_3 {

    public static void main(String[] args) {

    }

//String
    public String helloName(String name) {
        return "Hello " + name + "!";
    }

    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    public String makeTags(String tag, String word) {
        return String.format("<%s>%s</%s>", tag, word, tag);
    }

    public String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }

    public String extraEnd(String str) {
        if (str.length() > 2) {
            String lastTwoSimbl = str.substring(str.length() - 2);
            return lastTwoSimbl + lastTwoSimbl + lastTwoSimbl;
        } else {
            return str + str + str;
        }
    }

    public String firstTwo(String str) {
        if (str.length() <= 2) {
            return str;
        } else {
            return str.substring(0, 2);
        }
    }

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    public String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);
    }

    public String comboString(String a, String b) {
        if (a.length() > b.length()) {
            return b + a + b;
        } else {
            return a + b + a;
        }
    }

    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }

    public String left2(String str) {
        return str.substring(2) + str.substring(0, 2);
    }

    public String right2(String str) {
        return str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
    }

    public String theEnd(String str, boolean front) {
        if (front) {
            return str.substring(0, 1);
        } else {
            return str.substring(str.length() - 1);
        }
    }

    public String withouEnd2(String str) {
        if (str.length() > 1) {
            return str.substring(1, str.length() - 1);
        } else {
            return "";
        }
    }

    public String middleTwo(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
    }

    public boolean endsLy(String str) {
        return (str.length() > 1 && str.substring(str.length() - 2).equals("ly"));
    }

    public String nTwice(String str, int n) {
        return str.substring(0, n) + str.substring(str.length() - n);
    }

    public String twoChar(String str, int index) {
        if (index > str.length() - 2 || index < 0) {
            return str.substring(0, 2);
        } else {
            return str.substring(index, index + 2);
        }
    }

    public String middleThree(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 2);
    }

    public boolean hasBad(String str) {
        return (str.length() > 2 && str.substring(0, 3).equals("bad") || str.length() > 3 && str.substring(1, 4).equals("bad"));
    }

    public String atFirst(String str) {
        switch (str.length()) {
            case 0:
                return "@@";
            case 1:
                return str + "@";
            default:
                return str.substring(0, 2);
        }
    }

    public String lastChars(String a, String b) {
        if (a.length() != 0 && b.length() != 0) {
            return a.substring(0, 1) + b.substring(b.length() - 1);
        } else if (a.length() != 0 && b.length() == 0) {
            return a.substring(0, 1) + "@";
        } else if (a.length() == 0 && b.length() != 0) {
            return "@" + b.substring(b.length() - 1);
        } else {
            return "@@";
        }
    }

    public String conCat(String a, String b) {
        if (a.length() == 0 || b.length() == 0 || a.charAt(a.length() - 1) != b.charAt(0)) {
            return a + b;
        } else {
            return a.substring(0, a.length() - 1) + b;
        }
    }

    public String lastTwo(String str) {
        if (str.length() >= 2) {
            return str.substring(0, str.length() - 2) + str.charAt(str.length() - 1) + str.charAt(str.length() - 2);
        } else {
            return str;
        }
    }

    public String seeColor(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("red")) {
            return "red";
        } else if (str.length() >= 4 && str.substring(0, 4).equals("blue")) {
            return "blue";
        } else {
            return "";
        }
    }

    public boolean frontAgain(String str) {
        return (str.length() >= 2 && str.substring(0, 2).equals(str.substring(str.length() - 2)));
    }

    public String minCat(String a, String b) {
        if (a.length() > b.length()) {
            return a.substring(a.length() - b.length()) + b;
        } else if (a.length() < b.length()) {
            return a + b.substring(b.length() - a.length());
        } else {
            return a + b;
        }
    }

    public String extraFront(String str) {
        if (str.length() > 2) {
            String twoChar = str.substring(0, 2);
            return twoChar + twoChar + twoChar;
        } else {
            return str + str + str;
        }
    }

    public String without2(String str) {
        if (str.length() >= 2 && str.substring(0, 2).equals(str.substring(str.length() - 2))) {
            return str.substring(2);
        } else {
            return str;
        }
    }

    public String deFront(String str) {
        if (str.length() < 2 || str.substring(0, 2).equals("ab")) {
            return str;
        } else if (str.charAt(0) == 'a') {
            return "a" + str.substring(2);
        } else if (str.charAt(1) == 'b') {
            return "b" + str.substring(2);
        } else {
            return str.substring(2);
        }
    }

//Array
    public boolean firstLast6(int[] nums) {
        return (nums[0] == 6 || nums[nums.length - 1] == 6);
    }

    public boolean sameFirstLast(int[] nums) {
        return (nums.length >= 1 && nums[0] == nums[nums.length - 1]);
    }

    public int[] makePi() {
        int[] array = {3, 1, 4};
        return array;
    }

    public boolean commonEnd(int[] a, int[] b) {
        return (a[0] == b[0] || a[a.length - 1] == b[b.length - 1]);
    }

    public int sum3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int[] rotateLeft3(int[] nums) {
        int temp = nums[0];
        for (int i = 0; i < 2; i++) {
            nums[i] = nums[i + 1];
        }
        nums[2] = temp;
        return nums;
    }

    public int[] reverse3(int[] nums) {
        int[] reversNums = new int[3];

        for (int i = 2; i >= 0; i--) {
            reversNums[2 - i] = nums[i];
        }
        return reversNums;
    }

    public int[] maxEnd3(int[] nums) {
        int max;

        if (nums[0] > nums[2]) {
            max = nums[0];
        } else {
            max = nums[2];
        }

        for (int i = 0; i < 3; i++) {
            nums[i] = max;
        }
        return nums;
    }

    public int sum2(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 0) {
            return 0;
        } else {
            return nums[0] + nums[1];
        }
    }

    public int[] middleWay(int[] a, int[] b) {
        int[] midle = {a[1], b[1]};
        return midle;
    }

    public int[] makeEnds(int[] nums) {
        int[] sf = {nums[0], nums[nums.length - 1]};
        return sf;
    }

    public boolean has23(int[] nums) {
        return (nums[0] == 2 || nums[1] == 2 || nums[0] == 3 || nums[1] == 3);
    }

    public boolean no23(int[] nums) {
        for (int i = 0; i < 2; i++) {
            if (nums[i] == 2 || nums[i] == 3) {
                return false;
            }
        }
        return true;
    }

    public int[] makeLast(int[] nums) {
        int[] mass = new int[nums.length * 2];
        mass[nums.length * 2 - 1] = nums[nums.length - 1];
        return mass;
    }

    public boolean double23(int[] nums) {
        if (nums.length < 2) {
            return false;
        } else if (nums[0] == nums[1] && (nums[0] == 2 || nums[0] == 3)) {
            return true;
        } else {
            return false;
        }
    }

    public int[] fix23(int[] nums) {
        for (int i = 0; i < 2; i++) {
            if (nums[i] == 2 && nums[i + 1] == 3) {
                nums[i + 1] = 0;
            }
        }

        return nums;
    }

}
