package Easy;

/**
 * Created by ESK on 7/12/17.
 */
public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int temp = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++)
    {
      if (nums[i] == 1)
      {
        temp++;
        max = Math.max(temp, max);
      }
      else
        temp = 0;
    }

    return max;
  }
}
