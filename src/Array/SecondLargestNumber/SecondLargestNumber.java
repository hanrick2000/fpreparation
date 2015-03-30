package Array.SecondLargestNumber;

public class SecondLargestNumber {

	/*
	 * Algorithm:
int second_largest(const vector<int>& arr) {
    if(arr.size() < 2) return INT_MIN;
    int second_max = arr[0], max_val = arr[0];
    
    for(size_t i = 1; i < arr.size(); ++i) {
        if(arr[i] > max_val) {
            second_max = max_val;
            max_val = arr[i];
        } else if(arr[i] > second_max && arr[i] != max_val) {
            second_max = arr[i];
        }
    }
    return second_max;
}
	 */
	
}
