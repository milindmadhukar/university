  module sr_flip_flop(s, r, clk, rst, q, qbar);
  input s, r, clk, rst;
  output q, qbar;
  reg q;
  
  always @ (posedge clk or posedge rst)
  begin
    if (rst)
      q <= 1'b0;
    else if (s == 1'b0 && r == 1'b0)
      q <= q;
    else if (s == 1'b0 && r == 1'b1)
      q <= 1'b0;
    else if (s == 1'b1 && r == 1'b0)
      q <= 1'b1;
    else if (s == 1'b1 && r == 1'b1)
      q <= 1'bx;
  end

  assign qbar = ~q;
endmodule

module sr_tb;
  reg s, r, clk, rst;
  wire q, qbar;
  
  sr_flip_flop tb(s, r, clk, rst, q, qbar);
  
  always
  #5 clk=~clk;
  
  initial
  begin
    clk=1'b0; rst=1'b1; s=1'b0; r=1'b1;
    #10 rst=1'b0;
    #10 s=1'b1; r=1'b0;
    #10 s=1'b0; r=1'b1;
    #10 s=1'b1; r=1'b1;
    #50 $stop;
  end
endmodule

