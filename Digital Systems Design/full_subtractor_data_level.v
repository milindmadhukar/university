module full_subtractor_data(A, B, Bin, D, Bout);
  input A, B, Bin;
  output D, Bout;
  
  assign D = A ^ B ^ Bin;
  assign Bout = (Bin & ~(A^B)) | (~A & B);
endmodule
