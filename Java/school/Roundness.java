class Roundness {
    public static void main(String[] args) {
        int s[][] = {{0,0,1,1,0,1},
                    {0,1,1,1,1,0},
                    {0,1,1,0,1,0},
                    {0,0,0,0,0,0}};
        Roundness obj = new Roundness(); 
        System.out.print(obj.roundness(s));
    }
    double roundness(int s[][]){
        int area = 0;
        for(int r[]:s){
                for(int c:r){
                    if(c == 1)
                        area += 1
                }
        }
    }
}