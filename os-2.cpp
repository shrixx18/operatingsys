#include <iostream>
using namespace std;
void findavgtime(int p[], int bt[], int n)
{

    int ct[3];
    int tat[3];
    int wt[3];
    float twt = 0;

    ct[0] = bt[0];
    for (int i = 1; i < n; i++)
    {
        ct[i] = bt[i] + ct[i - 1];
    }
    for (int i = 0; i < n; i++)
    {
        tat[i] = ct[i] - 0;
    }
    for (int i = 0; i < n; i++)
    {
        wt[i] = tat[i] - bt[i];
    }
    for (int i = 0; i < n; i++)
    {
        twt = twt + wt[i];
    }

    cout << (twt / 3);
}

int main()
{
    int proccess[] = {2, 3, 4};
    int burst_time[]{3, 2, 6};
    int n;
    n = 3;
    findavgtime(proccess, burst_time, n);
    return 0;
}