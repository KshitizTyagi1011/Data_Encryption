#include<iostream>
using namespace std;

int count(int n) {
int c=0;
while(n>0) {
c=c+1;
n=n/10;
}
return c;
}

int power(int n, int pow) {
if(pow==0) return 1;
int s=1;
while(pow>0) {
s=s*n;
pow=pow-1;
}
return s;
}

int binary_decimal(int n) {
    int i=0,s=0;
    while(n>0) {
        s=s+(n%10)*power(2,i);
        n=n/10;
        i++;
    }
return s;
}

int decimal_binary(int n){
   int rem,bin=0,prod=1;
    while(n!=0){
        rem=n%2;
        bin=bin+(prod*rem);
        n=n/2;
        prod=prod*10;
    }
    return bin;
}

int AND(int a, int b, int mc) {
int temp = mc;
int res[mc];
mc=mc-1;
while(a>0 || b>0) {
if( a%10==1 && b%10==1 ){
res[mc] = 1;
} else {
res[mc] = 0;
}
mc=mc-1;
a /= 10;
b /= 10;
}
mc = 0;
for(int i=0; i<temp; i++) {
mc = mc*10 + res[i];
}
return mc;
}

int XOR(int a, int b, int mc) {
int temp = mc;
int res[mc];
mc=mc-1;
while(a>0 || b>0) {
if( a%10 == b%10 ){
res[mc] = 0;
} else {
res[mc] = 1;
}
mc=mc-1;
a=a/10;
b=b/10;
}
mc = 0;
for(int i=0; i<temp; i++) {
mc = mc*10 + res[i];
}
return mc;
}

int OR(int a, int b, int mc) {
int temp=mc;
int res[mc];
mc=mc-1;
while(a>0 || b>0) {
if( a%10 == 0 && b%10 == 0 ){
res[mc] = 0;
} 
else {
res[mc] = 1;
}
mc=mc-1;
a=a/10;
b=b/10;
}
mc=0;
for(int i=0; i<temp; i++) {
mc=mc*10 + res[i];
}
return mc;
}

    int main(){
    int a,b;
    cout<<"Enter the first decimal number: ";
    cin>>a;
    cout<<"Enter the Second decimal number: ";
    cin>>b;
    int Binary_1=decimal_binary(a);
    int Binary_2=decimal_binary(b);
    int mc=0;
    int ac = count(Binary_1);
    int bc = count(Binary_2);
    if(ac > bc){
    mc = ac;
    }
    else{ 
    mc = bc;
    }

    int and_op=AND(Binary_1,Binary_2,mc);
    int xor_op=XOR(Binary_1,Binary_2,mc);
    int or_op=OR(Binary_1,Binary_2,mc);

    int res_1=binary_decimal(and_op);
    int res_2=binary_decimal(xor_op);
    int res_3=binary_decimal(or_op);

    cout<<endl;
    cout<<"Binary of "<<a<<": "<<Binary_1<<endl;
    cout<<"Binary of "<<b<<": "<<Binary_2<<endl;
    cout<<endl;

    cout<<"After AND operation: "<<res_1<<endl;
    cout<<"After XOR operation: "<<res_2<<endl;
    cout<<"After OR operation: "<<res_3<<endl;
    cout<<endl;
    return 0;
    }