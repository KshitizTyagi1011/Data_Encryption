import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

class hash{
static String modified_hash(String hash){
String modified = "";
char c;

for (int i = 0; i < hash.length(); i++) {
if(Character.isDigit(hash.charAt(i))){
int value = hash.charAt(i);
c = (char) (value%26 + 'a');
modified +=c;
}
else{

modified += hash.charAt(i);
}
}
return modified;
}
static StringBuffer key(String key, String text) {
StringBuffer sb = new StringBuffer(key);
int j = 0;
for (int i = 0; i < text.length(); i++) {
if (j >= key.length()) {
j = 0;
}
if (sb.length() < text.length()) {
sb.append(key.charAt(j));
} else {
break;
}
j++;

}

return sb;
}

static String encryption(String text, StringBuffer key) {
String cipher = "";
for (int i = 0; i < text.length(); i++) {
int x = text.charAt(i) - 97;
int y = key.charAt(i) - 97;
char c = (char) ((x + y) % 26 + 'a');
cipher += c;
}
return cipher;
}

static String decryption(String cipher, StringBuffer key) {
String plane_text = "";
for (int i = 0; i < cipher.length(); i++) {
int x = cipher.charAt(i) - 97;
int y = key.charAt(i) - 97;
int z = (x - y);
while (z < 0)
z += 26;
char c = (char) (z % 26 + 'a');
plane_text += c;
}

return plane_text;
}

public static String encryptThisString(String input)
{
try {
MessageDigest md = MessageDigest.getInstance("SHA-1");

byte[] messageDigest = md.digest(input.getBytes());

BigInteger no = new BigInteger(1, messageDigest);

String hashtext = no.toString(16);

while (hashtext.length() < 32) {
hashtext = "0" + hashtext;
}
return hashtext;
}

catch (NoSuchAlgorithmException e) {
throw new RuntimeException(e);
}
}
public static void hash_enc(){


}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter your message :");
String message = sc.next();
String hashcode = encryptThisString(message);
String table = "abcdefghijklmnopqrstuvwxyz";
int hashBool[]=new int[hashcode.length()];
String newhashCode = hashcode;
for(int i=0; i<newhashCode.length(); i++) {
    char ch = newhashCode.charAt(i);
    int temp = ch;
    if( 65 <= temp && temp <= 90 || 97<=temp && temp<=122 ) {
        hashBool[i] = 0;
    }
    else {
        int t = ch - '0';
        hashBool[i] = 1;
        newhashCode = newhashCode.substring(0, i) + table.charAt(t) + newhashCode.substring(i+1, newhashCode.length());
    }
}



String key = "enc";

System.out.println("HashCode for given message : "+hashcode);

StringBuffer new_key = key(key, message);

StringBuffer new_hash_key = key(key, hashcode);

String encrypted_message = encryption(message, new_key);
String encrypted_hash_code = encryption(newhashCode, new_hash_key);


String decrypted_message = decryption(encrypted_message, new_key);
String decrypted_hash_code = decryption(encrypted_hash_code, new_hash_key);



for(int i=0; i<hashBool.length; i++) {
    
    if( hashBool[i] == 1 ) {
        char ch = decrypted_hash_code.charAt(i);
        int temp = ch - 'a';
        decrypted_hash_code = decrypted_hash_code.substring(0, i) + String.valueOf(temp) + decrypted_hash_code.substring(i+1, decrypted_hash_code.length());
    }
}

System.out.println("After Encryption :- \n Message :  "+encrypted_message + "\nHash Code : " + encrypted_hash_code);
System.out.println("After Decryption :- \n Message :  "+decrypted_message + "\nHash Code : " + decrypted_hash_code);


int check = 1;
for(int i=0; i<decrypted_hash_code.length(); i++) {
    if( decrypted_hash_code.charAt(i) != hashcode.charAt(i) ) {
        check = 0;
        break;
    }
}
if(check == 1) {
    System.out.println("HASH CODE SAME");
}
else{
    System.out.println("HASH CODE DIFFERENT");
}
}
}