module d_flip_flop(d, clk, rst, q, qbar);
  input d, clk, rst;
  output q, qbar;
  reg q;

  always @(posedge clk or posedge rst)
  begin
    if (rst)
      q <= 1'b0;
    else if (d == 1'b0)
      q <= 1'b0;
    else if (d == 1'b1)
      q <= 1'b1;
  end
  assign qbar = ~q;
endmodule


module d_tb;
  reg d, clk, rst;
  wire q, qbar;
  
  d_flip_flop tb(d, clk, rst, q, qbar);
  
  always
  #5 clk=~clk;
  
  initial
  begin
    clk=1'b0; rst=1'b1; d=1'b0;
    #10 rst=1'b0;
    #10 d=1'b1;
    #30 $stop;
  end
endmodule


