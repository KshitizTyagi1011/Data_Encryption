#include <cmath>
#include <iostream>
#define ll long long int
using namespace std;
ll power(ll a, ll b, ll P){
	if (b == 1)return a;
    else return (((ll)pow(a, b)) % P);
}

int main()
{
	ll P, G, x, a, y, b, ka, kb;
	cout << "The value of P : " <<endl;
    cin>>P; 
	cout << "The value of G : " <<endl;
    cin>>G;
	cout << "The private key a for Sender : " <<endl;
    cin>>a;

	x = power(G, a, P); 
	cout << "The private key b for Receiver : " <<endl;
    cin>>b;
	y = power(G, b, P);
	ka = power(y, a, P); 
	kb = power(x, b, P);
	cout << "Secret key for the Sender is : " << ka << endl;

	cout << "Secret key for the Receiver is : " << kb << endl;
	return 0;
}

