#include<iostream>
#include<string.h>
using namespace std;
int main()
{
int i,j,k,l;
char a[100],c[100],d[100];
cout<<"\nEnter the Plaintext: ";
gets(a);
l=strlen(a);

for(i=0,j=0;i<l;i++)
{
if(i%2==0)
c[j++]=a[i];
}
for(i=0;i<l;i++)
{
if(i%2==1)
c[j++]=a[i];
}
c[j]='\0';
cout<<"\nEncryption: "<<c;

if(l%2==0)
k=l/2;
else
k=(l/2)+1;
for(i=0,j=0;i<k;i++)
{
d[j]=c[i];
j=j+2;
}
for(i=k,j=1;i<l;i++)
{
d[j]=c[i];
j=j+2;
}
d[l]='\0';

cout<<"\nDecryption: "<<d;
}