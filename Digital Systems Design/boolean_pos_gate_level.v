
module boolean_pos_gate(A, B, C, D, Out);
  input A, B, C, D;
  output Out;
  
  wire Anot, Bnot, Cnot, Dnot, w1, w2, w3;
  
  not(Anot, A);
  not(Bnot, B);
  not(Cnot, C);
  not(Dnot, D);
  
  or(w1, Cnot, Dnot);
  or(w2, Anot, Bnot);
  or(w3, B, Dnot);
  
  and(Out, w1, w2, w3);
  
endmodule
