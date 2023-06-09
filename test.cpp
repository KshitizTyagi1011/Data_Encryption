#include<iostream>
#include<bits/stdc++.h>
using namespace std;
 int maxEvents(vector<vector<int>> events) {
    //  for (vector<int> vect1D : events)
    // {
    //     for (int x : vect1D)
    //     {
    //         cout << x << " ";
    //     }    
    //     cout << endl;
    // }
      int res=0;
        int m=0;
        for(auto x:events)
            m=max(m,x[1]);
        
        sort(events.begin(),events.end());
        int j=0;
        priority_queue<int,vector<int>,greater<int>> pq;
        for(int i=1;i<=m;i++)
        {
            while(!pq.empty() && pq.top()<i)// end day is less than the current day
                pq.pop();
            
            while(j<events.size() && events[j][0]==i)// put all events start at day i
                pq.push(events[j++][1]);
            
            if(!pq.empty())// we can attend an event today
            {
                pq.pop();// remove the event
                res++;// count that event
            }
        }
        cout<<res;
        return res;  
    }
    int main(){
        
    vector<vector<int>> vect
    {
        {5, 9, 25},
        {2, 6, 22},
        {6, 22, 40},
        {9, 15, 39}
    };

    return maxEvents(vect);

    }