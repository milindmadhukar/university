module boolean_sop_gate(A, B, C, D, Out);
  input A, B, C, D;
  output Out;
  
  wire Anot, Bnot, Cnot, Dnot, w1, w2, w3;
  
  not(Anot, A);
  not(Bnot, B);
  not(Cnot, C);
  not(Dnot, D);
  
  and(w1, Bnot, Dnot);
  and(w2, Anot, Dnot);
  and(w3, Anot, B, Cnot);
  
  or(Out, w1, w2, w3);
endmodule