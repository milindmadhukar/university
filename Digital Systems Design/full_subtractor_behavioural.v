module full_subtractor_behavioural(A, B, Bin, D, Bout);
  input A, B, Bin;
  output D, Bout;
  reg D, Bout;
  
  always @ (A, B, Bin)
  begin
    D = A ^ B ^ Bin;
    Bout = (~A & B) | ( ~(A ^ B) &  Bin);
  end
endmodule

module full_subtractor_behavioural_tb;
  wire D, Bout;
  reg A, B, Bin;
  
  full_subtractor_behavioural tb(A, B, Bin, D, Bout);
  
  initial
  begin
        A = 0; B = 0; Bin = 0;
    #10 A = 0; B = 0; Bin = 1;
    #10 A = 0; B = 1; Bin = 0;
    #10 A = 0; B = 1; Bin = 1;
    #10 A = 1; B = 0; Bin = 0;
    #10 A = 1; B = 0; Bin = 1;
    #10 A = 1; B = 1; Bin = 0;
    #10 A = 1; B = 1; Bin = 1;
    #80 $finish;
  end
endmodule