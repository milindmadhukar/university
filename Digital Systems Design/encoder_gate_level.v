module encoder_gate(Y0, Y1, Y2, Y3, Y4, Y5, Y6, Y7, A0, A1, A2);
  input Y0, Y1, Y2, Y3, Y4, Y5, Y6, Y7;
  output A0, A1, A2;
  
  or(A0, Y4, Y5, Y6, Y7);
  or(A1, Y2, Y3, Y6, Y7);
  or(A2, Y1, Y3, Y5, Y7);
endmodule
