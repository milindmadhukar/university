module boolean_pos_data(A, B, C, D, Out);
  input A, B, C, D;
  output Out;
  
  assign Out = (~C | ~D) & (~A | ~B) & (B | ~D);
endmodule