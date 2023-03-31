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

string Uppertolower(string s, int l) {
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
string keylen(string key, int pt) {
int temp = str_length(key);
for(int i=0; i<pt-temp; i++) {
key += key[i%temp];
}
return key;
}

string Encrypt(string pt, string key, int l) {
string table = "abcdefghijklmnopqrstuvwxyz";
string res = "";
for(int i=0; i<l; i++) {
int a = pt[i];
int b = key[i];
res += table[ ( (a-97) + (b-97) )%26 ];
}
return res;
}

string Decrypt(string cipher, string key, int l) {
string table = "abcdefghijklmnopqrstuvwxyz";
string res = "";
for(int i=0; i<l; i++) {
int a = cipher[i];
int b = key[i];
int temp = a-b;
if( temp < 0) {
temp = 26 + temp;
}
res += table[ temp ];
}
return res;
}

int main() {
string msg, key;
cout << "Enter your message: ";
cin >> msg;
cout << "Enter key: ";
cin >> key;
int l = str_length(msg);
key = keylen(key, l);
msg = Uppertolower(msg, l);
key = Uppertolower(key, l);
string cipher = Encrypt(msg, key, l);
string pt = Decrypt(cipher, key, l);
cout<< "Cipher Text: " << cipher << "\n" << "Original Text: "<< pt;
return 0;
}