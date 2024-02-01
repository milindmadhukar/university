module full_adder_gate(A, B, Cin, S, C);
  input A, B, Cin;
  output S, C;
  wire w1, w2, w3;
  
  xor(w1, A, B);
  and(w2, w1, Cin);
  and(w3, A, B);
  
  xor(S, Cin, w1);
  or(C, w2, w3);
endmodule
