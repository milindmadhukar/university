module full_subtractor_gate(A, B, Bin, D, Bout);
  input A, B, Bin;
  output D, Bout;
  wire w1, w2, w3, w4, w5;
  
  not(w2, A);
  xor(w1, A, B);
  and(w3, w2, B);
  not(w4, w1);
  and(w5, Bin, w4);
  
  xor(D, w1, Bin);
  or(Bout, w3, w5);
endmodule
