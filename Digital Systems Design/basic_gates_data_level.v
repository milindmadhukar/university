
module basic_gates_data(A, B, AndOut, OrOut, NotOut, XorOut, NandOut, NorOut, XnorOut);
  input A, B;
  output AndOut, OrOut, NotOut, XorOut, NandOut, NorOut, XnorOut;
  
  assign AndOut = A & B;
  assign OrOut = A | B;
  assign NotOut = ~A;
  assign XorOut = A ^ B;
  assign NandOut = ~(A & B);
  assign NorOut = ~(A | B);
  assign XnorOut = ~(A ^ B);
endmodule

