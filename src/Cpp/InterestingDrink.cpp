#include <iostream>
    #include<stdio.h>
    #include<algorithm>
    using namespace std;
    
    
    int EF(int arr[], int len, int num)// slightly modified half
    {
        int left=1;
            int right=len;
            int mid;
            int ans;
            while(left<=right)
            {
                mid=(left+right)/2;
                if(arr[mid]<=num)
                {
                    ans=mid;
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
        return ans;// returns the index finally found
    }
    
    int main()
    {
        int n,q,m;
        int a[100001],b;
       scanf("%d",&n);
        for(int i=1;i<=n;i++)
        {
            scanf("%d",&a[i]);
        }
        sort(a+1,a+n+1);
        scanf("%d",&q);
        for(int i=0;i<q;i++)
        {
            m=0;
            int mins,maxs,mid;
            mins=1;maxs=n;
            scanf("%d",&b);
            if(b<a[1])
                m=0;
            else if(b>=a[n])
                m=n;
            else
                m=EF(a,n,b);
            printf("%d\n",m);
        }
    }
