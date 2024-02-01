module bcd_to_excess_3(A, B, C, D, W, X, Y, Z);
  input A, B, C, D;
  output W, X, Y, Z;
  reg W, X, Y, Z;
  
  always @ (A, B, C, D)
  begin
    W = A | B&D | B&C;
    X = B & ~C & ~D | ~B & D | ~B & C;
    Y = C&D | ~C&~D;
    Z = ~D;
  end
endmodule

module bcd_to_excess_3_tb;
  wire W, X, Y, Z;
  reg A, B, C, D;
  
 bcd_to_excess_3 tb(A, B, C, D, W, X, Y, Z);
 
 initial
 begin
       A = 0; B = 0; C = 0; D = 0;
   #10 A = 0; B = 0; C = 0; D = 1;
   #10 A = 0; B = 0; C = 1; D = 0;
   #10 A = 0; B = 0; C = 1; D = 1;
   #10 A = 0; B = 1; C = 0; D = 0;
   #10 A = 0; B = 1; C = 0; D = 1;
   #10 A = 0; B = 1; C = 1; D = 0;
   #10 A = 0; B = 1; C = 1; D = 1;
   #10 A = 1; B = 0; C = 0; D = 0;
   #10 A = 1; B = 0; C = 0; D = 1;
 end
 
 initial #100 $finish;
endmodule
  
