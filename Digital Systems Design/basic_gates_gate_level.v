module basic_gates_gate(A, B, AndOut, OrOut, NotOut, XorOut, NandOut, NorOut, XnorOut);
  input A, B;
  output AndOut, OrOut, NotOut, XorOut, NandOut, NorOut, XnorOut;
  
  and(AndOut, A, B);
  or(OrOut, A, B);
  not(NotOut, A);
  xor(XorOut, A, B);
  nand(NandOut, A, B);
  nor(NorOut, A, B);
  xnor(XnorOut, A, B);
endmodule
