module decoder_behavioural(A, B, D0, D1, D2, D3);  
  input A, B;
  output D0, D1, D2, D3;
  reg D0, D1, D2, D3;
  
  always @ (A, B)
  begin
    D0 = ~A & ~B;
    D1 = ~A & B;
    D2 = A & ~B;
    D3 = A & B;
  end
endmodule

module decoder_tb;
  wire D0, D1, D2, D3;
  reg A, B;
  
  decoder_behavioural tb(A, B, D0, D1, D2, D3);
  
  initial
  begin
        A = 0; B = 0;
    #10 A = 0; B = 1;
    #10 A = 1; B = 0;
    #10 A = 1; B = 1;
  end
  
  initial #40 $finish;
  
endmodule
