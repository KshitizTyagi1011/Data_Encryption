// C++ algorithm for above approach
#include <bits/stdc++.h>
using namespace std;

// Function to find
// maximum value of atmost two
// non-overlapping intervals
int maxTwoNonOverLapping(vector<vector<int> >& interval)
{

	// Sorting the given array
	// on the basis of startTime
	sort(interval.begin(), interval.end(),
		[](vector<int>& a, vector<int>& b) {
			return (a[0] == b[0]) ? a[1] < b[1]
								: a[0] < b[0];
		});

	// Initializing Priority Queue
	// which stores endTime
	// and value and sort
	// on the basis of endTime
	priority_queue<vector<int> > pq;

	// Initializing max
	// and ans variables
	int ma = 0;
	int ans = 0;

	// Traversing the given array
	for (auto e : interval) {
		while (!pq.empty()) {

			// If endTime from priority
			// queue is greater
			// than startTime of
			// traversing interval
			// then break the loop
			if (pq.top()[0] >= e[0])
				break;
			vector<int> qu = pq.top();
			pq.pop();

			// Updating max variable
			ma = max(ma, qu[1]);
		}

		// Updating ans variable
		ans = max(ans, ma + e[2]);
		pq.push({ e[1], e[2] });
	}

	// Returning ans
	return ans;
}

// Driver Code
int main()
{
	vector<vector<int> > interval
		= { { 5, 9, 25 }, { 2, 6, 22 }, { 6, 22, 40 }, { 9, 15, 39 } };
	int maxValue = maxTwoNonOverLapping(interval);
	cout << maxValue;

	return 0;
}

	// This code is contributed by rakeshsahni
