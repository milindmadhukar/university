module full_adder_decoder_data(A, B, Cin, S, C);
  input A, B, Cin;
  output S, C;
  wire D0, D1, D2, D3, D4, D5, D6, D7;
  
  assign D0 = ~A & ~B & ~Cin;
  assign D1 = ~A & ~B & Cin;
  assign D2 = ~A & B & ~Cin;
  assign D3 = ~A & B & Cin;
  assign D4 = A & ~B & ~Cin;
  assign D5 = A & ~B & Cin;
  assign D6 = A & B & ~Cin;
  assign D7 = A & B & Cin;
  

  
  assign S = D1 | D2 | D4 | D7;
  assign C = D3 | D5 | D6 | D7;
endmodule

