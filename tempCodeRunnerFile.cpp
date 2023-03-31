#include <iostream>
#include<string>
using namespace std;

int str_length(string s) {
int c = 0;
while(s[c]) {
c++;
}
return c;
}

string UpperToLower(string s, int l) {
string res = "";
for(int i=0; i<l; i++) {
int temp = s[i];
if( 65<=temp && temp<=90) {
temp += 32;
}
res += temp;
}
return res;
}
string Encrypt(string pt, int key, int l) {
string table = "abcdefghijklmnopqrstuvwxyz";
string res = "";
for(int i=0; i<l; i++) {
int a = pt[i];
int temp = ( (a-97) + key )%26;
res += table[ temp ];
}
return res;
}
string Decrypt(string cipher, int key, int l) {
string table = "abcdefghijklmnopqrstuvwxyz";
string res = "";
for(int i=0; i<l; i++) {
int a = cipher[i];
int temp = a-97-key;
if( temp < 0) {
temp = 26 - (abs(temp) % 26);
}
res += table[ temp%26 ];
}
return res;
}
int main() {
string msg;
int key;
cout << "Enter your message : ";
cin >> msg;
cout << "Enter key : ";
cin >> key;
int l = str_length(msg);
msg = UpperToLower(msg, l);
string cipher = Encrypt(msg, key, l);
string pt = Decrypt(cipher, key, l);
cout<< "Cipher text: " << cipher << "\n" <<"Original text: "<< pt;
return 0;
}