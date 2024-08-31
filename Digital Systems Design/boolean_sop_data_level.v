module boolean_sop_data(A, B, C, D, Out);
  input A, B, C, D;
  output Out;
  
  assign Out = (~B & ~D) | (~A & ~D) | (~A & B & ~C);
endmodule
