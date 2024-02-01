module full_adder_decoder_gate(A, B, Cin, S, C);
  input A, B, Cin;
  output S, C;
  wire ANot, BNot, CinNot, D0, D1, D2, D3, D4, D5, D6, D7;
  
  not(ANot, A);
  not(BNot, B);
  not(CinNot, Cin);
  
  and(D0, ANot, BNot, CinNot);
  and(D1, ANot, BNot, Cin);
  and(D2, ANot, B, CinNot);
  and(D3, ANot, B, Cin);
  and(D4, A, BNot, CinNot);
  and(D5, A, BNot, Cin);
  and(D6, A, B, CinNot);
  and(D7, A, B, Cin);
  
  or(S, D1, D2, D4, D7);
  or(C, D3, D5, D6, D7);
endmodule
