module full_adder_data(A, B, Cin, S, C);
  input A, B, Cin;
  output S, C;
  
  assign S = (A ^ B) ^ Cin;
  assign C = ((A ^ B) & Cin) | (A & B);
endmodule

