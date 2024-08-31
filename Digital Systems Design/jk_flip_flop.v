module jk_flip_flop(j, k, clk, rst, q, qbar);
  input j, k, clk, rst;
  output q, qbar;
  reg q
  
  always @ (posedge clk or posedge rst)
  begin
    if (rst)
      q <= 1'b0;
    else if (j == 1'b0 && k == 1'b0)
      q <= q;
    else if (j == 1'b0 && k == 1'b1)
      q <= 1'b0;
    else if (j == 1'b1 && k == 1'b0)
      q <= 1'b1;
    else if (j == 1'b1 && k == 1'b1)
      q <= ~q;
  end
  assign qbar = ~q;
endmodule

module jk_tb;
  reg j, k, clk, rst;
  wire q, qbar;
  
  jk_flip_flop tb(j, k, clk, rst, q, qbar);
  
  always
  #5 clk=~clk;
  
  initial
  begin
    clk=1'b0; rst=1'b1; j=1'b0; k=1'b0;
    #10 rst=1'b0;
    #10 j=1'b0; k=1'b1;
    #10 j=1'b1; k=1'b0;
    #10 j=1'b1; k=1'b1;    
    #50 $stop;
  end
endmodule