import java.util.*; 
class DES{
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("\nTHE 64-BIT ARRY IS = ");
    int pc[]={1,0,1,1,1,1,0,0,0,0,1,1,0,1,0,1,0,1,0,1,1,0,0,0,1,1,0,1,0,0,1,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0, 1,1,0,0,1,0,0,1,1,0,0,1,0,1,0,0,1,1};
    for(int i=0;i<64;i++){
        System.out.print(pc[i]+" ");
    }
        System.out.println("\n========================================");
        System.out.println("AFTER PASSING THROUGH PC-1 TABLE = ");
        int pc1[]=new int[56];
        int sp1[]=new int[28];
        int sp2[]=new int[28];
        int fin[]=new int[56]; 
        int fin2[]=new int[48];
        int com[] ={57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
        for(int i=0;i<com.length;i++){
             pc1[i]=pc[com[i]];
        }
        for(int i=0;i<56;i++){ 
            System.out.print(pc1[i]+" ");
        }
        System.out.println("\n========================================");
        System.out.println("SPLITTING IN 28-BITS EACH = ");
        for(int i=0;i<28;i++){
            sp1[i]=pc1[i];
        } 
        int k=0;
        for(int i=28;i<56;i++){ 
            sp2[k]=pc1[i];
            k++;
        }
        for(int i=0;i<28;i++){ 
            System.out.print(sp1[i]+" ");
        }
        System.out.println("\n========================================");
        for(int i=0;i<28;i++){ 
            System.out.print(sp2[i]+" ");
        }
        System.out.println("\n========================================");
        int sp1last=sp1[0];
        for(int i=0;i<sp1.length;i++){ 
            if(i==27)
                sp1[27]=sp1last;
             else sp1[i]=sp1[i+1];
             } 
        int sp2last=sp2[0];
        for(int i=0;i<sp2.length;i++){ 
            if(i==27)       
            sp2[27]=sp2last;
            else 
            sp2[i]=sp2[i+1];
        }
        for(int i=0;i<28;i++){ 
            System.out.print(sp1[i]+" ");
        }
        System.out.println("\n========================================"); 
        System.out.println("BOTH LEFT AND RIGHT SIDES AFTER LEFT SHIFT = ");
        for(int i=0;i<28;i++){
            System.out.print(sp2[i]+" ");
        } 
        for(int i=0;i<sp1.length;i++){ 
            fin[i]=sp1[i];
        }
        System.out.println("\n========================================");
        System.out.println("COMBINING BOTH THE LEFT AND RIGHT SIDES = ");
        int j=28;
        for(int i=0;i<sp2.length;i++){
            fin[j]=sp2[i];
            j++;
        }
        for(int i=0;i<56;i++){ 
            System.out.print(fin[i]+" "); 
        }
        System.out.println("\n========================================");
        System.out.println("AFTER PASSING THROUGH PC-2 TABLE = ");
        int com2[]={28,11,35,6,21,42,39,12,40,22,2,36,16,48,29,3,44,19,30,8,10,43,31,38,47,17,5,32,1,37,23,18,46,14,24,45,9,27,34,13,41,26,15,4,33,20,25,7};
        for(int i=0;i<fin2.length;i++) {
             fin2[i]=fin[com2[i]]; 
        }
        for(int i=0;i<fin2.length;i++){ 
            System.out.print(fin2[i]+" "); 
        }
        System.out.println("\n========================================");
        System.out.println("==========================================");
    }
}