module half_adder_gate(A, B, S, C);
  input A, B;
  output S, C;
  
  xor(S, A, B);
  and(C, A, B);
endmodule