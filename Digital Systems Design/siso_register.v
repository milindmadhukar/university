module siso(so, si, clk, rst);
  output so;
  input si, clk, rst;
  reg [3:0]q;
  always @ (posedge clk or posedge rst)
  begin
    if (rst)
      q <= 4'b0;
    else
      q <= {si, q[3:1]};
  end
  assign so = q[0];
endmodule

module siso_tb;
  wire so;
  reg si, clk, rst;
  
  siso tb(so, si, clk, rst);
  
  always
  #5 clk = ~clk;
  
  initial
  begin
    si = 0; clk = 0; rst = 1;
    #10 rst = 0;
    #10 si = 1;
    #10 si = 0;
    #10 si = 0;
    #40 $stop;
  end
endmodule