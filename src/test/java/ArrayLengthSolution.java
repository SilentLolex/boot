import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayLengthSolution {
    public static void main(String[] args) {
        int[] arr = {0};
        int difference = -5;

        //System.out.println(getSubArrayLength(arr, difference));
        // System.out.println(getNum(arr));
        System.out.println(getHint("01101","01110"));
    }

    /**
     * 1 <= arr.length <= 10^5
     * -10^4 <= arr[i]; difference < 10^4
     */
    private static int getSubArrayLength(int[] arr, int difference) {
        int arrLength = arr.length;
        int result = 1;
        for (int i = 0; i < arrLength; i++) {
            int testResult = 1;
            int nextTarget = arr[i] + difference;
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[j] == nextTarget) {
                    nextTarget += difference;
                    testResult++;
                }
            }
            if (result < testResult) {
                result = testResult;
            }
        }
        return result;
    }


    private static int getNum(int[] nums) {
        int sum = nums.length * (nums.length - 1) / 2 + nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static String getHint(String secret, String guess) {
        int bnum = 0;
        Set<Integer> bullNumIndex = new HashSet();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullNumIndex.add(i);
            }
        }
        Map<String,Integer> fromIndexMap = new HashMap();
        for (int i = 0; i < secret.length(); i++) {
            if (bullNumIndex.contains(i)) {
                continue;
            }
            int fromIndex = 0;
            String cowKey = String.valueOf(guess.charAt(i));
            fromIndex = fromIndexMap.get(cowKey) == null ? 0 : fromIndexMap.get(cowKey);
            for (; fromIndex < secret.length();) {
                int indexOfCowNum = secret.indexOf(cowKey, fromIndex);
                if (indexOfCowNum > -1) {
                    if (!bullNumIndex.contains(indexOfCowNum)) {
                        bnum++;
                        fromIndexMap.put(cowKey, indexOfCowNum + 1);
                        break;
                    }
                    fromIndex ++;
                }else {
                    break;
                }

            }
        }
        return bullNumIndex.size() + "A" + bnum + "B";
    }

    public int findMinStep(String board, String hand) {
        String[] boardArr = board.split("");
        String[] handArr = hand.split("");

        for (int i = 0; i < boardArr.length; i++) {
            //boardArr[i];
        }



        return  -1;
    }


}
