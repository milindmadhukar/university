module encoder_data(Y0, Y1, Y2, Y3, Y4, Y5, Y6, Y7, A0, A1, A2);
  input Y0, Y1, Y2, Y3, Y4, Y5, Y6, Y7;
  output A0, A1, A2;
  
  assign A0 = Y4 | Y5 | Y6 | Y7;
  assign A1 = Y2 | Y3 | Y6 | Y7;
  assign A2 = Y1 | Y3 | Y5 | Y7; 
  
endmodule

