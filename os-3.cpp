#include <iostream>
using namespace std;
void findavgtime(int p[], int bt[], int n)
{
    int tat[3], wt[3], ct[3];
    float totalat = 0, totalwt = 0;
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
        totalwt = totalwt + wt[i];
    }
    for (int i = 1; i < n; i++)
    {
        totalat = totalat + tat[i];
    }
    float avgtat = totalat / sizeof(tat);
    float avgwt = totalwt / sizeof(wt);
    cout << avgtat << "" << avgwt << endl;
}
int main()
{
    int processes[] = {0};
    int at[] = {1, 2, 3};
    int bt[] = {3, 4, 6};
    int n;
    n = sizeof(processes) / sizeof(processes[0]);
    findavgtime(processes, bt, n);
}