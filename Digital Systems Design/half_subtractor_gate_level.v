module half_subtractor_gate(A, B, D, Bo);
  input A, B;
  output D, Bo;
  wire Anot;
  
  not(Anot, A);
  xor(D, A, B);
  and(Bo, Anot, B);
endmodule
