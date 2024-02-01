module half_subtractor_data(A, B, D, Bo);
  input A, B;
  output D, Bo;
  
  assign D = A ^ B;
  assign Bo = ~A & B;
endmodule

