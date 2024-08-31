module t_flip_flop(t, clk, rst, q, qbar);
  input t, clk, rst;
  output q, qbar;
  reg q;
  
  always @(posedge clk or posedge rst)
  begin
    if (rst)
      q = 1'b0;
    else if (t == 1'b0)
      q = q;
    else if (t == 1'b1)
      q = ~q;
  end
  assign qbar = ~q;
endmodule

module t_tb;
  reg t, clk, rst;
  wire q, qbar;
  
  t_flip_flop tb(t, clk, rst, q, qbar);
  
  always
    #5 clk = ~clk;
  
  initial
  begin
   clk=1'b0; rst=1'b1; t=1'b0;
    #10 rst=1'b0;
    #10 t=1'b1;
    #30 $stop;
  end
endmodule
