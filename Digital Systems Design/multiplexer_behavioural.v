module muxltiplexer_behavioural(D0, D1, D2, D3, S0, S1, Out);
  input D0, D1, D2, D3, S0, S1;
  output Out;
  reg Out;
  
  always @ (D0, D1, D2, D3, S0, S1)
  begin
    if(S0 == 0 && S1 == 0)
      Out = D0;
    else if (S0 == 1 && S1 == 0)
      Out = D1;
    else if (S0 == 0 && S1 == 1)
      Out = D2;
    else
      Out = D3;
  end
endmodule

module multiplexer_tb;
  wire Out;
  reg D0, D1, D2, D3, S0, S1;
  multiplexer_behavioural tb(D0, D1, D2, D3, S0, S1, Out);
  initial
  begin
        D0 = 1; D1 = 0; D2 = 0; D3 = 0; S0 = 0; S1 = 0;
    #10 D0 = 0; D1 = 1; D2 = 0; D3 = 0; S0 = 1; S1 = 0;
    #10 D0 = 0; D1 = 0; D2 = 1; D3 = 0; S0 = 0; S1 = 1;
    #10 D0 = 0; D1 = 0; D2 = 0; D3 = 1; S0 = 1; S1 = 1;
  end
  
  initial #40 $finish;
endmodule
  
